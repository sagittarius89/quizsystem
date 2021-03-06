package quizsystem.gui.panels.previewpanel.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import quizsystem.gui.abs.AbstractView;
import quizsystem.gui.controller.TeacherController;
import quizsystem.gui.model.TeacherModel;
import quizsystem.types.AbstractQuestion;
import quizsystem.types.MultipleChoiceTestQuestion;
import quizsystem.types.OpenQuestion;
import quizsystem.types.SingleChoiceTestQuestion;

public class PreviewView extends AbstractView {

	private static final long serialVersionUID = 1L;

	private AbstractQuestion question;
	
	private TeacherModel model;
	private static final Font font =new Font("Serif", Font.PLAIN, 20);
	private JTextArea questionArea;
	private JTextArea answerArea;
	private int id=0;
	
	private ArrayList<JRadioButton> answerButtons;
	private ButtonGroup answerButtonGroup;
	
	private ArrayList<JCheckBox> answerChecks;
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
	public PreviewView(TeacherModel model) {
		this.model = model;
		this.setPreferredSize(new Dimension(WIDTH + 10, HEIGHT + 10));
		setLayout(new GridBagLayout());
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(5, 5, WIDTH + 10, HEIGHT + 10);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH+1, HEIGHT+1);
		
		g.setColor(Color.WHITE);
		g.fillRect(1, 1, WIDTH, HEIGHT);
		if(question == null)
			return;
		g.setColor(Color.BLACK);
		
		g.setFont(font);
		g.drawString("Question:", 25, 30);
		
		g.setFont(new Font("Arial", Font.PLAIN, 15));
		drawString(g, question.getQuestion(), 30, 55, 460, 150);
		
		g.setFont(font);
		g.drawString("Answers:", 25, 180);
		
		if(question instanceof OpenQuestion) {
			OpenQuestion q = (OpenQuestion)question;
			g.setFont(new Font("Arial", Font.PLAIN, 12));
			if(question.getImage() == null) {
				drawString(g, q.getKey(), 30, 200, 460, 300);
			} else {
				drawString(g, q.getKey(), 30, 200, 300, 300);
			}
		} else if(question instanceof SingleChoiceTestQuestion) {
			SingleChoiceTestQuestion q = (SingleChoiceTestQuestion)question;
			g.setFont(new Font("Arial", Font.PLAIN, 14));
			
			int cheight = 200;
			int width = q.getImage() == null ? 300 : 460;
			int separator = 300 / q.getAnswers().size();
			
			for(String answer: q.getAnswers()) {
				if(q.getAnswers().get(q.getKey()) == answer)
					g.setColor(Color.GREEN);
				else
					g.setColor(Color.BLACK);
				g.fillArc(30, cheight - 7, 6, 6, 0, 360);
				drawString(g, answer, 40, cheight, width, separator);
				cheight += separator;
			}
			g.setColor(Color.BLACK);
		} else if(question instanceof MultipleChoiceTestQuestion) {
			MultipleChoiceTestQuestion q = (MultipleChoiceTestQuestion)question;
			g.setFont(new Font("Arial", Font.PLAIN, 14));
			
			int cheight = 200;
			int width = q.getImage() == null ? 300 : 460;
			int separator = 300 / q.getAnswers().size();
			
			for(int i=0; i<q.getAnswers().size(); i++) {
				String answer = q.getAnswers().get(i);
				if(q.getKeys().get(i)) {
					g.setColor(Color.GREEN);
					g.fillRect(30, cheight - 7, 6, 6);
				} else {
					g.setColor(Color.BLACK);
					g.drawRect(30, cheight - 7, 6, 6);
				}
				drawString(g, answer, 40, cheight, width, separator);
				cheight += separator;
			}
		}
		
		g.drawImage(question.getImage(), 300, 200, 150, 150, this);
		
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("Max points: " + question.getPoints(), 350, 490);
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.setColor(Color.GRAY);
		g.drawString(this.id + 1 + "", 20, 490);
	}
	
	private void drawString(Graphics g, String s, int x, int y, int width, int height) {
		FontMetrics m = g.getFontMetrics();
		String currentLine = "";
		
		int cwidth = 0;
		int cheight = y;
		
		for(int i=0; i<s.length(); ++i) {
			char c = s.charAt(i);
			int w = m.charWidth(c);
			if(cwidth + w >= width - x - 20 || c=='\n') {
				g.drawString(currentLine, x, cheight);
				cheight += m.getHeight() * 1.2;
				cwidth = 0;
				currentLine = "";
				if(cheight>y+height) {
					g.drawString("(...)", x, cheight);
					return;
				}
				
				currentLine += c;
			} else {
				cwidth += w;
				currentLine += c;
			}
		}
		g.drawString(currentLine, x, cheight);
	}

	public AbstractQuestion getQuestion() {
		return question;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		String n = arg0.getPropertyName();
		
		if(n.equals(TeacherController.DISPLAYED_QUESTION)) {
			this.id = (Integer)arg0.getNewValue();
			this.question = model.getQuestionAt(id);
			this.repaint();
		}
		
	}
}