package quizsystem.gui.windows.addquestion.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	protected JButton cancelButton;
	protected JButton createButton;
	
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
	
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(500, 300));
		
		initPanels();
		addListeners();
	}
	
	private void initPanels() {
		//Question text
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.Y_AXIS));
		
		upperPanel.add(new JLabel("Text of question"));
		upperPanel.add(questionTextArea = new JTextArea());
		
		
		//Image Panel
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		rightPanel.add(uploadImageButton = new JButton("Upload image"));
		rightPanel.add(showImagePanel = new ShowImagePanel());
		
		//Buttons bar
		JPanel buttonsBar = new JPanel();
		buttonsBar.setLayout(new FlowLayout());
		
		buttonsBar.add(cancelButton = new JButton("Cancel"));
		buttonsBar.add(createButton = new JButton("Create"));
		
		this.add(upperPanel, BorderLayout.PAGE_START);
		this.add(rightPanel, BorderLayout.LINE_END);
		this.add(buttonsBar, BorderLayout.PAGE_END);
	}
	
	private void addListeners() {
		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}

}
