package quizsystem.types;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({AbstractQuestion.class, OpenQuestion.class, SingleChoiceTestQuestion.class, MultipleChoiceTestQuestion.class})
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

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateTime() {
		return createTime;
	}

	@XmlElement
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	@XmlElement
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getTestTime() {
		return testTime;
	}

	@XmlElement
	public void setTestTime(Integer testTime) {
		this.testTime = testTime;
	}

	public ArrayList<AbstractQuestion> getQuestions() {
		return questions;
	}

	@XmlElement
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
