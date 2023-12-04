package interface_adapter.remove_expired;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RemoveExpiredViewModel extends ViewModel {

    private RemoveExpiredState state = new RemoveExpiredState();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * This method creates the remove expired view model.
     */
    public RemoveExpiredViewModel() {
        super("expired food items");
    }

    /**
     * This method gets the state of the remove expired view model.
     * @return the state of the remove expired view model.
     */
    public RemoveExpiredState getState() {
        return state;
    }

    /**
     * This method sets the state of the remove expired view model.
     * @param state the state of the remove expired view model.
     */
    public void setState(RemoveExpiredState state) {
        this.state = state;
    }

    /**
     * This method fires a property change event to the remove expired view model.
     */
    @Override
    public void firePropertyChange() {
        pcs.firePropertyChange("remove expired items", null, state);
    }

    /**
     * This method adds a property change listener to the remove expired view model.
     * @param listener the property change listener to be added.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }
}
