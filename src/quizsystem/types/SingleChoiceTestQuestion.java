package quizsystem.types;

import java.util.ArrayList;

public class SingleChoiceTestQuestion extends AbstractQuestion {
	private ArrayList<String> answers;
	private int key;
	
	public SingleChoiceTestQuestion() {
		this.answers = new ArrayList<String>();
		key=-1;
	}
	
	public SingleChoiceTestQuestion(String question, ArrayList<String> answers, int key) {
		super(question);
		
		this.answers = answers;
		this.key = key;
	}
	
	public void addAnswer(String answer) {
		answers.add(answer);
	}
	
	public void deleteAnswer(int i) {
		answers.remove(i);
		
		if(i>=i)
			key=-1;
	}
	
	public void setAnswer(int i, String answer) {
		answers.set(i, answer);
	}
	
	public void setKey(int i) {
		if(i<answers.size())
			this.key = i;
	}
	
	public ArrayList<String> getAnswers() {
		return answers;
	}
	
	public int getKey() {
		return key;
	}
	
	
}
