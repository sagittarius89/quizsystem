package quizsystem.gui.panels.previewpanel;


import quizsystem.gui.model.StudentModel;
import quizsystem.gui.controller.StudentController;
import quizsystem.gui.abs.AbstractPanel;
import quizsystem.gui.panels.previewpanel.view.StudentPreviewView;

public class StudentPreviewPanel extends AbstractPanel {
	
	public StudentPreviewPanel(StudentModel model, StudentController controller) {
		this.model = model;
		this.controller = controller;
		view = new StudentPreviewView(model);
	}
	
}
