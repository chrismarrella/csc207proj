package interface_adapter.get_shopping_list;

import java.util.List;
import entities.FoodItem;

public class GetShoppingListState {
    private List<String> groceryItems = null;
    private String error = null;

    public void updateState(List<String> groceryItems, String error) {
        this.groceryItems = groceryItems;
        this.error = error;
    }

    public void setShoppingListError(String error) {
        this.error = error;
    }

    public List<String> getShoppingList() { return groceryItems; }
}
