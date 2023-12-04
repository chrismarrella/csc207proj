package interface_adapter.get_recipe;

import entities.Recipe;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.List;
import java.util.Map;

/**
 * This class represents the view model for getting a recipe.
 */
public class GetRecipeViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Get Recipe";
    public static final String GET_RECIPE_BUTTON_LABEL = "Generate Recipe";
    public static final String MAIN_MENU = "Main Menu";
    private GetRecipeState currState = new GetRecipeState();

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * Constructor for GetRecipeViewModel
     *
     */
    public GetRecipeViewModel() {
        super("Get Recipe");
    }

    /**
     * Set the state for getting a recipe
     * @param state the state for getting a recipe
     */
    public void setState(GetRecipeState state) {
        this.currState = state;
    }

    /**
     * Get the state for getting a recipe
     * @return the state for getting a recipe
     */
    public GetRecipeState getState() {
        return currState;
    }

    /**
     * Add a property change listener for getting a recipe
     * @param listener the listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    /**
     * Fire a property change for getting a recipe
     */
    public void firePropertyChange() {
        pcs.firePropertyChange("recipeState", null, currState);
    }

    /**
     * Get the recipes for getting a recipe
     * @return the list of recipes returned from the use case
     */
    public List<Map<String, List<String>>> getRecipes() {
        return currState.getRecipes();
    }
}
