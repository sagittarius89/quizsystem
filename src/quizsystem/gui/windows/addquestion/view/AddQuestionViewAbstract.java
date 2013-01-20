package quizsystem.gui.windows.addquestion.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import quizsystem.gui.abs.AbstractView;
import quizsystem.gui.abs.TextFieldValidator;
import quizsystem.gui.windows.addquestion.controller.AddQuestionControllerAbstract;
import quizsystem.gui.windows.addquestion.model.AddQuestionModelAbstract;


abstract public class AddQuestionViewAbstract extends AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected AddQuestionModelAbstract model;
	protected AddQuestionControllerAbstract controller;
	
	protected JTextArea questionTextArea;
	protected JButton uploadImageButton;
	protected ShowImagePanel showImagePanel;
	protected JPanel answerPanel;
	protected JTextField pointsField;
	
	protected class ShowImagePanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		Image image;
		
		public ShowImagePanel() {
			super();
			
			setPreferredSize(new Dimension(200, 200));
		}
		
		public void paintComponent(Graphics g) {
			if(image != null)
				g.drawImage(image, 0, 0, 150, 150, this);
		}
		
		public void setImage(Image image) {
			this.image = image;
			this.repaint();
		}
		
		public Image getImage() {
			return image;
		}
	}
	
	protected JPanel getThis() {
		return this;
	}
	
	public AddQuestionViewAbstract(AddQuestionControllerAbstract controller, 
		AddQuestionModelAbstract model) {
		
		this.model = model;
		this.controller = controller;
	
		this.setLayout(new GridBagLayout());
		
		initPanels();
		addListeners();
	}
	
	private void initPanels() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 10;
		gbc.weighty = 10;
		
		gbc.gridwidth = 3;
		
		this.add(new JLabel("Text of question"), gbc);
		
		gbc.gridy = 1;
		
		JScrollPane questionTextScrollPane = new JScrollPane(questionTextArea = new JTextArea());
		this.add(questionTextScrollPane, gbc);
		questionTextScrollPane.setPreferredSize(new Dimension(500, 70));
		
		gbc.gridy = 2;
		
		this.add(new JLabel("Answer key"), gbc);
		
		gbc.gridwidth = 1;
		gbc.gridheight = 4;
		gbc.gridy = 3;
		
		this.add(answerPanel = new JPanel(), gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		
		this.add(uploadImageButton = new JButton("Upload image"), gbc);

		gbc.gridy = 4;
		
		this.add(showImagePanel = new ShowImagePanel(), gbc);
		
		gbc.gridy = 5;
		
		this.add(new JLabel("Points count"), gbc);
		
		gbc.gridy = 6;
		
		this.add(pointsField = new JTextField(10), gbc);
		
		showImagePanel.setPreferredSize(new Dimension(150, 150));
		uploadImageButton.setPreferredSize(new Dimension(150, 20));
		
		showImagePanel.setBackground(Color.WHITE);
	}
	
	private void addListeners() {
		questionTextArea.getDocument().addDocumentListener(new TextFieldValidator() {
			
			@Override
			public void validate() {
				controller.setQuestionText(questionTextArea.getText());
			}
		});
		
		uploadImageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int result = chooser.showOpenDialog(getThis());
				
				if(result == JFileChooser.APPROVE_OPTION) {
					Image image = (Image)Toolkit.getDefaultToolkit().getImage(chooser.getSelectedFile().getPath());
					controller.setImage(image);
				}
			}
		});
		
		pointsField.getDocument().addDocumentListener(new TextFieldValidator() {
			
			@Override
			public void validate() {
				try {
					Integer i = Integer.parseInt(pointsField.getText());
					controller.setPoints(i);
					pointsField.setBackground(Color.GREEN);
				} catch (NumberFormatException e) {
					pointsField.setBackground(Color.RED);
				}
			
			}
		});
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String n=evt.getPropertyName();
		try {
			if(n.equals(AddQuestionControllerAbstract.QUESTION_TEXT)) {
				questionTextArea.setText((String)evt.getNewValue());
			} else if (n.equals(AddQuestionControllerAbstract.IMAGE)) {
				showImagePanel.setImage((Image)evt.getNewValue());
			} else if (n.equals(AddQuestionControllerAbstract.POINTS)) {
				pointsField.setText(evt.getNewValue() + "");
			}
		} catch (Exception e) {
			
		}
	}

}
