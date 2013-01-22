package quizsystem.gui.panels.previewpanel.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import quizsystem.gui.abs.AbstractView;
import quizsystem.gui.controller.StudentController;
import quizsystem.gui.model.StudentModel;
import quizsystem.types.AbstractQuestion;
import quizsystem.types.MultipleChoiceTestQuestion;
import quizsystem.types.OpenQuestion;
import quizsystem.types.SingleChoiceTestQuestion;

public class StudentPreviewView extends AbstractView {

	private static final long serialVersionUID = 1L;

	private AbstractQuestion question;
	
	private StudentModel model;
	private static final Font font =new Font("Serif", Font.PLAIN, 20);
	private JTextArea questionArea;
	private JTextArea answerArea;
	private JTextArea downArea;
	
	private ArrayList<JRadioButton> answerButtons;
	private ButtonGroup answerButtonGroup;
	
	private ArrayList<JCheckBox> answerChecks;
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private static final int HORIZ_MARGIN = WIDTH / 20;
	private static final int VERT_MARGIN = HEIGHT / 20;
	
	public StudentPreviewView(StudentModel model) {
		this.model = model;
		this.question = model.getQuestions().get(0);
		this.setPreferredSize(new Dimension(WIDTH + 10, HEIGHT + 10));
		setLayout(new GridBagLayout());
		
		this.model = model;
		this.questionArea = new JTextArea();
		
		questionArea.setFont(font);
		questionArea.setWrapStyleWord(true);
		questionArea.setLineWrap(true);
		questionArea.setEditable(false);
		
		//Ustawiamy preferowany (na razie szerokosc, w wysokosci jest byle co):
		questionArea.setSize(new Dimension(WIDTH - 2 * HORIZ_MARGIN, HEIGHT - 2 * VERT_MARGIN));
		//Znajdujemy poprawna wysokosc:
		Dimension pref_size = questionArea.getPreferredSize();
		questionArea.setSize(pref_size);

		//Pytanie otwarte:
		if (question instanceof OpenQuestion) {
			answerArea = new JTextArea();
			answerArea.setFont(font);
			answerArea.setWrapStyleWord(true);
			answerArea.setLineWrap(true);
			answerArea.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			answerArea.setPreferredSize(new Dimension(WIDTH - 2 * HORIZ_MARGIN, 100));
			
			//Nie mam pojecia jak zrobic, zeby sie nie fillowalo do konca, wiec robie kaszanokod tutaj, cz. 1.:
			downArea = new JTextArea();
			downArea.setPreferredSize(new Dimension(WIDTH - 2 * HORIZ_MARGIN, VERT_MARGIN));
			downArea.setEnabled(false);
		}
		//Test jednokrotnego wyboru:
		else if (question instanceof SingleChoiceTestQuestion) {
			answerButtons = new ArrayList<JRadioButton>();
			answerButtonGroup = new ButtonGroup();
		}
		//Test wielokrotnego wyboru:
		else if (question instanceof MultipleChoiceTestQuestion) {
			answerChecks = new ArrayList<JCheckBox>();
		}
		redraw();
	}
	
	public void redraw() {
		setIgnoreRepaint(true);
		removeAll();
		
		questionArea.setText(question.getQuestion());

		GridBagConstraints c = new GridBagConstraints();
		c.weighty = 0.2;
		c.fill = GridBagConstraints.VERTICAL;
		c.gridy = 0;
		add(questionArea, c);
		
		//Pytanie otwarte:
		if (question instanceof OpenQuestion) {
			
			//Maksymalna liczba znakow (chyba sie nie da prosciej...):
			final int max_length = ((OpenQuestion)question).getMaxLength();
			if (max_length != 0) {
				answerArea.setDocument(new PlainDocument() {
	
					private static final long serialVersionUID = 1L;
	
					public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
	
					    if(str == null || answerArea.getText().length() >= max_length) 
					      return;
	
					    super.insertString(offs, str, a);
					}
				});
			}
			
			GridBagConstraints c1 = new GridBagConstraints();
			c1.weighty = 0.8;
			c1.fill = GridBagConstraints.VERTICAL;
			c1.ipadx = -HORIZ_MARGIN;
			c1.gridy = 1;
			
			add(answerArea,c1);
			
			//Nie mam pojecia jak zrobic, zeby sie nie fillowalo do konca, wiec robie kaszanokod tutaj, cz. 2.:
			GridBagConstraints c2 = new GridBagConstraints();
			c2.weighty = 0.05;
			c2.fill = GridBagConstraints.VERTICAL;
			c2.gridy = 2;
			add(downArea, c2);

		}
		//Test jednokrotnego wyboru:
		else if (question instanceof SingleChoiceTestQuestion) {
			int i = 1;
			for(String answer : ((SingleChoiceTestQuestion) question).getAnswers()) {
				JRadioButton temp_button = new JRadioButton(answer);
				temp_button.setFont(font);
				temp_button.setBackground(Color.white);
				answerButtons.add(temp_button);
				answerButtonGroup.add(temp_button);
				
				GridBagConstraints c1 = new GridBagConstraints();
				c1.weighty = 0.8 / ((SingleChoiceTestQuestion) question).getAnswers().size();
				c1.fill = GridBagConstraints.VERTICAL;
				c1.gridy = i++;
						
				add(temp_button, c1);
			}
		}
		//Test wielokrotnego wyboru:
		else if (question instanceof MultipleChoiceTestQuestion) {
			int i = 1;
			for(String answer : ((MultipleChoiceTestQuestion) question).getAnswers()) {
				JCheckBox temp_check = new JCheckBox(answer);
				temp_check.setFont(font);
				temp_check.setBackground(Color.white);
				answerChecks.add(temp_check);
				
				GridBagConstraints c1 = new GridBagConstraints();
				c1.weighty = 0.8 / ((MultipleChoiceTestQuestion) question).getAnswers().size();
				c1.fill = GridBagConstraints.VERTICAL;
				c1.gridy = i++;
				
				add(temp_check, c1);
			}
		}
		
		setIgnoreRepaint(false);
		repaint();
	}

	public void paintComponent(Graphics g) {
		//Nie wiem czemu nie dziala po prostu setBackground, ale kij z tym:
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public AbstractQuestion getQuestion() {
		return question;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		String n = arg0.getPropertyName();
		if(n.equals(StudentController.DISPLAYED_QUESTION)) {
			Integer id = (Integer)arg0.getNewValue();
			this.question = model.getQuestionAt(id);
			this.redraw();
		}	
	}
}