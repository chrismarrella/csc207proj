package interface_adapter.get_recipe;

import use_case.get_recipe.GetRecipeInputBoundary;

/**
 * This class represents the controller for getting a recipe.
 */
public class GetRecipeController {
    private final GetRecipeInputBoundary getRecipeInteractor;

    /**
     * Constructor for GetRecipeController
     * @param getRecipeInteractor the interactor for getting a recipe
     *
     * @return a GetRecipeController object
     */
    public GetRecipeController(GetRecipeInputBoundary getRecipeInteractor) {
        this.getRecipeInteractor = getRecipeInteractor;
    }

    /**
     * Execute the interactor for getting a recipe
     */
    public void execute() {
        getRecipeInteractor.execute(); // No input data is necessary, at least for now
    }
}
