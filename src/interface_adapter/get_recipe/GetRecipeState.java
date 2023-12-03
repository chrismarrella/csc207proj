package interface_adapter.get_recipe;

import entities.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetRecipeState {
    /**
     * This class represents the state for getting a recipe.
     */

    private List<Map<String, List<String>>> recipes = null;
    private String error = null;

    public void updateState(List<Map<String, List<String>>> recipes, String error) {
        /**
         * Update the state for getting a recipe
         * @param recipes the recipes to show
         * @param error the error to show
         */
        this.recipes = recipes;
        this.error = error;
    }

    public String getError() {
        /**
         * Get the error for getting a recipe
         * @return the error for getting a recipe
         */
        return error;
    }

    public void setRecipeError(String error) {
        /**
         * Set the error for getting a recipe
         * @param error the error for getting a recipe
         */
        this.error = error;
    }

    public List<Map<String, List<String>>> getRecipes() {
        /**
         * Get the recipes for getting a recipe
         * @return the recipes for getting a recipe
         */
        return recipes;
    }
}
