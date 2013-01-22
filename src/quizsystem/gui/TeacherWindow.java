package quizsystem.gui;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import quizsystem.gui.model.TeacherModel;
import quizsystem.gui.abs.AbstractWindow;
import quizsystem.gui.controller.TeacherController;
import quizsystem.gui.menus.TeacherWindowMenu;
import quizsystem.gui.panels.previewbar.PreviewBar;
import quizsystem.gui.panels.previewpanel.PreviewPanel;
import quizsystem.gui.abs.AbstractPanel;
import quizsystem.types.OpenQuestion;

public class TeacherWindow extends AbstractWindow {
	
	private TeacherWindowMenu windowMenu;
	private PreviewPanel previewPanel;
	private PreviewBar previewBar;
	
	public TeacherWindow() {
		super("Teacher");
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		this.panels = new ArrayList<AbstractPanel>();
		windowMenu = new TeacherWindowMenu();		
		model = new TeacherModel();
		controller = new TeacherController();
		controller.addModel(model);
		
		setJMenuBar(windowMenu);
		
		//((TeacherModel) model).addQuestion(new OpenQuestion("jakieś pytanie, żeby się nie wysypywało"));
		
		previewPanel = new PreviewPanel((TeacherModel)model, (TeacherController)controller);
		previewBar = new PreviewBar((TeacherModel)model, (TeacherController)controller);
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
