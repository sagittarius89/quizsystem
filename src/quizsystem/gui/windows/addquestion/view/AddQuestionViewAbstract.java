package quizsystem.gui.windows.addquestion.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import quizsystem.gui.abs.AbstractView;
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
				g.drawImage(image, 0, 0, 200, 200, this);
		}
		
		public void setImage(Image image) {
			this.image = image;
		}
		
		public Image getImage() {
			return image;
		}
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
		gbc.gridheight = 2;
		gbc.gridy = 3;
		
		this.add(answerPanel = new JPanel(), gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		
		this.add(uploadImageButton = new JButton("Upload image"), gbc);

		gbc.gridy = 4;
		
		this.add(showImagePanel = new ShowImagePanel(), gbc);
		
		showImagePanel.setPreferredSize(new Dimension(100, 100));
		uploadImageButton.setPreferredSize(new Dimension(150, 20));
		
		showImagePanel.setBackground(Color.WHITE);
	}
	
	private void addListeners() {
		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}

}
