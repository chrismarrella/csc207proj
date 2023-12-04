package use_case.delete_fooditem;

public interface DeleteFoodItemOutputBoundary {

    /**
     * Prepares the success view.
     * @param deleteFoodItemOutputData The output data from the delete food item use case.
     */
    void prepareSuccessView(DeleteFoodItemOutputData deleteFoodItemOutputData);

    /**
     * Prepares the fail view.
     * @param error The error message.
     */
    void prepareFailView(String error);

}
