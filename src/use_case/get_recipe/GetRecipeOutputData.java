package use_case.get_recipe;

import entities.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetRecipeOutputData {
    /**
     * This class represents the output data for getting a recipe.
     */

    private List<Map<String, List<String>>> recipeData;
    private boolean useCaseFailed;

    public GetRecipeOutputData(List<Recipe> recipes, boolean useCaseFailed) {
        /**
         * Constructor for GetRecipeOutputData
         * @param recipes the list of recipes
         * @param useCaseFailed the boolean value indicating whether the use case failed
         */
        this.useCaseFailed = useCaseFailed;
        List<Map<String, List<String>>> recipeData = new ArrayList<>();
        for (Recipe recipe : recipes) {
            recipeData.add(recipe.toMap());
        }
        this.recipeData = recipeData;
    }

    public List<Map<String, List<String>>> getRecipeData() {
        /**
         * Get the recipe data for getting a recipe
         * @return the recipe data
         */
        return recipeData;
    }
}
