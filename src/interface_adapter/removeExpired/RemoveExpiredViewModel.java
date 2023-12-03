package interface_adapter.removeExpired;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RemoveExpiredViewModel extends ViewModel {

    private RemoveExpiredState state = new RemoveExpiredState();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public RemoveExpiredViewModel() {
        super("expired food items");
    }

    public RemoveExpiredState getState() {
        return state;
    }

    public void setState(RemoveExpiredState state) {
        this.state = state;
    }

    @Override
    public void firePropertyChange() {
        pcs.firePropertyChange("remove expired item", null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public String getExpiredFoodItems() {
        return state.getExpiredFoodItems();
    }
}
