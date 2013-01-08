package quizsystem.types;

import java.util.ArrayList;

public class MultipleChoiceTestQuestion extends AbstractQuestion{
	private ArrayList<String> anwsers;
	private ArrayList<Boolean> key;
	
	public MultipleChoiceTestQuestion(String question, ArrayList<String> anwsers, 
			ArrayList<Boolean> key) {
		super(question);
		
		this.anwsers = anwsers;
		this.key = key;
		
		if(anwsers.size() > key.size()) {
			for(int i=anwsers.size()-1; i<key.size(); ++i)
				key.add(false);
		} else if(anwsers.size() < key.size()) {
			for(int i=key.size()-1; i>anwsers.size()-1; --i)
				key.remove(i);
		}
	}
	
	public MultipleChoiceTestQuestion() {
		anwsers = new ArrayList<String>();
		key = new ArrayList<Boolean>();
	}
	
	public void addAnswer(String answer) {
		this.anwsers.add(answer);
		this.key.add(false);
	}
	
	public void addAnswer(String answer, Boolean b) {
		this.anwsers.add(answer);
		this.key.add(b);
	}
	
	public void deleteAnswer(int i) {
		try {
			this.anwsers.remove(i);
		} catch (IndexOutOfBoundsException e) {
			return;
		}
		
		this.key.remove(i);
	}
	
	public void setAnswer(int i, String answer) {
		this.anwsers.set(i, answer);
	}
	
	public void setKey(int i, Boolean b) {
		this.key.set(i, b);
	}

	public ArrayList<String> getAnswers() {
		return this.anwsers;
	}
	
	public ArrayList<Boolean> getKeys() {
		return this.key;
	}
}
