package use_case.remove_expired;

import entities.FoodItem;

import java.util.ArrayList;

public class RemoveExpiredOutputData {

    private String expiredFoodItems;

    /**
     * This method creates the output data with the list of expired food items in the user's inventory.
     * @param foodItems the list of expired food items in the user's inventory.
     */
    public RemoveExpiredOutputData(ArrayList<FoodItem> foodItems) {
        this.expiredFoodItems = "Expired food items in your inventory: ";
        for (FoodItem item : foodItems) {
            expiredFoodItems += "\n" + item.getName();
        }
    }

    /**
     * This method gets the string of expired food items in the user's inventory.
     * @return the string of the names of expired food items in the user's inventory.
     */
    public String getExpiredFoodItems() {
        return expiredFoodItems;
    }
}
