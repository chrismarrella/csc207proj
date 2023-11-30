package use_case.removeExpired;

import entities.FoodItem;

import java.util.ArrayList;

public class RemoveExpiredOutputData {

    private String expiredFoodItems;

    public RemoveExpiredOutputData(ArrayList<FoodItem> foodItems) {
        this.expiredFoodItems = "Expired food items in your inventory: ";
        for (FoodItem item : foodItems) {
            expiredFoodItems += item.getName() + "/n";
        }

        if (foodItems.isEmpty()) {
            this.expiredFoodItems = "There is no expired food items today.";
        }
    }

    public String getExpiredFoodItems() {
        return expiredFoodItems;
    }
}
