package interface_adapter.get_shopping_list;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

/**
 * ViewModel for GetShoppingList
 */
public class GetShoppingListViewModel extends ViewModel {

    private GetShoppingListState currState = new GetShoppingListState();

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * Constructor for GetShoppingListViewModel
     */
    public GetShoppingListViewModel() { super("Get Shopping List"); }

    /**
     * Getter for the state of the ViewModel
     */
    public GetShoppingListState getState() { return this.currState; }

    /** Adds a PropertyChangeListener to the PropertyChangeSupport member
     * @param listener PropertyChangeListener to be added
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    /**
     * Fires a PropertyChangeEvent, informing the listener that the state has changed
     */
    public void firePropertyChange() {
        pcs.firePropertyChange("shoppingListState", null, currState);
    }
  
    /**
     * Getter for the state of the ViewModel
     * @return List of ingredients required for the recipe
     */
    public List<String> getShoppingList() { return currState.getShoppingList(); }
}
