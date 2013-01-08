package quizsystem.gui.abs;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.lang.reflect.Method;

abstract public class AbstractController implements PropertyChangeListener {
	protected AbstractModel model;
	protected AbstractView view;

	public AbstractController() {
	}

	public void addModel(AbstractModel model) {
		this.model = model;
		model.addPropertyChangeListener(this);
	}

	public void addView(AbstractView view) {
		this.view = view;
	}

	public AbstractModel getModel() {
		return model;
	}

	public AbstractView getView() {
		return view;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		view.propertyChange(evt);
	}

	protected void setModelProperty(String propertyName, Object newValue) {
		try {
			Method method = model.getClass().getMethod("set" + propertyName, new Class[] { newValue.getClass() });
			method.invoke(model, newValue);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	protected void setModelProperty(String propertyName, Integer idx, Object newValue) {
		try {
			Method method = model.getClass().getMethod("set" + propertyName, new Class[] {Integer.class, newValue.getClass() });
			method.invoke(model, idx, newValue);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	protected void setModelProperty(String propertyName, Object newValue1, Object newValue2) {
		try {
			Method method = model.getClass().getMethod("set" + propertyName, new Class[] { newValue1.getClass(), 
					newValue2.getClass()});
			method.invoke(model, newValue1, newValue2);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	protected void setModelProperty(String propertyName, Object newValue1, Object newValue2, Object newValue3) {
		try {
			Method method = model.getClass().getMethod("set" + propertyName, new Class[] { newValue1.getClass(), 
					newValue2.getClass(), newValue3.getClass() });
			method.invoke(model, newValue1, newValue2, newValue3);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	protected void addModelProperty(String propertyName, Object newValue) {
		try {
			Method method = model.getClass().getMethod("add" + propertyName, new Class[] { newValue.getClass() });
			method.invoke(model, newValue);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	protected void removeModelProperty(String propertyName, Object id) {
		try {
			Method method = model.getClass().getMethod("remove" + propertyName, new Class[] { id.getClass() });
			method.invoke(model, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
