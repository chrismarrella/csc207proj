package interface_adapter.get_shopping_list;

import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.get_shopping_list.GetShoppingListOutputBoundary;
import use_case.get_shopping_list.GetShoppingListOutputData;

/**
 * Presenter for GetShoppingList use case
 */
public class GetShoppingListPresenter implements GetShoppingListOutputBoundary {

    private final GetShoppingListViewModel getShoppingListViewModel;

    /**
     * Constructor for GetShoppingListPresenter
     * @param getShoppingListViewModel GetShoppingListViewModel to be used
     */
    public GetShoppingListPresenter(GetShoppingListViewModel getShoppingListViewModel) {
        this.getShoppingListViewModel = getShoppingListViewModel;
    }

    /**
     * Prepares the success view
     * @param outputData Output data for the use case (the list of items in the shopping list)
     */
    @Override
    public void prepareSuccessView(GetShoppingListOutputData outputData) {
        GetShoppingListState getShoppingListState = getShoppingListViewModel.getState();
        getShoppingListState.updateState(outputData.getFoodItemData(), null);
        getShoppingListViewModel.firePropertyChange();
    }

    /**
     * Prepares the fail view
     * @param error Error message to be displayed
     */
    @Override
    public void prepareFailView(String error) {
        GetShoppingListState getShoppingListState = getShoppingListViewModel.getState();
        getShoppingListState.setShoppingListError("Failed to generate a shopping list");
        getShoppingListViewModel.firePropertyChange();
    }
}
