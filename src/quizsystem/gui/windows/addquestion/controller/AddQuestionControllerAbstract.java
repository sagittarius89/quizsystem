package quizsystem.gui.windows.addquestion.controller;

import java.awt.Image;

import quizsystem.gui.abs.AbstractController;
import quizsystem.gui.windows.addquestion.model.AddQuestionModelAbstract;

abstract public class AddQuestionControllerAbstract extends AbstractController {
	public static final String QUESTION_TEXT = "QuestionText";
	public static final String IMAGE = "Image";
	public static final String POINTS = "Points";
	
	public void setQuestionText(String text) {
		setModelProperty(QUESTION_TEXT, text);
	}
	
	public void setImage(Image image) {
		((AddQuestionModelAbstract) this.model).setImage(image);
	}
	
	public void setPoints(Integer points) {
		setModelProperty(POINTS, points);
	}
}
