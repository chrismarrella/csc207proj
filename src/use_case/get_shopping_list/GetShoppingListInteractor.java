package use_case.get_shopping_list;

import data_access.FileUserDataAccessObject;
import entities.FoodItem;
import entities.Recipe;
import java.util.List;

public class GetShoppingListInteractor implements GetShoppingListInputBoundary {

    private GetShoppingListOutputBoundary getShoppingListPresenter;
    private GetShoppingListDataAccessInterface dataAccessInterface;
    private Recipe recipe; // The usage of a DAO is unwarranted, just refer to the recipe selected for the shopping list

    public GetShoppingListInteractor(GetShoppingListOutputBoundary getRecipePresenter, GetShoppingListDataAccessInterface dataAccessInterface, Recipe recipe) {
        this.getShoppingListPresenter = getRecipePresenter;
        this.dataAccessInterface = dataAccessInterface;
        this.recipe = recipe;
    }
    public void execute() {
        if(recipe != null) {
            List<FoodItem> userInventory = dataAccessInterface.getInventory();
            GetShoppingListOutputData outputData = new GetShoppingListOutputData(recipe.getIngredients(), userInventory , false);
            getShoppingListPresenter.prepareSuccessView(outputData);
        }
        else
            getShoppingListPresenter.prepareFailView("null recipe provided");
    }
}
