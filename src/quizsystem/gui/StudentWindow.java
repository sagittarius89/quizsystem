package quizsystem.gui;

import quizsystem.gui.abs.AbstractWindow;

public class StudentWindow extends AbstractWindow {
	
	private static final long serialVersionUID = 1L;

	public StudentWindow() {
		super("Student");
	}

	@Override
	public void init() {
		
		
	}

	@Override
	public void dispose() {
		System.exit(0);
	}
}

