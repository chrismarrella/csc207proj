package use_case.get_recipe;

import entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class GetRecipeOutputData {

    private List<Recipe> recipeData;
    private boolean useCaseFailed;

    public GetRecipeOutputData(List<Recipe> recipes, boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
//        recipeData = new ArrayList<String>();
//        for (Recipe recipe : recipes) {
//            recipeData.add(recipe.toString());
//        }
        this.recipeData = recipes;
    }

    public List<Recipe> getRecipeData() {
        return recipeData;
    }
}
