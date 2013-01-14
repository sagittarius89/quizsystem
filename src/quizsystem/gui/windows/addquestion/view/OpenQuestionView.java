package quizsystem.gui.windows.addquestion.view;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import quizsystem.gui.windows.addquestion.controller.AddQuestionControllerAbstract;
import quizsystem.gui.windows.addquestion.model.AddQuestionModelAbstract;

public class OpenQuestionView extends AddQuestionViewAbstract {

	private JTextArea keyTextArea;
	
	public OpenQuestionView(AddQuestionControllerAbstract controller,
			AddQuestionModelAbstract model) {
		super(controller, model);
		
		keyTextArea = new JTextArea();
		JScrollPane keyScrollPane = new JScrollPane(keyTextArea);
		keyScrollPane.setPreferredSize(new Dimension(300, 200));
		
		answerPanel.add(keyScrollPane);
	}

}
