package interface_adapter.get_recipe;

import use_case.get_recipe.GetRecipeOutputBoundary;
import use_case.get_recipe.GetRecipeOutputData;

public class GetRecipePresenter implements GetRecipeOutputBoundary {

    @Override
    public void prepareView(GetRecipeOutputData getRecipeOutputData) {
        // Update State and View
    }
}
