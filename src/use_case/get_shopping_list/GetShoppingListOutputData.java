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
            int index = userInventory.indexOf(foodItem);
            if (index != -1) {
                float amount_difference = userInventory.get(index).getAmount() - foodItem.getAmount();
                foodItemString = foodItem.getName() + ": " + amount_difference; // "Name: Amount"
                foodItemData.add(foodItemString);
            }
        }
    }

    public List<String> getFoodItemData() { return foodItemData; };
}
