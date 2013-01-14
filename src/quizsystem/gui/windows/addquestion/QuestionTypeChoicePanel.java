package quizsystem.gui.windows.addquestion;

import quizsystem.gui.abs.AbstractPanel;
import quizsystem.gui.windows.addquestion.controller.QuestionTypeChoiceController;
import quizsystem.gui.windows.addquestion.model.QuestionTypeChoiceModel;
import quizsystem.gui.windows.addquestion.view.QuestionTypeChoiceView;

public class QuestionTypeChoicePanel extends AbstractPanel {
	public QuestionTypeChoicePanel() {
		model = new QuestionTypeChoiceModel();
		controller = new QuestionTypeChoiceController();
		view = new QuestionTypeChoiceView((QuestionTypeChoiceController)controller);
		
		controller.addModel(model);
		controller.addView(view);
	}

}
