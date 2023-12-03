package use_case.delete_foodItem;

import entities.FoodItem;

public class DeleteFoodItemInputData {
    final private String foodItem;
    final private String amount;

    public DeleteFoodItemInputData(String foodItem, String amount) {
        this.foodItem = foodItem;
        this.amount = amount;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public String getAmount() {
        return amount;
    }
}
