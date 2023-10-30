package interface_adapter.get_recipe;
import interface_adapter.get_recipe.GetReceipeOutputBoundary;
import interface_adapter.get_recipe.GetRecipeOutputData;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.get_recipe.GetRecipeOutputData;


public class GetRecipePresenter implements use_case.get_recipe.GetRecipeOutputBoundary {
    private final GetRecipeViewModel getRecipeViewModel;

    public GetRecipePresenter(GetRecipeViewModel getRecipeViewModel) {
        this.getRecipeViewModel = getRecipeViewModel;
    }

    @Override
    public void prepareSuccessView(GetRecipeOutputData name) {
        GetRecipeState getRecipeState = getRecipeViewModel.getState();
        getRecipeState.setRecipe(name.getRecipe());
        this.getRecipeViewModel.setState(getRecipeState);
        clearViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        GetRecipeState getRecipeState = getRecipeViewModel.getState();
        getRecipeState.setRecipeError(error);
        getRecipeViewModel.firePropertyChange();
    }
}
