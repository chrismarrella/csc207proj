package use_case.get_recipe;

import entities.DietaryPreferences;
import entities.Recipe;
import java.util.List;

/**
 * This interface represents the data access interface for getting a recipe.
 */
public interface GetRecipeDataAccessInterface {
    DietaryPreferences retrievePreferences();
    List<Recipe> retrieveRecipes(DietaryPreferences preferences);
}
