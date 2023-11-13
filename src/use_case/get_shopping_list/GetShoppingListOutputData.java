package use_case.get_shopping_list;

import entities.FoodItem;

import java.util.List;
import java.util.ArrayList;

public class GetShoppingListOutputData {

    private final List<String> foodItemData;
    private final boolean useCaseFailed; // May not be necessary

    public GetShoppingListOutputData(List<FoodItem> foodItems, boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;

        String foodItemString;
        foodItemData = new ArrayList<String>();
        for (FoodItem foodItem : foodItems) {
            foodItemString = foodItem.getName() + ": " + foodItem.getAmount().toString(); // "Name: Amount"
            foodItemData.add(foodItemString);
        }
    }

    public List<String> getFoodItemData() { return foodItemData; };
}
