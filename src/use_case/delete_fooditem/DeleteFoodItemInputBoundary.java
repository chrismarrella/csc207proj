package use_case.delete_fooditem;

public interface DeleteFoodItemInputBoundary {

    /**
     * Deletes a food item from the inventory.
     * @param deleteFoodItemInputData the food item to be deleted.
     */
    void execute(DeleteFoodItemInputData deleteFoodItemInputData);
}
