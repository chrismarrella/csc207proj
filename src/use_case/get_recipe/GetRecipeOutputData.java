package use_case.get_recipe;

import entities.get_recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

public class GetRecipeOutputData {

    private List<String> recipeData;
    private boolean useCaseFailed;

    public GetRecipeOutputData(List<Recipe> recipes, boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
        recipeData = new ArrayList<String>();
        for (Recipe recipe : recipes) {
            recipeData.add(recipe.recipeText);
        }
    }

    public List<String> getRecipeData() {
        return recipeData;
    }
}
