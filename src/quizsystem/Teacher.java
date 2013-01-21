package quizsystem;

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
	
	//creates gui thread
	private void initGui() {
		(new Thread() {
			
			@Override 
			public void run() {
				gui = new TeacherWindow();
			}
		}).start();
	}
	
	public void loadTest(String path) {
		//todo
	}
	
	public void createTest() {
		//todo
	}
	
	public void saveTest(String path) {
		//todo
	}
	
	public TeacherModel getModel() {
		return (TeacherModel)gui.getModel();
	}
	
	public TeacherController getController() {
		return (TeacherController)gui.getController();
	}
	
	public static Teacher getInstance() {
		return teacher;
	}
	
	public static void main(String [] args) {
		Teacher teacher = new Teacher();
	}
}
