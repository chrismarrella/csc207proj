package interface_adapter.get_recipe;

import entities.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class represents the state for getting a recipe.
 */
public class GetRecipeState {

    private List<Map<String, List<String>>> recipes = null;
    private String error = null;

    /**
     * Update the state for getting a recipe
     * @param recipes the recipes to show
     * @param error the error to show
     */
    public void updateState(List<Map<String, List<String>>> recipes, String error) {
        this.recipes = recipes;
        this.error = error;
    }

    /**
     * Get the error for getting a recipe
     * @return the error for getting a recipe
     */
    public String getError() {
        return error;
    }

    /**
     * Set the error for getting a recipe
     * @param error the error for getting a recipe
     */
    public void setRecipeError(String error) {
        this.error = error;
    }

    /**
     * Get the recipes for getting a recipe
     * @return the recipes for getting a recipe
     */
    public List<Map<String, List<String>>> getRecipes() {
        return recipes;
    }
}
