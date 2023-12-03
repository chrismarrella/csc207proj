package interface_adapter.main_menu;

import interface_adapter.ViewModel;
import interface_adapter.get_recipe.GetRecipeState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.List;

public class MainMenuViewModel extends ViewModel {
    /**
     * This class represents the view model for the main menu.
     */
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

    public MainMenuViewModel() {
        /**
         * Constructor for MainMenuViewModel
         *
         * @return a MainMenuViewModel object
         */
        super("Main Menu");
    }

    public void setState(MainMenuState state) {
        /**
         * Set the state for the main menu
         * @param state the state for the main menu
         */
        this.state = state;
    }
    public MainMenuState getState() {
        /**
         * Get the state for the main menu
         * @return the state for the main menu
         */
        return state;
    }

    public void firePropertyChange() {
        /**
         * Fire a property change for the main menu
         */
        pcs.firePropertyChange("main menu", null, state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        /**
         * Add a property change listener for the main menu
         * @param listener the listener to add
         */
        this.pcs.addPropertyChangeListener(listener);
    }
}

