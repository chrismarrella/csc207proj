package interface_adapter.get_shopping_list;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class GetShoppingListViewModel extends ViewModel {

    private GetShoppingListState currState = new GetShoppingListState();

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public GetShoppingListViewModel() { super("Get Shopping List"); }

    public GetShoppingListState getState() { return this.currState; }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void firePropertyChange() {
        pcs.firePropertyChange("state", null, currState);
    }

    public List<String> getShoppingList() { return currState.getShoppingList(); }
}
