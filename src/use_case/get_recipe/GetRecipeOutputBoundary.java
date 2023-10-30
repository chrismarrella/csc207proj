package use_case.get_recipe;
import use_case.get_recipe.GetRecipeOutputData;
public interface GetRecipeOutputBoundary {

    void prepareSuccessView(use_case.get_recipe.GetRecipeOutputData name);

    void prepareFailView(String error);
}
