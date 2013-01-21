package quizsystem.gui.abs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;

public abstract class AbstractModalWindow extends JDialog {
	//Title bar text
	private String title;
	
	//List of panels in current window
	protected List<AbstractPanel> panels;
	
	protected AbstractModel model;
	protected AbstractController controller;
	protected JPanel buttonsBar;
	protected JPanel contentPanel;
	
	public static final Color BACKGROUND_COLOR = new Color(217, 217, 217);
	
	public AbstractModalWindow(String title) {
		setBackground(BACKGROUND_COLOR);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(title);
		setModal(true);
		setResizable(false);
		
		contentPanel = new JPanel();
		buttonsBar = new JPanel();
		buttonsBar.setLayout(new FlowLayout());
		init();
		this.getContentPane().add(contentPanel);
		this.getContentPane().add(buttonsBar, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

	protected abstract void init();

}
