package quizsystem.gui.windows.addquestion.model;

import quizsystem.gui.windows.addquestion.controller.OpenQuestionController;
import quizsystem.types.OpenQuestion;

public class OpenQuestionModel extends AddQuestionModelAbstract{
	
	public OpenQuestionModel() {
		this.question = new OpenQuestion("");
	}

	public String getKeyText() {
		return ((OpenQuestion)this.question).getKey();
	}

	public void setKeyText(String keyText) {
		String oldValue = ((OpenQuestion)this.question).getKey();
		((OpenQuestion)this.question).setKey(keyText);
		firePropertyChange(OpenQuestionController.KEY_TEXT, oldValue, keyText);
	}
}
