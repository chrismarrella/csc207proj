package interface_adapter.get_shopping_list;

import use_case.get_shopping_list.GetShoppingListInputBoundary;
import use_case.get_shopping_list.GetShoppingListInputData;

import java.util.List;

public class GetShoppingListController {
    private GetShoppingListInputBoundary getShoppingListInteractor;

    public GetShoppingListController(GetShoppingListInputBoundary getShoppingListInteractor) {
        this.getShoppingListInteractor = getShoppingListInteractor;
    }

    public void execute(List<String> recipeIngredients) {
        GetShoppingListInputData getShoppingListInputData = new GetShoppingListInputData(recipeIngredients);
        getShoppingListInteractor.execute(getShoppingListInputData);
    }
}
