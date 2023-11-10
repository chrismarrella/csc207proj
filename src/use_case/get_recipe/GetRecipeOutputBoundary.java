package use_case.get_recipe;

public interface GetRecipeOutputBoundary {

    void prepareSuccessView(GetRecipeOutputData name);

    void prepareFailView(String error);
}
