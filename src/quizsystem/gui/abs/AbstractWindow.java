package quizsystem.gui.abs;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JFrame;

public abstract class AbstractWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Title bar text
	private String title;
	
	//List of panels in current window
	protected List<AbstractPanel> panels;
	
	public static final Color BACKGROUND_COLOR = new Color(217, 217, 217);
	public static final int MINIMUM_WIDTH = 500;
	public static final int MINIMUM_HEIGHT = 500;
	
	//Title bar icon
	protected Icon icon;
	
	public AbstractWindow(String title) {
		setBackground(BACKGROUND_COLOR);
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(title);
		
		init();
		pack();
		setVisible(true);
	}
	
	public void setTitle(String title) {
		this.title = "QuizSystem " + title;
		super.setTitle(this.title);
	}
	
	abstract public void init();
	abstract public void dispose();
}
