package quizsystem.gui.panels.previewbar.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import quizsystem.gui.abs.AbstractView;
import quizsystem.gui.controller.StudentController;
import quizsystem.gui.model.StudentModel;
import quizsystem.types.AbstractQuestion;

public class StudentPreviewBarView extends AbstractView {
	private StudentModel model;
	private ArrayList<MiniPreview> previews;
	
	class MiniPreview extends JPanel {
		private static final long serialVersionUID = 1L;

		private static final int WIDTH = 150;
		private static final int HEIGHT = 150;
		private Font font =new Font("Serif", Font.PLAIN, 10);
		private AbstractQuestion question;
		
		public MiniPreview(AbstractQuestion q) {
			this.question = q;
		}
		
		public void paintComponent(Graphics g) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(5, 5, WIDTH + 5, HEIGHT + 5);
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WIDTH+1, HEIGHT+1);
			
			g.setColor(Color.WHITE);
			g.fillRect(1, 1, WIDTH, HEIGHT);
			if(question == null)
				return;
			
			g.setColor(Color.BLACK);
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
	}
	
	public StudentPreviewBarView(StudentModel model) {
		this.model = model;
		previews = new ArrayList<StudentPreviewBarView.MiniPreview>();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		//this.setLayout(new GridLayout(100, 1));
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		String n = arg0.getPropertyName();
		
		if(n.equals(StudentController.QUESTION)) {
			MiniPreview p = new MiniPreview((AbstractQuestion)arg0.getNewValue());
			this.previews.add(p);
			this.add(p);
			this.revalidate();
		}
		
	}

}
