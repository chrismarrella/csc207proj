package use_case.get_shopping_list;

import entities.FoodItem;

import java.util.List;
import java.util.ArrayList;

public class GetShoppingListOutputData {

    private final List<String> foodItemData;
    private final boolean useCaseFailed; // May not be necessary

    public GetShoppingListOutputData(List<FoodItem> recipeItems, List<FoodItem> userInventory, boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
        String foodItemString;
        foodItemData = new ArrayList<String>();
        for (FoodItem foodItem : recipeItems) {
            double amount_difference = foodItem.getAmount();

            for (FoodItem userItem : userInventory) {
                if (userItem.getName().equals(foodItem.getName())) {
                    amount_difference = foodItem.getAmount() - userItem.getAmount();
                    break;
                }
            }

            if (amount_difference <= 0.0) {
                continue;
            }

            foodItemString = foodItem.getName() + ":" + amount_difference; // "Name: Amount"
            foodItemData.add(foodItemString);
        }
    }

    public List<String> getFoodItemData() { return foodItemData; };
}
