package entities;

import java.util.PriorityQueue;

/**
 * This interface represents the inventory of a user.
 */
public interface Inventory {

    void addItem(FoodItem item);

    FoodItem removeItem();

    boolean removeSpecificItem(FoodItem item);

    PriorityQueue<FoodItem> getQueue();
}
