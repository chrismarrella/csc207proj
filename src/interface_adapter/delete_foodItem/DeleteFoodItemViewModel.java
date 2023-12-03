package interface_adapter.delete_foodItem;

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

    public DeleteFoodItemViewModel() {
        super("Delete Food Item");
    }

    public DeleteFoodItemState getState() {
        return state;
    }

    public void setState(DeleteFoodItemState state) {
        this.state = state;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void firePropertyChange() {
        pcs.firePropertyChange("delete food item", null, state);
    }

    public String getFoodItem() {
        return state.getFoodItem();
    }
}
