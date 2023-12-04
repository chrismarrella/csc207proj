package use_case.get_recipe;

/**
 * This interface represents the output boundary for getting a recipe.
 */
public interface GetRecipeOutputBoundary {

    void prepareSuccessView(GetRecipeOutputData name);

    void prepareFailView(String error);
}
