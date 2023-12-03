package use_case.get_recipe;

import entities.DietaryPreferences;
import entities.Recipe;
import java.util.List;

public interface GetRecipeDataAccessInterface {
    /**
     * This interface represents the data access interface for getting a recipe.
     */
    DietaryPreferences retrievePreferences();
    List<Recipe> retrieveRecipes(DietaryPreferences preferences);
}
