package quizsystem.gui;

import quizsystem.gui.abs.AbstractWindow;
import quizsystem.gui.menus.TeacherWindowMenu;

public class TeacherWindow extends AbstractWindow {
	
	private TeacherWindowMenu windowMenu;
	
	public TeacherWindow() {
		super("Teacher");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		windowMenu = new TeacherWindowMenu();
		
		
		setJMenuBar(windowMenu);
	}

	@Override
	public void dispose() {
		
		System.exit(0);
	}

}
