package use_case.get_recipe;

import entities.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetRecipeOutputData {

    private List<Map<String, List<String>>> recipeData;
    private boolean useCaseFailed;

    public GetRecipeOutputData(List<Recipe> recipes, boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
        List<Map<String, List<String>>> recipeData = new ArrayList<>();
        for (Recipe recipe : recipes) {
            recipeData.add(recipe.toMap());
        }
        this.recipeData = recipeData;
    }

    public List<Map<String, List<String>>> getRecipeData() {
        return recipeData;
    }
}
