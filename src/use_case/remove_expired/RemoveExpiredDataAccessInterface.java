package use_case.remove_expired;

import entities.FoodItem;

import java.util.PriorityQueue;

public interface RemoveExpiredDataAccessInterface {

    /**
     * @return the queue of food items in the user's inventory as a priority queue of food items.
     */
    PriorityQueue<FoodItem> getQueue();

    /**
     * Remove the food item at the top of the priority queue of food items in the user's inventory.
     */
    void removeItem();
}
