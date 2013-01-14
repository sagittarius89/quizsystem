package quizsystem.gui.windows.addquestion.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import quizsystem.gui.abs.AbstractView;
import quizsystem.gui.windows.addquestion.AddQuestionWizardWindow;
import quizsystem.gui.windows.addquestion.controller.QuestionTypeChoiceController;

public class QuestionTypeChoiceView extends AbstractView {
	
	private JRadioButton[] buttons = new JRadioButton[3];
	private QuestionTypeChoiceController controller;
	
	public QuestionTypeChoiceView(final QuestionTypeChoiceController controller) {
		this.controller = controller;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		buttons[0] = new JRadioButton("Open question");
		buttons[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setChoice(0);
				for(int j=0; j<3; ++j)
					buttons[j].setSelected(j==0);
			}
		});
		
		buttons[1] = new JRadioButton("One choice test question");
		buttons[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setChoice(1);
				for(int j=0; j<3; ++j)
					buttons[j].setSelected(j==1);
			}
		});
		
		buttons[2] = new JRadioButton("Multiple choice test question");
		buttons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setChoice(2);
				for(int j=0; j<3; ++j)
					buttons[j].setSelected(j==2);
			}
		});
		
		JPanel buttonsBar = new JPanel();
		buttonsBar.setLayout(new FlowLayout());
		
		for(int i=0; i<3; ++i)
			this.add(buttons[i]);
		
		buttons[0].setSelected(true);
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if(arg0.getPropertyName().equals(QuestionTypeChoiceController.CHOICE)) {
			Integer i = (Integer)arg0.getNewValue();
			for(int j=0; j<3; ++j)
				buttons[j].setSelected(i==j);
		}
	}

}
