package use_case.get_shopping_list;

import use_case.get_recipe.GetRecipeOutputData;

/**
 * Interface for GetShoppingList's OutputBoundary
 */
public interface GetShoppingListOutputBoundary {

    /**
     * Prepares the success view
     * @param outputData Output data for the use case (the list of item in the shopping list)
     */
    void prepareSuccessView(GetShoppingListOutputData outputData);

    /**
     * Prepares the fail view
     * @param error Error message to be displayed
     */
    void prepareFailView(String error);
}
