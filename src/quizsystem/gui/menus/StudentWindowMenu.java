package quizsystem.gui.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import quizsystem.Student;
import quizsystem.Teacher;
import quizsystem.gui.abs.AbstractWindowMenu;

public class StudentWindowMenu extends AbstractWindowMenu {
		
	private static final long serialVersionUID = 1L;

	public StudentWindowMenu() {
		final JMenu fileMenu = new JMenu("File");
		
		JMenuItem openFile = new JMenuItem("Open test file");
		JMenuItem saveFile = new JMenuItem("Save test file");
		JMenuItem closeProgram = new JMenuItem("Close");
		
		openFile.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser dialog = new JFileChooser();
				int result = dialog.showOpenDialog(fileMenu);
				if(result == JFileChooser.APPROVE_OPTION) {
					Student.getInstance()
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
					Student.getInstance()
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
		
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(new JSeparator());
		fileMenu.add(closeProgram);
		
		subMenus.add(fileMenu);	
		
		createMenu();
	}	
}
