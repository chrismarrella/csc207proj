package use_case.removeExpired;

import entities.FoodItem;
import entities.User;

import java.util.Calendar;
import java.util.PriorityQueue;
import java.util.function.Predicate;

public interface RemoveExpiredDataAccessInterface {
    PriorityQueue<FoodItem> getQueue();
    void removeItem();
}
