package quizsystem.gui.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import quizsystem.gui.abs.AbstractWindowMenu;

public class StudentWindowMenu extends AbstractWindowMenu {
		
	private static final long serialVersionUID = 1L;

	public StudentWindowMenu() {
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem openFile = new JMenuItem("Open test file");
		JMenuItem saveFile = new JMenuItem("Save test file");
		JMenuItem closeProgram = new JMenuItem("Close");
		
		openFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		saveFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(new JSeparator());
		fileMenu.add(closeProgram);
		
		subMenus.add(fileMenu);	
		
		createMenu();
	}	
}