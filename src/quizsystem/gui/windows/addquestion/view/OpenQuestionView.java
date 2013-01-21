package quizsystem.gui.windows.addquestion.view;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import quizsystem.gui.abs.TextFieldValidator;
import quizsystem.gui.windows.addquestion.controller.AddQuestionControllerAbstract;
import quizsystem.gui.windows.addquestion.controller.OpenQuestionController;
import quizsystem.gui.windows.addquestion.model.AddQuestionModelAbstract;
import quizsystem.gui.windows.addquestion.model.OpenQuestionModel;

public class OpenQuestionView extends AddQuestionViewAbstract {

	private JTextArea keyTextArea;
	
	public OpenQuestionView(final OpenQuestionController controller,
			OpenQuestionModel model) {
		super(controller, model);
		
		keyTextArea = new JTextArea();
		
		keyTextArea.getDocument().addDocumentListener(new TextFieldValidator() {
			
			@Override
			public void validate() {
				controller.setKeyText(keyTextArea.getText());
			}
		});
		
		JScrollPane keyScrollPane = new JScrollPane(keyTextArea);
		keyScrollPane.setPreferredSize(new Dimension(300, 200));
		
		answerPanel.add(keyScrollPane);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		super.propertyChange(evt);
		
		String n = evt.getPropertyName();
		
		try {
			if(n.equals(OpenQuestionController.KEY_TEXT)) {
				keyTextArea.setText((String)evt.getPropertyName());
			}
			
		} catch (Exception e) {
			
		}
	}

}
