package interface_adapter.get_shopping_list;

import java.util.List;
import entities.FoodItem;

/**
 * State for GetShoppingList use case
 */
public class GetShoppingListState {
    private List<String> shoppingList = null;
    private String error = null;

    /**
     * Updates the state with the given parameters
     * @param groceryItems List of grocery items
     * @param error Error message to be displayed
     */
    public void updateState(List<String> groceryItems, String error) {
        this.shoppingList = groceryItems;
        this.error = error;
    }

    /**
     * Sets the error message
     * @param error Error message to be displayed
     */
    public void setShoppingListError(String error) {
        this.error = error;
    }

    /**
     * Getter for error
     * @return Error message to be displayed
     */
    public String getError() { return this.error; }

    /**
     * Getter for shoppingList
     * @return List of items in the shopping list
     */
    public List<String> getShoppingList() { return shoppingList; }
}
