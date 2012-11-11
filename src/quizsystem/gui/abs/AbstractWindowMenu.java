package quizsystem.gui.abs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

abstract public class AbstractWindowMenu extends  JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<JMenu> subMenus = new ArrayList<JMenu>();
	
	protected void createMenu() {
		for(JMenu menu: subMenus)
			this.add(menu);
	}
	
	public List<JMenu> getSubMenus() {
		return subMenus;
	}
}
