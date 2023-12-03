package use_case.get_recipe;

public interface GetRecipeOutputBoundary {
    /**
     * This interface represents the output boundary for getting a recipe.
     */

    void prepareSuccessView(GetRecipeOutputData name);

    void prepareFailView(String error);
}
