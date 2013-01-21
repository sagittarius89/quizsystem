package quizsystem.gui.windows.addquestion;

import quizsystem.gui.abs.AbstractPanel;
import quizsystem.gui.windows.addquestion.controller.SingleChoiceTestController;
import quizsystem.gui.windows.addquestion.model.SingleChoiceTestQuestionModel;
import quizsystem.gui.windows.addquestion.view.SingleChoiceTestQuestionView;

public class SingleChoiceTestPanel extends AbstractPanel {
	public SingleChoiceTestPanel () {
		model = new SingleChoiceTestQuestionModel();
		controller = new SingleChoiceTestController();
		view = new SingleChoiceTestQuestionView((SingleChoiceTestController)controller, 
					(SingleChoiceTestQuestionModel)model);
		
		controller.addView(view);
		controller.addModel(model);
	}
}
