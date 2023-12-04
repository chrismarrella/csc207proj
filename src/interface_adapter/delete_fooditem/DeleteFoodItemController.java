package interface_adapter.delete_fooditem;

import use_case.delete_fooditem.DeleteFoodItemInputBoundary;
import use_case.delete_fooditem.DeleteFoodItemInputData;

public class DeleteFoodItemController {

    final DeleteFoodItemInputBoundary deleteFoodItemInteractor;

    /**
     * This method creates the delete food item controller.
     * @param deleteFoodItemInteractor The interactor to use to delete a food item.
     */
    public DeleteFoodItemController(DeleteFoodItemInputBoundary deleteFoodItemInteractor) {
        this.deleteFoodItemInteractor = deleteFoodItemInteractor;
    }

    /**
     * This method executes the delete food item use case.
     * @param foodItem The name of the food item to delete.
     * @param amount The amount of the food item to delete.
     */
    public void execute(String foodItem, String amount) {
        DeleteFoodItemInputData deleteFoodItemInputData = new DeleteFoodItemInputData(foodItem, amount);
        deleteFoodItemInteractor.execute(deleteFoodItemInputData);
    }
}
