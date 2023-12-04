package use_case.add_fooditem;

/**
 * The input boundary for the add food item use case.
 * This interface is used to execute the use case.
 */
public interface AddFoodItemInputBoundary {

    /**
     * Executes the use case.
     * @param addFoodItemInputData    the input data for the use case
     */
    void execute(AddFoodItemInputData addFoodItemInputData);
}
