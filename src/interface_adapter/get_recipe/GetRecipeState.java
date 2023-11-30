package interface_adapter.get_recipe;

import entities.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetRecipeState {

    private List<Map<String, List<String>>> recipes = null;
    private String error = null;

    public void updateState(List<Map<String, List<String>>> recipes, String error) {
        this.recipes = recipes;
        this.error = error;
    }

    public String getError() {return error; }

    public void setRecipeError(String error) {
        this.error = error;
    }

    public List<Map<String, List<String>>> getRecipes() {
        return recipes;
    }
}
