package quizsystem;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import quizsystem.gui.StudentWindow;
import quizsystem.gui.abs.AbstractWindow;
import quizsystem.gui.controller.StudentController;
import quizsystem.gui.model.StudentModel;
import quizsystem.types.Test;

public class Student {
		private static Student student;
		
		private AbstractWindow gui;

		public Student() {
			student = this;
			initGui();
		}

		// creates gui thread
		private void initGui() {
			(new Thread() {

				@Override
				public void run() {
					gui = new StudentWindow();
				}
			}).start();
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
				Test test = getModel().getTest();
				JAXBContext jaxbContext = JAXBContext.newInstance(Test.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			 
				//Bardziej czytelny output:
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			 
				jaxbMarshaller.marshal(test, file);
				 
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}

		public StudentModel getModel() {
			return (StudentModel) gui.getModel();
		}

		public StudentController getController() {
			return (StudentController) gui.getController();
		}

		public static Student getInstance() {
			return student;
		}

		public static void main(String[] args) {
			Student teacher = new Student();
		}
		
}