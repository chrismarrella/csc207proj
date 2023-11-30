package interface_adapter.get_recipe;

import entities.Recipe;

import java.util.ArrayList;
import java.util.List;
public class GetRecipeState {

    private List<Recipe> recipes = null;
    private String error = null;

    public void updateState(List<Recipe> recipes, String error) {
        this.recipes = recipes;
        this.error = error;
    }

    public String getError() {return error; }

    public void setRecipeError(String error) {
        this.error = error;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
