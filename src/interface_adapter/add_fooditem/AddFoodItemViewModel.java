package interface_adapter.add_fooditem;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddFoodItemViewModel extends ViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private AddFoodItemState addFoodItemState = new AddFoodItemState();
    public AddFoodItemViewModel() {
        super("Added FoodItem");
    }
    public static final String TITLE_LABEL = "Add Food Item";
    public static final String ADD_FOOD_ITEM_BUTTON_LABEL = "Add food item to inventory";
    public static final String FOOD_ITEM_NAME_LABEL = "Enter food item name";
    public static final String EXPIRY_DATE_YEAR_LABEL = "Enter expiry year";
    public static final String EXPIRY_DATE_MONTH_LABEL = "Enter expiry month";
    public static final String EXPIRY_DATE_DAY_LABEL = "Enter expiry day";
    public void setState(AddFoodItemState addFoodItemState) {this.addFoodItemState = addFoodItemState;}
    public AddFoodItemState getState() {return addFoodItemState;}
    @Override
    public void firePropertyChange() {
        support.firePropertyChange("state", null, this.addFoodItemState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
