package use_case.delete_fooditem;

import entities.FoodItem;

public class DeleteFoodItemOutputData {

    private String deletedFoodItem;

    /**
     * Constructor for DeleteFoodItemOutputData.
     * @param foodItem FoodItem object that was deleted.
     * @param amount Amount of food item that was deleted.
     */
    public DeleteFoodItemOutputData(FoodItem foodItem, float amount) {
        this.deletedFoodItem =
                amount + " units of " + foodItem.getName() + " removed from the inventory";
    }

    /**
     * @return String message with the food item and the amount that was deleted.
     */
    public String getDeletedFoodItem() {
        return deletedFoodItem;
    }
}
