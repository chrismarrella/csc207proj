package use_case.get_recipe;

import entities.get_recipe.DietaryPreferences;
import entities.get_recipe.Recipe;
import java.util.List;

public interface GetRecipeDataAccessInterface {
    DietaryPreferences retrievePreferences();
    List<Recipe> retrieveRecipes(DietaryPreferences preferences);
}
