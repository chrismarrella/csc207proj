package use_case.removeExpired;

import entities.FoodItem;

import java.util.ArrayList;

public class RemoveExpiredOutputData {

    private String expiredFoodItems;

    public RemoveExpiredOutputData(ArrayList<FoodItem> foodItems) {
        this.expiredFoodItems = "Expired food items in your inventory: ";
        for (FoodItem item : foodItems) {
            expiredFoodItems += "\n" + item.getName();
        }
    }

    public String getExpiredFoodItems() {
        return expiredFoodItems;
    }
}
