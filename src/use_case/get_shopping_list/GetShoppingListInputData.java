package use_case.get_shopping_list;

import java.util.List;

public class GetShoppingListInputData {
    private final List<String> recipeIngredients;

    public GetShoppingListInputData(List<String> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public List<String> getRecipeIngredients() {
        return recipeIngredients;
    }
}
