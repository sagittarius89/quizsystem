package quizsystem.gui.windows.addquestion.controller;

public class OpenQuestionController extends AddQuestionControllerAbstract {
	public static final String KEY_TEXT = "KeyText";
	
	public void setKeyText(String keyText) {
		setModelProperty(KEY_TEXT, keyText);
	}
}
