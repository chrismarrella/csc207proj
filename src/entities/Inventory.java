package entities;

import java.util.PriorityQueue;

public interface Inventory {
    /**
     * This interface represents the inventory of a user.
     */

    void addItem(FoodItem item);

    FoodItem removeItem();

    boolean removeSpecificItem(FoodItem item);

    PriorityQueue<FoodItem> getQueue();
}
