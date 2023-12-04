package use_case.get_recipe;

import entities.DietaryPreferences;
import entities.Recipe;

import java.util.List;

/**
 * This class represents the interactor for getting a recipe.
 */
public class GetRecipeInteractor implements GetRecipeInputBoundary {

    private GetRecipeOutputBoundary getRecipePresenter;
    private GetRecipeDataAccessInterface getRecipeDataAccessObject;

    /**
     * Constructor for GetRecipeInteractor
     * @param getRecipeDataAccessObject the data access object for getting a recipe
     * @param getRecipePresenter the presenter for getting a recipe
     *
     */
    public GetRecipeInteractor(GetRecipeDataAccessInterface getRecipeDataAccessObject,
                               GetRecipeOutputBoundary getRecipePresenter) {
        this.getRecipeDataAccessObject = getRecipeDataAccessObject;
        this.getRecipePresenter = getRecipePresenter;
    }

    /**
     * Execute the interactor for getting a recipe
     */
    public void execute() {
        DietaryPreferences dietaryPreferences = getRecipeDataAccessObject.retrievePreferences();
        List<Recipe> recipes = getRecipeDataAccessObject.retrieveRecipes(dietaryPreferences);

        if (recipes.isEmpty()) {
            // when there is no existing recipe in the database that meets the user preferences
            getRecipePresenter.prepareFailView("no available recipes");
        } else {
            GetRecipeOutputData getRecipeOutputData = new GetRecipeOutputData(recipes, false);
            getRecipePresenter.prepareSuccessView(getRecipeOutputData);
        }
    }
}
