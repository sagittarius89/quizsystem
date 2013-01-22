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
		
		JMenuItem newFile = new JMenuItem("New test");
		JMenuItem openFile = new JMenuItem("Open test");
		JMenuItem saveFile = new JMenuItem("Save test");
		JMenuItem closeProgram = new JMenuItem("Close");
		
		JMenu testMenu = new JMenu("Test");
		
		JMenuItem questionWizard = new JMenuItem("Add question wizard");
		
		newFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		questionWizard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//AddQuestionWizardWindow window = new AddQuestionWizardWindow();
			}
		});
		
		fileMenu.add(newFile);
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(new JSeparator());
		fileMenu.add(closeProgram);
		
		testMenu.add(questionWizard);
		
		subMenus.add(fileMenu);	
		subMenus.add(testMenu);
		
		createMenu();
	}	
}
