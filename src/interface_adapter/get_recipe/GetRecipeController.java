package interface_adapter.get_recipe;

import use_case.get_recipe.GetRecipeInputBoundary;

public class GetRecipeController {
    final GetRecipeInputBoundary getRecipeInteractor;

    public GetRecipeController(GetRecipeInputBoundary getRecipeInteractor) {
        this.getRecipeInteractor = getRecipeInteractor;
    }

    public void execute() {
        getRecipeInteractor.execute(); // No input data is necessary, at least for now
    }
}
