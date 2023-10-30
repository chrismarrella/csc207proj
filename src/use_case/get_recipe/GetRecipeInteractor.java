package use_case.get_recipe;

import entities.get_recipe.DietaryPreferences;
import entities.get_recipe.Recipe;

import java.util.List;

public class GetRecipeInteractor implements GetRecipeInputBoundary {

    GetRecipeOutputBoundary getRecipePresenter;
    GetRecipeDataAccessInterface getRecipeDataAccessInterface;

    public GetRecipeInteractor(GetRecipeDataAccessInterface getRecipeDataAccessInterface, GetRecipeOutputBoundary getRecipePresenter) {
        this.getRecipeDataAccessInterface = getRecipeDataAccessInterface;
        this.getRecipePresenter = getRecipePresenter;
    }
    public void execute() {
        DietaryPreferences dietaryPreferences = getRecipeDataAccessInterface.retrievePreferences();
        List<Recipe> recipes = getRecipeDataAccessInterface.retrieveRecipes(dietaryPreferences);


    }
}
