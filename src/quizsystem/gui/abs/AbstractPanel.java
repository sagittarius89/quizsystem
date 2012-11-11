package quizsystem.gui.abs;

public abstract class AbstractPanel {
	protected AbstractModel model;
	protected AbstractView view;
	protected AbstractController controller;
	
	public AbstractModel getModel() {
		return model;
	}
	
	public AbstractController getController() {
		return controller;
	}
	
	public AbstractView getView() {
		return view;
	}
}
