package quizsystem.types;

import java.util.ArrayList;

public class MultipleChoiceTestQuestion extends AbstractQuestion {
	private ArrayList<String> answers;
	private ArrayList<Boolean> key;
	
	public MultipleChoiceTestQuestion(String question, ArrayList<String> answers, 
			ArrayList<Boolean> key) {
		super(question);
		
		this.answers = answers;
		this.key = key;
		
		if(answers.size() > key.size()) {
			for(int i=answers.size()-1; i<key.size(); ++i)
				key.add(false);
		} else if(answers.size() < key.size()) {
			for(int i=key.size()-1; i>answers.size()-1; --i)
				key.remove(i);
		}
	}
	
	public MultipleChoiceTestQuestion() {
		answers = new ArrayList<String>();
		key = new ArrayList<Boolean>();
	}
	
	public void addAnswer(String answer) {
		this.answers.add(answer);
		this.key.add(false);
	}
	
	public void addAnswer(String answer, Boolean b) {
		this.answers.add(answer);
		this.key.add(b);
	}
	
	public void deleteAnswer(int i) {
		try {
			this.answers.remove(i);
		} catch (IndexOutOfBoundsException e) {
			return;
		}
		
		this.key.remove(i);
	}
	
	public void setAnswer(int i, String answer) {
		this.answers.set(i, answer);
	}
	
	public void setKey(int i, Boolean b) {
		this.key.set(i, b);
	}

	public ArrayList<String> getAnswers() {
		return this.answers;
	}
	
	public ArrayList<Boolean> getKeys() {
		return this.key;
	}
}
