package use_case.get_recipe;

import entities.DietaryPreferences;
import entities.Recipe;

import java.util.List;

public class GetRecipeInteractor implements GetRecipeInputBoundary {

    private GetRecipeOutputBoundary getRecipePresenter;
    private GetRecipeDataAccessInterface getRecipeDataAccessObject;

    public GetRecipeInteractor(GetRecipeDataAccessInterface getRecipeDataAccessObject,
                               GetRecipeOutputBoundary getRecipePresenter) {
        this.getRecipeDataAccessObject = getRecipeDataAccessObject;
        this.getRecipePresenter = getRecipePresenter;
    }

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
