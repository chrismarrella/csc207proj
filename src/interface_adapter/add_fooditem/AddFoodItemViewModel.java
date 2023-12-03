package interface_adapter.add_fooditem;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The view model for the add food item use case.
 * The view model is a subclass of the view model class. It is responsible for storing getting
 * and setting the state of the add food item use case. It also notifies the view when the state
 * has changed.
 */
public class AddFoodItemViewModel extends ViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private AddFoodItemState addFoodItemState = new AddFoodItemState();

    /**
     * Constructor for the AddFoodItemViewModel
     */
    public AddFoodItemViewModel() {
        super("Added FoodItem");
    }
    public static final String TITLE_LABEL = "Add Food Item";
    public static final String ADD_FOOD_ITEM_BUTTON_LABEL = "Add food item to inventory";
    public static final String FOOD_ITEM_NAME_LABEL = "Enter food item name";
    public static final String EXPIRY_DATE_YEAR_LABEL = "Enter expiry year";
    public static final String EXPIRY_DATE_MONTH_LABEL = "Enter expiry month";
    public static final String EXPIRY_DATE_DAY_LABEL = "Enter expiry day";
    public static final String AMOUNT_LABEL = "Enter amount";

    /**
     * A function to set the state for the add food item use case.
     * @param addFoodItemState   the state to be set
     */
    public void setState(AddFoodItemState addFoodItemState) {this.addFoodItemState = addFoodItemState;}

    /**
     * A function to get the state for the add food item use case.
     * @return the state of the add food item use case
     */
    public AddFoodItemState getState() {return addFoodItemState;}

    /**
     * A function to fire the property change.
     * This function is called when the state has changed.
     */
    @Override
    public void firePropertyChange() {
        support.firePropertyChange("state", null, this.addFoodItemState);
    }

    /**
     * A function to add a property change listener.
     * @param listener    the listener to be added
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
