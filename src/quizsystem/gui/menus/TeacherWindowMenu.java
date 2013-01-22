package quizsystem.gui.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import quizsystem.Teacher;
import quizsystem.gui.abs.AbstractWindowMenu;
import quizsystem.gui.windows.addquestion.AddQuestionWizardWindow;

//This class contains temporary code, need to change structure
public class TeacherWindowMenu extends AbstractWindowMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeacherWindowMenu() {
		final JMenu fileMenu = new JMenu("File");
		
		JMenuItem newFile = new JMenuItem("New test");
		JMenuItem openFile = new JMenuItem("Open test");
		JMenuItem saveFile = new JMenuItem("Save test");
		JMenuItem closeProgram = new JMenuItem("Close");
		
		JMenu testMenu = new JMenu("Test");
		
		JMenuItem questionWizard = new JMenuItem("Add question wizard");
		
		openFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser dialog = new JFileChooser();
				int result = dialog.showOpenDialog(fileMenu);
				if(result == JFileChooser.APPROVE_OPTION) {
					Teacher.getInstance()
						.loadTest(dialog.getSelectedFile().getPath());
				}
			}
		});
		
		saveFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser dialog = new JFileChooser();
				int result = dialog.showSaveDialog(fileMenu);
				if(result == JFileChooser.APPROVE_OPTION) {
					Teacher.getInstance()
						.saveTest(dialog.getSelectedFile().getPath());
				}
			}
		});
		
		closeProgram.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		newFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 int result = JOptionPane.showConfirmDialog(fileMenu, "Are you sure to close this file?");
				 if(result == 1) {
					 Teacher.getInstance().newTest();
				 }
			}
		});
		
		questionWizard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddQuestionWizardWindow window = new AddQuestionWizardWindow();
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
