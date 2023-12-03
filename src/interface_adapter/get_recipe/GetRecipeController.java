package interface_adapter.get_recipe;

import use_case.get_recipe.GetRecipeInputBoundary;

public class GetRecipeController {
    /**
     * This class represents the controller for getting a recipe.
     */
    private final GetRecipeInputBoundary getRecipeInteractor;

    public GetRecipeController(GetRecipeInputBoundary getRecipeInteractor) {
        /**
         * Constructor for GetRecipeController
         * @param getRecipeInteractor the interactor for getting a recipe
         *
         * @return a GetRecipeController object
         */
        this.getRecipeInteractor = getRecipeInteractor;
    }

    public void execute() {
        /**
         * Execute the interactor for getting a recipe
         */
        getRecipeInteractor.execute(); // No input data is necessary, at least for now
    }
}
