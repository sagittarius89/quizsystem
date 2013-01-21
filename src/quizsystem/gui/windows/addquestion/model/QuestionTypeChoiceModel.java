package quizsystem.gui.windows.addquestion.model;

import quizsystem.gui.abs.AbstractModel;
import quizsystem.gui.windows.addquestion.controller.QuestionTypeChoiceController;

public class QuestionTypeChoiceModel extends AbstractModel{
	private Integer choice = 0;

	public Integer getChoice() {
		return choice;
	}

	public void setChoice(Integer choice) {
		Integer oldValue = this.choice;
		this.choice = choice;
		firePropertyChange(QuestionTypeChoiceController.CHOICE, oldValue, choice);
	}
	
}
