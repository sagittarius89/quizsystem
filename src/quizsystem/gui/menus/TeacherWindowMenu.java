package quizsystem.gui.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import quizsystem.gui.abs.AbstractWindowMenu;

//This class contains temporary code, need to change structure
public class TeacherWindowMenu extends AbstractWindowMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeacherWindowMenu() {
		JMenu fileMenu = new JMenu("Plik");
		
		JMenuItem newFile = new JMenuItem("Nowy test");
		JMenuItem openFile = new JMenuItem("Otwórz test");
		JMenuItem saveFile = new JMenuItem("Zapisz test");
		JMenuItem closeProgram = new JMenuItem("Zakoñcz program");
		
		fileMenu.add(newFile);
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(new JSeparator());
		fileMenu.add(closeProgram);
		
		subMenus.add(fileMenu);	
		
		createMenu();
	}
	
}
