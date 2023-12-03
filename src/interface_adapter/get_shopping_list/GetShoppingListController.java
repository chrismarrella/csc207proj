package interface_adapter.get_shopping_list;

import use_case.get_shopping_list.GetShoppingListInputBoundary;
import use_case.get_shopping_list.GetShoppingListInputData;

import java.util.List;

/**
 * Controller for GetShoppingList use case
 */
public class GetShoppingListController {
    private GetShoppingListInputBoundary getShoppingListInteractor;

    /**
     * Constructor for GetShoppingListController
     * @param getShoppingListInteractor GetShoppingListInteractor to be used
     */
    public GetShoppingListController(GetShoppingListInputBoundary getShoppingListInteractor) {
        this.getShoppingListInteractor = getShoppingListInteractor;
    }

    /**
     * Executes the GetShoppingList use case by calling the Interactor
     * @param recipeIngredients Ingredients required for the recipe
     */
    public void execute(List<String> recipeIngredients) {
        GetShoppingListInputData getShoppingListInputData = new GetShoppingListInputData(recipeIngredients);
        getShoppingListInteractor.execute(getShoppingListInputData);
    }
}
