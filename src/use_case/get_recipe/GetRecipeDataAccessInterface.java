package use_case.get_recipe;

import entities.DietaryPreferences;
import entities.Recipe;
import java.util.List;

public interface GetRecipeDataAccessInterface {
    DietaryPreferences retrievePreferences();
    List<Recipe> retrieveRecipes(DietaryPreferences preferences);
}
