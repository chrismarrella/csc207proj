package interface_adapter;

import java.beans.PropertyChangeListener;
/**
 * This class is used to manage the active view.
 */
public abstract class ViewModel {

    private String viewName;
    /**
     * @return the Name of the view.
     */
    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    /**
     * @return the Name of the view in the form of a string.
     */
    public String getViewName() {
        return this.viewName;
    }

    /**
     * Fires a property change event.
     */
    public abstract void firePropertyChange();
    /**
     * Adds a property change listener.
     * @param listener The PropertyChangeListener instance.
     */
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);

}
