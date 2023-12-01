package entities;

import java.util.PriorityQueue;

public interface Inventory {

    void addItem(FoodItem item);

    FoodItem removeItem();

    boolean removeSpecificItem(FoodItem item);

    PriorityQueue<FoodItem> getQueue();
}
