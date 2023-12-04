package use_case.add_fooditem;
import entities.FoodItem;

/**
 * The interface for the add food item data access.
 * This interface is used to add a food item to the database.
 */
public interface AddFoodItemDataAccessInterface {

    /**
     * Adds a food item to the database.
     * @param foodItem    the food item to be added
     */
    void addItem(FoodItem foodItem);

}
