package use_case.delete_foodItem;

import entities.FoodItem;
import interface_adapter.delete_foodItem.DeleteFoodItemViewModel;

public class DeleteFoodItemOutputData {

    private String deletedFoodItem;

    public DeleteFoodItemOutputData(FoodItem foodItem, float amount) {
        this.deletedFoodItem =
                amount + "g/mL of " + foodItem.getName() + " removed from the inventory";
    }

    public String getDeletedFoodItem() {
        return deletedFoodItem;
    }
}
