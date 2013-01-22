package quizsystem.gui.model;

import java.util.ArrayList;
import java.util.Date;

import quizsystem.gui.abs.AbstractModel;
import quizsystem.gui.controller.StudentController;
import quizsystem.types.AbstractQuestion;
import quizsystem.types.Test;

public class StudentModel extends AbstractModel {
	private Test test;
	
	public StudentModel() {
		test = new Test();
	}
	
	public void setName(String name) {
		String oldValue = test.getName();
		test.setName(name);
		firePropertyChange(StudentController.NAME, oldValue, name);
	}
	
	public void setAuthor(String author) {
		String oldValue = test.getAuthor();
		test.setAuthor(author);
		firePropertyChange(StudentController.AUTHOR, oldValue, author);
	}
	
	public void setCreateTime(Date date) {
		Date oldValue = test.getCreateTime();
		test.setCreateTime(date);
		firePropertyChange(StudentController.CREATE_TIME, oldValue, date);
	}
	
	public void setStartTime(Date date) {
		Date oldValue = test.getStartTime();
		test.setStartTime(date);
		firePropertyChange(StudentController.START_TIME, oldValue, date);
	}
	
	public void setTestTime(Integer time) {
		Integer oldValue = test.getTestTime();
		test.setTestTime(time);
		firePropertyChange(StudentController.TEST_TIME, oldValue, time);
	}
	
	public void addQuestion(AbstractQuestion question) {
		test.addQuestion(question);
		firePropertyAdded(StudentController.QUESTION, question);
	}
	
	public void setQuestion(Integer i, AbstractQuestion q) {
		AbstractQuestion oldValue = test.getQuestions().get(i);
		test.setQuestion(i, q);
		firePropertyChange(StudentController.QUESTION, oldValue, q);
		
	}
	
	public void removeQuestion(Integer i) {
		AbstractQuestion oldValue = test.getQuestions().get(i);
		test.removeQuestion(i);
		firePropertyRemoved(StudentController.QUESTION, oldValue);
	}
	
	public void removeQuestion(AbstractQuestion question) {
		test.removeQuestion(question);
		firePropertyRemoved(StudentController.QUESTION, question);
	}
	
	public String getName() {
		return test.getName();
	}
	
	public String getAuthor() {
		return test.getAuthor();
	}
	
	public Date getCreateTime() {
		return test.getCreateTime();
	}
	
	public Date getStartTime() {
		return test.getStartTime();
	}
	
	public Integer getTestTime() {
		return test.getTestTime();
	}
	
	public ArrayList<AbstractQuestion> getQuestions() {
		return test.getQuestions();
	}
	
	public AbstractQuestion getQuestionAt(Integer i) {
		return test.getQuestions().get(i);
	}
	
	
}
