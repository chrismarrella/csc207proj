package interface_adapter.get_recipe;
import use_case.get_recipe.GetRecipeOutputData;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.get_recipe.GetRecipeOutputBoundary;

/**
 * This class represents the presenter for getting a recipe.
 */
public class GetRecipePresenter implements GetRecipeOutputBoundary {
    private final GetRecipeViewModel getRecipeViewModel;

    /**
     * Constructor for GetRecipePresenter
     * @param getRecipeViewModel the view model for getting a recipe
     *
     * @return a GetRecipePresenter object
     */
    public GetRecipePresenter(GetRecipeViewModel getRecipeViewModel) {
        this.getRecipeViewModel = getRecipeViewModel;
    }

    /**
     * Prepare the view for getting a recipe
     * @param recipes the recipe to show
     */
    @Override
    public void prepareSuccessView(GetRecipeOutputData recipes) {
        GetRecipeState getRecipeState = getRecipeViewModel.getState();
        getRecipeState.updateState(recipes.getRecipeData(), null);
        getRecipeViewModel.firePropertyChange();
    }

    /**
     * Prepare the view for getting a recipe
     * @param error the error to show
     */
    @Override
    public void prepareFailView(String error) {
        GetRecipeState getRecipeState = getRecipeViewModel.getState();
        getRecipeState.setRecipeError(error);
        getRecipeViewModel.firePropertyChange();
    }
}
