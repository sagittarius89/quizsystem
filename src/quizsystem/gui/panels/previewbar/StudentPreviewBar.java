package quizsystem.gui.panels.previewbar;

import quizsystem.gui.abs.AbstractPanel;
import quizsystem.gui.controller.StudentController;
import quizsystem.gui.model.StudentModel;
import quizsystem.gui.panels.previewbar.view.PreviewBarView;
import quizsystem.gui.panels.previewbar.view.StudentPreviewBarView;

public class StudentPreviewBar extends AbstractPanel {
	public StudentPreviewBar(StudentModel model, StudentController controller) {
		this.model = model;
		this.controller = controller;
		this.view = new StudentPreviewBarView(model);
	}

}
