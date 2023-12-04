package interface_adapter.main_menu;

import interface_adapter.ViewModel;
import interface_adapter.get_recipe.GetRecipeState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.List;

/**
 * This class represents the view model for the main menu.
 */
public class MainMenuViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Welcome to CHEFFI";
    public static final String GO_TO_SHOPPING_LIST_BUTTON_LABEL = "Shopping List";
    public static final String GO_TO_GET_RECIPES_BUTTON_LABEL = "Go to Get Recipes";
    public static final String GO_TO_UPDATE_RESTRICTIONS_BUTTON_LABEL = "Update Dietary Restrictions";
    public static final String GO_TO_ADD_FOOD_ITEM = "Add Food Item";
    public static final String GO_TO_REMOVE_FOOD_ITEM = "Remove Food Item";
    public static final String GO_TO_INVENTORY = "Inventory";
    public static final String GO_TO_MAIN_MENU = "Main Menu";

    private MainMenuState state = new MainMenuState();

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * Constructor for MainMenuViewModel
     *
     * @return a MainMenuViewModel object
     */
    public MainMenuViewModel() {
        super("Main Menu");
    }

    /**
     * Set the state for the main menu
     * @param state the state for the main menu
     */
    public void setState(MainMenuState state) {
        this.state = state;
    }

    /**
     * Get the state for the main menu
     * @return the state for the main menu
     */
    public MainMenuState getState() {
        return state;
    }

    /**
     * Fire a property change for the main menu
     */
    public void firePropertyChange() {
        pcs.firePropertyChange("main menu", null, state);
    }

    /**
     * Add a property change listener for the main menu
     * @param listener the listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }
}

