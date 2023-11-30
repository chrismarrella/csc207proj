package interface_adapter.delete_foodItem;

import use_case.delete_foodItem.DeleteFoodItemInputBoundary;
import use_case.delete_foodItem.DeleteFoodItemInputData;

public class DeleteFoodItemController {

    final DeleteFoodItemInputBoundary deleteFoodItemInteractor;

    public DeleteFoodItemController(DeleteFoodItemInputBoundary deleteFoodItemInteractor) {
        this.deleteFoodItemInteractor = deleteFoodItemInteractor;
    }

    public void execute(String foodItem, String amount) {
        DeleteFoodItemInputData deleteFoodItemInputData = new DeleteFoodItemInputData(foodItem, amount);
        deleteFoodItemInteractor.execute(deleteFoodItemInputData);
    }
}
