package use_case.get_shopping_list;

import entities.FoodItem;
import java.util.List;

/**
 * Interface for GetShoppingList's DAO
 */
public interface GetShoppingListDataAccessInterface {
    /**
     * Gets the inventory of the user
     * @return List of FoodItems from the user's inventory
     */
    List<FoodItem> getInventory();
    /**
     * Standardizes the names of the given food item names
     * @return List of standardized food item names
     */
    List<String> standardizeNames(List<String> names);
}
