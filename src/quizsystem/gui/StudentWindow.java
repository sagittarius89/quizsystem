package quizsystem.gui;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import quizsystem.Student;
import quizsystem.gui.abs.AbstractPanel;
import quizsystem.gui.abs.AbstractWindow;
import quizsystem.gui.controller.StudentController;
import quizsystem.gui.menus.StudentWindowMenu;
import quizsystem.gui.model.StudentModel;
import quizsystem.gui.panels.previewbar.StudentPreviewBar;
import quizsystem.gui.panels.previewpanel.StudentPreviewPanel;
import quizsystem.types.OpenQuestion;
import quizsystem.types.SingleChoiceTestQuestion;

public class StudentWindow extends AbstractWindow {
	
	private static final long serialVersionUID = 1L;

	private StudentWindowMenu windowMenu;
	private StudentPreviewPanel previewPanel;
	private StudentPreviewBar previewBar;
	
	public StudentWindow() {
		super("Student");
	}

	@Override
	public void init() {
		this.panels = new ArrayList<AbstractPanel>();
		windowMenu = new StudentWindowMenu();		
		model = new StudentModel();
		controller = new StudentController();
		controller.addModel(model);
		
		setJMenuBar(windowMenu);
		
		//((StudentModel) model).addQuestion(new OpenQuestion("jakieś pytanie, żeby się nie wysypywało"));
		
		previewPanel = new StudentPreviewPanel((StudentModel)model, (StudentController)controller);
		previewBar = new StudentPreviewBar((StudentModel)model, (StudentController)controller);
		JPanel panel2 = new JPanel();
		JScrollPane panel1 = new JScrollPane(previewBar.getView());
		panel2.setLayout(new FlowLayout());
		panel2.add(previewPanel.getView());
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
				panel1, panel2);
		
		this.addPanel(previewPanel);
		this.addPanel(previewBar);
		this.add(splitPane);
	}

	@Override
	public void dispose() {
		System.exit(0);
	}
}