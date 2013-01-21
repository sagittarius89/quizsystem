package quizsystem.gui.windows.addquestion.model;

import java.awt.Image;

import quizsystem.gui.abs.AbstractModel;
import quizsystem.gui.windows.addquestion.controller.AddQuestionControllerAbstract;
import quizsystem.types.AbstractQuestion;

abstract public class AddQuestionModelAbstract extends AbstractModel{
	protected AbstractQuestion question;
	
	public void setQuestionText(String text) {
		String oldValue = question.getQuestion();
		question.setQuestion(text);
		firePropertyChange(AddQuestionControllerAbstract.QUESTION_TEXT, oldValue, text);
	}
	
	public void setImage(Image image) {
		Image oldValue = question.getImage();
		question.setImage(image);
		firePropertyChange(AddQuestionControllerAbstract.IMAGE, oldValue, image);
	}
	
	public void setPoints(Integer points) {
		Integer oldValue = question.getPoints();
		question.setPoints(points);
		firePropertyChange(AddQuestionControllerAbstract.POINTS, oldValue, points);
	}
	
	public AbstractQuestion getQuestion() {
		return question;
	}
}
