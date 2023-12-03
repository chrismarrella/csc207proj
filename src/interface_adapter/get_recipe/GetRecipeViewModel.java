package interface_adapter.get_recipe;

import entities.Recipe;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.List;
import java.util.Map;

public class GetRecipeViewModel extends ViewModel {
    /**
     * This class represents the view model for getting a recipe.
     */
    public static final String TITLE_LABEL = "Get Recipe";
    public static final String GET_RECIPE_BUTTON_LABEL = "Generate Recipe";
    public static final String MAIN_MENU = "Main Menu";
    private GetRecipeState currState = new GetRecipeState();

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public GetRecipeViewModel() {
        /**
         * Constructor for GetRecipeViewModel
         *
         * @return a GetRecipeViewModel object
         */
        super("Get Recipe");
    }

    public void setState(GetRecipeState state) {
        /**
         * Set the state for getting a recipe
         * @param state the state for getting a recipe
         */
        this.currState = state;
    }
    public GetRecipeState getState() {
        /**
         * Get the state for getting a recipe
         * @return the state for getting a recipe
         */
        return currState;
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        /**
         * Add a property change listener for getting a recipe
         * @param listener the listener to add
         */
        this.pcs.addPropertyChangeListener(listener);
    }

    public void firePropertyChange() {
        /**
         * Fire a property change for getting a recipe
         */
        pcs.firePropertyChange("recipeState", null, currState);
    }

    public List<Map<String, List<String>>> getRecipes() {
        /**
         * Get the recipes for getting a recipe
         * @return the list of recipes returned from the use case
         */
        return currState.getRecipes();
    }
}
