package interface_adapter.delete_fooditem;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteFoodItemViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Remove Food Items";
    public static final String DELETE_LABEL = "Enter food item to remove from the inventory";
    public static final String AMOUNT_LABEL = "Enter amount of the food item to remove";
    public static final String DELETE_FOODITEM_BUTTON_LABEL = "Remove";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    private DeleteFoodItemState state = new DeleteFoodItemState();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * This method creates the delete food item view model.
     */
    public DeleteFoodItemViewModel() {
        super("Delete Food Item");
    }

    /**
     * This method gets the state of the delete food item view model.
     * @return the state of the delete food item view model.
     */
    public DeleteFoodItemState getState() {
        return state;
    }

    /**
     * This method sets the state of the delete food item view model.
     * @param state the state of the delete food item view model.
     */
    public void setState(DeleteFoodItemState state) {
        this.state = state;
    }

    /**
     * This method adds a property change listener to the delete food item view model.
     * @param listener the property change listener to be added.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    /**
     * This method fires a property change event to the delete food item view model.
     */
    @Override
    public void firePropertyChange() {
        pcs.firePropertyChange("delete food item", null, state);
    }

    /**
     * This method gets the food item of the delete food item view model.
     * @return the name of the deleted food item.
     */
    public String getFoodItem() {
        return state.getFoodItem();
    }
}
