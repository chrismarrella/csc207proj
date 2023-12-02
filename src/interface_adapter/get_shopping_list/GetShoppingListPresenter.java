package interface_adapter.get_shopping_list;

import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.get_shopping_list.GetShoppingListOutputBoundary;
import use_case.get_shopping_list.GetShoppingListOutputData;

public class GetShoppingListPresenter implements GetShoppingListOutputBoundary {

    private final GetShoppingListViewModel getShoppingListViewModel;

    public GetShoppingListPresenter(GetShoppingListViewModel getShoppingListViewModel) {
        this.getShoppingListViewModel = getShoppingListViewModel;
    }
    @Override
    public void prepareSuccessView(GetShoppingListOutputData outputData) {
        GetShoppingListState getShoppingListState = getShoppingListViewModel.getState();
        getShoppingListState.updateState(outputData.getFoodItemData(), null);
        getShoppingListViewModel.firePropertyChange();
    }

    @Override
    public void prepareFailView(String error) {
        GetShoppingListState getShoppingListState = getShoppingListViewModel.getState();
        getShoppingListState.setShoppingListError("Failed to generate a shopping list");
        getShoppingListViewModel.firePropertyChange();
    }
}
