package quizsystem;

import quizsystem.gui.TeacherWindow;
import quizsystem.gui.abs.AbstractWindow;
import quizsystem.types.Test;

public class Teacher {
	private static Teacher teacher;
	
	private AbstractWindow gui;	
	private Test test;
	
	
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
	
	public Test getTest() {
		return this.test;
	}
	
	public static Teacher getInstance() {
		return teacher;
	}
	
	public static void main(String [] args) {
		Teacher teacher = new Teacher();
	}
}
