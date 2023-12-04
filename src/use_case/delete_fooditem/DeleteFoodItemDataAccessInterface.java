package use_case.delete_fooditem;

import entities.FoodItem;

import java.util.PriorityQueue;

public interface DeleteFoodItemDataAccessInterface {

    /**
     * Removes a specific item from the queue.
     * @param item the item to be removed.
     * @return true if the item was removed, false otherwise.
     */
    boolean removeSpecificItem(FoodItem item);

    /**
     * @return the queue of food items in the inventory.
     */
    PriorityQueue<FoodItem> getQueue();

    /**
     * Adds a food item to the inventory.
     * @param item the food item to be added to the inventory.
     */
    void addItem(FoodItem item);
}
