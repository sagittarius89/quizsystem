package quizsystem.types;

import java.awt.Image;

public class OpenQuestion extends AbstractQuestion{
	private int maxLength;
	private String key;
	
	public OpenQuestion(String question) {
		super(question);
		maxLength=0;
		key="";
	}
	
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public int getMaxLength() {
		return maxLength;
	}
	
	public String getKey() {
		return key;
	}
}
