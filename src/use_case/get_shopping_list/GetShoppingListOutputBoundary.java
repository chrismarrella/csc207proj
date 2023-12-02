package use_case.get_shopping_list;

import use_case.get_recipe.GetRecipeOutputData;

public interface GetShoppingListOutputBoundary {

    void prepareSuccessView(GetShoppingListOutputData outputData);

    void prepareFailView(String error);
}
