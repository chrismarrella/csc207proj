package interface_adapter.get_recipe;
import use_case.get_recipe.GetRecipeOutputData;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.get_recipe.GetRecipeOutputBoundary;

public class GetRecipePresenter implements GetRecipeOutputBoundary {
    /**
     * This class represents the presenter for getting a recipe.
     */
    private final GetRecipeViewModel getRecipeViewModel;

    public GetRecipePresenter(GetRecipeViewModel getRecipeViewModel) {
        /**
         * Constructor for GetRecipePresenter
         * @param getRecipeViewModel the view model for getting a recipe
         *
         * @return a GetRecipePresenter object
         */
        this.getRecipeViewModel = getRecipeViewModel;
    }

    @Override
    public void prepareSuccessView(GetRecipeOutputData recipes) {
        /**
         * Prepare the view for getting a recipe
         * @param recipes the recipe to show
         */
        GetRecipeState getRecipeState = getRecipeViewModel.getState();
        getRecipeState.updateState(recipes.getRecipeData(), null);
        getRecipeViewModel.firePropertyChange();
    }

    @Override
    public void prepareFailView(String error) {
        /**
         * Prepare the view for getting a recipe
         * @param error the error to show
         */
        GetRecipeState getRecipeState = getRecipeViewModel.getState();
        getRecipeState.setRecipeError(error);
        getRecipeViewModel.firePropertyChange();
    }
}
