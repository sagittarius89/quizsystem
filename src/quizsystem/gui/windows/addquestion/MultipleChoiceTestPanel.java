package quizsystem.gui.windows.addquestion;

import quizsystem.gui.abs.AbstractPanel;
import quizsystem.gui.windows.addquestion.controller.MultipleChoiceTestController;
import quizsystem.gui.windows.addquestion.model.MultipleChoiceTestQuestionModel;
import quizsystem.gui.windows.addquestion.view.MultipleChoiceTestQuestionView;

public class MultipleChoiceTestPanel extends AbstractPanel {
	public MultipleChoiceTestPanel () {
		model = new MultipleChoiceTestQuestionModel();
		controller = new MultipleChoiceTestController();
		view = new MultipleChoiceTestQuestionView((MultipleChoiceTestController)controller, 
					(MultipleChoiceTestQuestionModel)model);
		
		controller.addView(view);
		controller.addModel(model);
	}
}
