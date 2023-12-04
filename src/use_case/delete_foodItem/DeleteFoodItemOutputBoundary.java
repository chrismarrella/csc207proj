package use_case.delete_foodItem;

public interface DeleteFoodItemOutputBoundary {
    void prepareSuccessView(DeleteFoodItemOutputData deleteFoodItemOutputData);

    void prepareFailView(String error);

}
