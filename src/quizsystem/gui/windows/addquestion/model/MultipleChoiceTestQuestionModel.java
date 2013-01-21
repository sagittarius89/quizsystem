package quizsystem.gui.windows.addquestion.model;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import quizsystem.gui.windows.addquestion.controller.MultipleChoiceTestController;
import quizsystem.types.MultipleChoiceTestQuestion;

public class MultipleChoiceTestQuestionModel  extends AddQuestionModelAbstract 
{
	
	public MultipleChoiceTestQuestionModel () {
		this.question = new MultipleChoiceTestQuestion();
	}
	
	public void addAnswer(String answer) {
		((MultipleChoiceTestQuestion)question).addAnswer(answer);
		firePropertyAdded(MultipleChoiceTestController.ANSWER, answer);
	}
	
	public void removeAnswer(Integer i) {
		((MultipleChoiceTestQuestion)question).deleteAnswer(i);
		firePropertyRemoved(MultipleChoiceTestController.ANSWER, i);
	}
	
	public void putAnswer(Integer i, String answer) {
		String oldValue = ((MultipleChoiceTestQuestion)question).getAnswers().get(i);
		((MultipleChoiceTestQuestion)question).getAnswers().add(i, answer);
		firePropertySet(MultipleChoiceTestController.ANSWER_PUT, i, oldValue, answer);
	}
	
	public String getAnswer(Integer i) {
		return ((MultipleChoiceTestQuestion)question).getAnswers().get(i);
	}
	
	public ArrayList<String> getAnswers() {
		return ((MultipleChoiceTestQuestion)question).getAnswers();
	}
	
	public void toggleAnswer(Integer i) {
		boolean oldKey = ((MultipleChoiceTestQuestion)question).getKeys().get(i);
		((MultipleChoiceTestQuestion)question).setKey(i, !oldKey);
		firePropertySet(MultipleChoiceTestController.KEY, i, oldKey, !oldKey);
	}
	
	public void setAnswer(Integer i, String answer) {
		String oldValue = ((MultipleChoiceTestQuestion)question).getAnswers().get(i);
		((MultipleChoiceTestQuestion)question).setAnswer(i, answer);
		firePropertySet(MultipleChoiceTestController.ANSWER_SET, i, oldValue, answer);
	}
	
}
