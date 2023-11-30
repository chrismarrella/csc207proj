package use_case.delete_foodItem;

import entities.FoodItem;

import java.util.PriorityQueue;

public interface DeleteFoodItemDataAccessInterface {
    boolean removeSpecificItem(FoodItem item);
    PriorityQueue<FoodItem> getQueue();
    void addItem(FoodItem item);
}
