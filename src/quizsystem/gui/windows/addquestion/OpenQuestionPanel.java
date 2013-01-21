package quizsystem.gui.windows.addquestion;

import quizsystem.gui.abs.AbstractPanel;
import quizsystem.gui.windows.addquestion.controller.OpenQuestionController;
import quizsystem.gui.windows.addquestion.model.OpenQuestionModel;
import quizsystem.gui.windows.addquestion.view.OpenQuestionView;

public class OpenQuestionPanel extends AbstractPanel{
	public OpenQuestionPanel() {
		model = new OpenQuestionModel();
		controller = new OpenQuestionController();
		view = new OpenQuestionView((OpenQuestionController)controller, (OpenQuestionModel)model);
		
		controller.addModel(model);
		controller.addView(view);
		
	}
}
