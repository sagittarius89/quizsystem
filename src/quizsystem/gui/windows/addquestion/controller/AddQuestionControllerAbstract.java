package quizsystem.gui.windows.addquestion.controller;

import java.awt.Image;

import quizsystem.gui.abs.AbstractController;

abstract public class AddQuestionControllerAbstract extends AbstractController {
	public static final String QUESTION_TEXT = "QuestionText";
	public static final String IMAGE = "Image";
	public static final String POINTS = "Points";
	
	public void setQuestionText(String text) {
		setModelProperty(QUESTION_TEXT, text);
	}
	
	public void setImage(Image image) {
		setModelProperty(IMAGE, image);
	}
	
	public void setPoints(Integer points) {
		setModelProperty(POINTS, points);
	}
}
