package interface_adapter.delete_foodItem;

import use_case.delete_foodItem.DeleteFoodItemInputBoundary;
import use_case.delete_foodItem.DeleteFoodItemInputData;

import java.io.IOException;

public class DeleteFoodItemController {

    final DeleteFoodItemInputBoundary deleteFoodItemInteractor;

    public DeleteFoodItemController(DeleteFoodItemInputBoundary deleteFoodItemInteractor) {
        /**
         * This method creates the delete food item controller.
         * @param deleteFoodItemInteractor The interactor to use to delete a food item.
         */
        this.deleteFoodItemInteractor = deleteFoodItemInteractor;
    }

    public void execute(String foodItem, String amount) {
        /**
         * This method executes the delete food item use case.
         * @param foodItem The name of the food item to delete.
         * @param amount The amount of the food item to delete.
         */
        DeleteFoodItemInputData deleteFoodItemInputData = new DeleteFoodItemInputData(foodItem, amount);
        deleteFoodItemInteractor.execute(deleteFoodItemInputData);
    }
}
