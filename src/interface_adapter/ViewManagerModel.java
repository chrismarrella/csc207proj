package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class is used to manage the active view.
 */
public class ViewManagerModel {

    private String activeViewName;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * @return the activeView
     */
    public String getActiveView() {
        return activeViewName;
    }

    /**
     * Sets the active view name and fires a property change event.
     * @param activeView the activeView to set
     */
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    /**
     * Fires a property change event.
     */
    public void firePropertyChange() {
        support.firePropertyChange("view", null, this.activeViewName);
    }

    /**
     * Adds a property change listener.
     * @param listener The PropertyChangeListener instance.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}

