package quizsystem.gui.abs;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AbstractModel {
	protected PropertyChangeSupport propertyChangeSupport;
	
	public static final String PROPERTY_ADDED = "PropertyAdded";
	public static final String PROPERTY_REMOVED = "PropertyRemoved";
    public AbstractModel()
    {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
    
    protected void firePropertyAdded(String propertyName, Object newValue) {
    	propertyChangeSupport.firePropertyChange(propertyName, PROPERTY_ADDED, newValue);
    }
    
    protected void firePropertyRemoved(String propertyName, Object oldValue) {
    	propertyChangeSupport.firePropertyChange(propertyName, PROPERTY_REMOVED, oldValue);
    }
    
    protected void firePropertySet(String propertyName, Integer i, Object oldValue, Object newValue) {
    	propertyChangeSupport.fireIndexedPropertyChange(propertyName, i, oldValue, newValue);
    }
}
