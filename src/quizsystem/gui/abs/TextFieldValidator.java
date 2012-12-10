package quizsystem.gui.abs;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public abstract class TextFieldValidator implements DocumentListener{

	@Override
	public void insertUpdate(DocumentEvent e) {
		try {
			validate();
		} catch (Exception e2) {
		}
		
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		try {
			validate();
		} catch (Exception e2) {
		}
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		try {
			validate();
		} catch (Exception e2) {
		}
		
	}
	
	public abstract void validate();

}