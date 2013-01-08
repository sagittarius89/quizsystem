package quizsystem.types;

import java.awt.Image;

public abstract class AbstractQuestion {
	protected String question;
	protected Image image;
	protected Integer points;
	
	public AbstractQuestion() { }
	
	public AbstractQuestion(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public Integer getPoints() {
		return points;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public void setPoints(Integer points) {
		this.points = points;
	}
}
