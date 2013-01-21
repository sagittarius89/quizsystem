package quizsystem.gui.windows.addquestion.model;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import quizsystem.gui.windows.addquestion.controller.SingleChoiceTestController;
import quizsystem.types.SingleChoiceTestQuestion;

public class SingleChoiceTestQuestionModel  extends AddQuestionModelAbstract 
{
	
	public SingleChoiceTestQuestionModel () {
		this.question = new SingleChoiceTestQuestion();
	}
	
	public void addAnswer(String answer) {
		((SingleChoiceTestQuestion)question).addAnswer(answer);
		firePropertyAdded(SingleChoiceTestController.ANSWER, answer);
	}
	
	public void removeAnswer(Integer i) {
		((SingleChoiceTestQuestion)question).deleteAnswer(i);
		firePropertyRemoved(SingleChoiceTestController.ANSWER, i);
	}
	
	public void putAnswer(Integer i, String answer) {
		String oldValue = ((SingleChoiceTestQuestion)question).getAnswers().get(i);
		((SingleChoiceTestQuestion)question).getAnswers().add(i, answer);
		firePropertySet(SingleChoiceTestController.ANSWER_PUT, i, oldValue, answer);
	}
	
	public String getAnswer(Integer i) {
		return ((SingleChoiceTestQuestion)question).getAnswers().get(i);
	}
	
	public ArrayList<String> getAnswers() {
		return ((SingleChoiceTestQuestion)question).getAnswers();
	}
	
	public void setCorrectAnswer(Integer i) {
		int oldValue = ((SingleChoiceTestQuestion)question).getKey();
		((SingleChoiceTestQuestion)question).setKey(i);
		firePropertyChange(SingleChoiceTestController.KEY, oldValue, i);
	}
	
	public void setAnswer(Integer i, String answer) {
		String oldValue = ((SingleChoiceTestQuestion)question).getAnswers().get(i);
		((SingleChoiceTestQuestion)question).setAnswer(i, answer);
		firePropertySet(SingleChoiceTestController.ANSWER_SET, i, oldValue, answer);
	}
	
	public Integer getCorrectAnswer() {
		return ((SingleChoiceTestQuestion)question).getKey();
	}
	
}
