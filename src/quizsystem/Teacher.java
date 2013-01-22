package quizsystem;

import java.io.File;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import quizsystem.gui.TeacherWindow;
import quizsystem.gui.abs.AbstractWindow;
import quizsystem.gui.controller.TeacherController;
import quizsystem.gui.model.TeacherModel;
import quizsystem.types.Test;

public class Teacher {
	private static Teacher teacher;

	private AbstractWindow gui;

	public Teacher() {
		teacher = this;
		initGui();
	}

	// creates gui thread
	private void initGui() {
		(new Thread() {

			@Override
			public void run() {
				gui = new TeacherWindow();
			}
		}).start();
	}

	public void newTest() {
			getModel().newTest();
	}
	
	public void loadTest(String path) {
		try {
			File file = new File(path);
			getModel();
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Test.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			getModel().setTest((Test) jaxbUnmarshaller.unmarshal(file));
	 
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}

	public void saveTest(String path) {
		try {
			File file = new File(path);

			//Tu jest brzydko:
			Test test = getModel().test;
			JAXBContext jaxbContext = JAXBContext.newInstance(Test.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 
			//Bardziej czytelny output:
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 
			jaxbMarshaller.marshal(test, file);
				 
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public TeacherModel getModel() {
		return (TeacherModel) gui.getModel();
	}

	public TeacherController getController() {
		return (TeacherController) gui.getController();
	}

	public static Teacher getInstance() {
		return teacher;
	}

	public static void main(String[] args) {
		Teacher teacher = new Teacher();
	}
}
