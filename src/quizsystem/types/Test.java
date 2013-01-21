package quizsystem.types;

import java.util.ArrayList;
import java.util.Date;

public class Test {
	private String name;
	private String author;
	
	private Date createTime;
	private Date startTime;
	private Integer testTime;
	
	private ArrayList<AbstractQuestion> questions;
	
	public Test() {
		questions = new ArrayList<AbstractQuestion>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getTestTime() {
		return testTime;
	}

	public void setTestTime(Integer testTime) {
		this.testTime = testTime;
	}

	public ArrayList<AbstractQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<AbstractQuestion> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(AbstractQuestion question) {
		questions.add(question);
	}
	
	public void setQuestion(Integer i, AbstractQuestion question) {
		questions.set(i, question);
	}
	
	public void removeQuestion(Integer i) {
		questions.remove(i);
	}
	
	public void removeQuestion(AbstractQuestion question) {
		questions.remove(question);
	}
}
