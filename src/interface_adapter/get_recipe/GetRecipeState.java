package interface_adapter.get_recipe;

import java.util.ArrayList;
import java.util.List;
public class GetRecipeState {

    private List<String> recipes = null;
    private String error = null;

    public void updateState(List<String> recipes, String error) {
        this.recipes = recipes;
        this.error = error;
    }

    public void setRecipeError(String error) {
        this.error = error;
    }

    public List<String> getRecipes() {
        return recipes;
    }
}
