package use_case.get_recipe;

import entities.get_recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

public class GetRecipeOutputData {

    List<String> recipeData;
    public GetRecipeOutputData(List<Recipe> recipes) {
        recipeData = new ArrayList<String>();
        for (Recipe recipe : recipes) {
            recipeData.add(recipe.recipeText);
        }
    }
}
