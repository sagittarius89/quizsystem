package quizsystem;

import quizsystem.gui.StudentWindow;
import quizsystem.gui.abs.AbstractWindow;
import quizsystem.types.Test;

public class Student {
		private static Student student;
		
		private AbstractWindow gui;	
		private Test test;
		
		
		public Student() {
			student = this;
			initGui();
		}	
		
		//creates gui thread
		private void initGui() {
			(new Thread() {
				
				@Override 
				public void run() {
					gui = new StudentWindow();
				}
			}).start();
		}
		
		public Test getTest() {
			return this.test;
		}
		
		public static Student getInstance() {
			return student;
		}
		
		public static void main(String [] args) {
			Student student = new Student();
		}
}