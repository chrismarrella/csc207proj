package use_case.add_fooditem;

/**
 * The output boundary for the add food item use case.
 * This interface is used to prepare the view for the use case.
 */
public interface AddFoodItemOutputBoundary {

    /**
     * Prepares the view for the use case if the use case was successful.
     */
    void prepareSuccessView();

    /**
     * Prepares the view for the use case if the use case failed with the error message.
     * @param error    the error that occurred represented as a string
     */
    void prepareFailView(String error);
}
