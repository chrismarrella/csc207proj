package interface_adapter.get_shopping_list;

import use_case.get_shopping_list.GetShoppingListInputBoundary;

public class GetShoppingListController {
    private GetShoppingListInputBoundary getShoppingListInteractor;

    public GetShoppingListController(GetShoppingListInputBoundary getShoppingListInteractor) {
        this.getShoppingListInteractor = getShoppingListInteractor;
    }

    public void execute() { getShoppingListInteractor.execute(); }
}
