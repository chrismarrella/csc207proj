package use_case.get_shopping_list;

import entities.Recipe;

public class GetShoppingListInteractor implements GetShoppingListInputBoundary {

    private GetShoppingListOutputBoundary getShoppingListPresenter;
    private Recipe recipe; // The usage of a DAO is unwarranted, just refer to the recipe selected for the shopping list

    public GetShoppingListInteractor(GetShoppingListOutputBoundary getRecipePresenter, Recipe recipe) {
        this.getShoppingListPresenter = getRecipePresenter;
        this.recipe = recipe;
    }
    public void execute() {
        if(recipe != null) {
            GetShoppingListOutputData outputData = new GetShoppingListOutputData(recipe.getIngredients(), false);
            getShoppingListPresenter.prepareSuccessView(outputData);
        }
        else
            getShoppingListPresenter.prepareFailView("null recipe provided");
    }
}
