package quizsystem;

import quizsystem.gui.TeacherWindow;
import quizsystem.gui.abs.AbstractWindow;

public class Teacher {
	private AbstractWindow gui;
	
	public Teacher() {
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
	
	public static void main(String [] args) {
		Teacher teacher = new Teacher();
	}
}
