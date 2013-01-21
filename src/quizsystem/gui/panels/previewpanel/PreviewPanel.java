package quizsystem.gui.panels.previewpanel;

import quizsystem.Teacher;
import quizsystem.gui.abs.AbstractPanel;
import quizsystem.gui.controller.TeacherController;
import quizsystem.gui.model.TeacherModel;
import quizsystem.gui.panels.previewpanel.view.PreviewView;

public class PreviewPanel extends AbstractPanel {
	
	public PreviewPanel(TeacherModel model, TeacherController controller) {
		this.model = model;
		this.controller = controller;
		view = new PreviewView();
	}
	
}
