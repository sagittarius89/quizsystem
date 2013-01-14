package quizsystem.gui.windows.addquestion.controller;

import quizsystem.gui.abs.AbstractController;

public class QuestionTypeChoiceController extends AbstractController{
	public static final String CHOICE = "Choice";
	
	public void setChoice(Integer choice) {
		setModelProperty(CHOICE, choice);
	}
}
