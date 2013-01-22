package quizsystem.gui.panels.previewbar;

import quizsystem.gui.abs.AbstractPanel;
import quizsystem.gui.controller.TeacherController;
import quizsystem.gui.model.TeacherModel;
import quizsystem.gui.panels.previewbar.view.PreviewBarView;

public class PreviewBar extends AbstractPanel {
	public PreviewBar(TeacherModel model, TeacherController controller) {
		this.model = model;
		this.controller = controller;
		this.view = new PreviewBarView(model);
	}

}
