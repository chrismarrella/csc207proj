package entities;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class User {
    private Inventory inventory;
    private DietaryPreferences dietaryRestrictions;

    public User(Map<String, Boolean> dietaryRestrictions) {
        this.inventory = new UserInventory();
        this.dietaryRestrictions = new UserDietaryPreferences(dietaryRestrictions);
    }

    public DietaryPreferences getDietaryRestrictions() {
        return this.dietaryRestrictions;
    }

    public Inventory getInventory() {
        return this.inventory;
    }
}
