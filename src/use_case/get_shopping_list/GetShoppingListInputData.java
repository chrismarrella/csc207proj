package use_case.get_shopping_list;

import java.util.List;

/**
 * Input data for the GetShoppingList Use Case
 */
public class GetShoppingListInputData {
    private final List<String> recipeIngredients;

    /**
     * Constructor for GetShoppingListInputData
     * @param recipeIngredients
     */
    public GetShoppingListInputData(List<String> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * Getter for recipeIngredients
     * @return List of ingredients required for the recipe
     */
    public List<String> getRecipeIngredients() {
        return recipeIngredients;
    }
}
