package interface_adapter.get_recipe;
import use_case.get_recipe.GetRecipeOutputData;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.get_recipe.GetRecipeOutputBoundary;

public class GetRecipePresenter implements GetRecipeOutputBoundary {
    private final GetRecipeViewModel getRecipeViewModel;

    public GetRecipePresenter(GetRecipeViewModel getRecipeViewModel) {
        this.getRecipeViewModel = getRecipeViewModel;
    }

    @Override
    public void prepareSuccessView(GetRecipeOutputData recipes) {
        GetRecipeState getRecipeState = getRecipeViewModel.getState();
        getRecipeState.updateState(recipes.getRecipeData(), null);
        getRecipeViewModel.firePropertyChanged();
        //change view or change state here
    }

    @Override
    public void prepareFailView(String error) {
        GetRecipeState getRecipeState = getRecipeViewModel.getState();
        getRecipeState.setRecipeError(error);
        getRecipeViewModel.firePropertyChanged();
    }
}
