package quizsystem.gui.panels.previewpanel.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;

import quizsystem.gui.abs.AbstractView;
import quizsystem.types.AbstractQuestion;

public class PreviewView extends AbstractView{

	class MiniPreview extends JPanel {
		private AbstractQuestion question;
		
		public MiniPreview(AbstractQuestion question) {
			this.question = question;
			this.setPreferredSize(new Dimension(150, 150));
		}
		
		public void paintComponent(Graphics g) {
			
		}
		
		public AbstractQuestion getQuestion() {
			return question;
		}
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
