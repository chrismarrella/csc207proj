package interface_adapter.main_menu;

import interface_adapter.ViewModel;
import interface_adapter.get_recipe.GetRecipeState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.List;

public class MainMenuViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Welcome to CHEFFI";
    public static final String GO_TO_SHOPPING_LIST_BUTTON_LABEL = "Shopping List";
    public static final String GO_TO_GET_RECIPES_BUTTON_LABEL = "Go to Get Recipes";
    public static final String GO_TO_UPDATE_RESTRICTIONS_BUTTON_LABEL = "Update Dietary Restrictions";
    public static final String GO_TO_ADD_FOOD_ITEM = "Add Food Item";
    public static final String GO_TO_REMOVE_FOOD_ITEM = "Remove Food Item";
    public static final String GO_TO_INVENTORY = "Inventory";
    public static final Integer GetRecipeViewNumber = 1;

    private MainMenuState state = new MainMenuState();

    public MainMenuViewModel() {
        super("Main Menu");
    }

    public void setState(MainMenuState state) {
        this.state = state;
    }
    public MainMenuState getState() { return state; }

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void firePropertyChange() {
        pcs.firePropertyChange("state", null, state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }
}

