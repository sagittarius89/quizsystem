package quizsystem.gui.windows.addquestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.text.AbstractDocument.Content;

import quizsystem.Teacher;
import quizsystem.gui.abs.AbstractModalWindow;
import quizsystem.gui.abs.AbstractPanel;
import quizsystem.gui.abs.AbstractWindow;
import quizsystem.gui.windows.addquestion.model.AddQuestionModelAbstract;
import quizsystem.gui.windows.addquestion.model.QuestionTypeChoiceModel;
import quizsystem.types.AbstractQuestion;

public class AddQuestionWizardWindow extends AbstractModalWindow{
	public static final String CHOICE_QUESTION = "ChoiceQuestion";
	public static final String OPEN_QUESTION = "OpenQuestion";
	public static final String MULTI_ANSWER_TEST = "MultiAnswerTest";
	public static final String SINGLE_ANSWER_TEST = "SingleAnswerTest";
	
	private QuestionTypeChoicePanel questionTypeChoicePanel;
	
	private String stage;
	private AbstractPanel questionEditPanel;
	
	private JButton[] menuButtons;
	public AddQuestionWizardWindow() {
		super("Add question");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		questionTypeChoicePanel = new QuestionTypeChoicePanel();
		menuButtons = new JButton[4];
		
		menuButtons[0] = new JButton("Cancel");
		menuButtons[1] = new JButton("Back");
		menuButtons[2] = new JButton("Next");
		menuButtons[3] = new JButton("Create");
		
		menuButtons[1].setEnabled(false);
		menuButtons[3].setEnabled(false);
		
		menuButtons[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		
		menuButtons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!stage.equals(CHOICE_QUESTION))
					back();
				
			}
		});
		
		menuButtons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(stage.equals(CHOICE_QUESTION))
					next();
			}
		});
		
		menuButtons[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!stage.equals(CHOICE_QUESTION))
					create();
				
			}
		});
		
		for(int i=0; i<4; ++i)
			buttonsBar.add(menuButtons[i]);
		contentPanel.add(questionTypeChoicePanel.getView());
		
		stage = CHOICE_QUESTION;
	}
	
	private void create() {
		AbstractQuestion question = 
				((AddQuestionModelAbstract)questionEditPanel.getModel())
				.getQuestion();
		Teacher.getInstance().getModel().addQuestion(question);
		this.setVisible(false);
		this.dispose();
	}

	private void next() {
		this.contentPanel.removeAll();
		
		
		menuButtons[1].setEnabled(true);
		menuButtons[3].setEnabled(true);
		menuButtons[2].setEnabled(false);
		
		int i = ((QuestionTypeChoiceModel) this.questionTypeChoicePanel.getModel()).getChoice();
		
		switch(i) {
		case 0:
			this.stage = OPEN_QUESTION;
			questionEditPanel = new OpenQuestionPanel();
			break;
		case 1:
			this.stage = SINGLE_ANSWER_TEST;
			questionEditPanel = new SingleChoiceTestPanel();
			break;
		case 2:
			this.stage = MULTI_ANSWER_TEST;
			questionEditPanel = new MultipleChoiceTestPanel();
			break;
		}
		
		this.contentPanel.add(questionEditPanel.getView());
		pack();
	}

	private void back() {
		this.contentPanel.removeAll();
		this.contentPanel.add(questionTypeChoicePanel.getView());
		
		menuButtons[1].setEnabled(false);
		menuButtons[3].setEnabled(false);
		menuButtons[2].setEnabled(true);
		
		this.stage = CHOICE_QUESTION;
		pack();
	}

}
