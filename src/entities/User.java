package entities;

import java.util.*;

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

    public void addItem(FoodItem item) {
        this.inventory.addItem(item);
    }

    public FoodItem removeItem() {
        return this.inventory.removeItem();
    }

    public boolean removeSpecificItem(FoodItem item) {
        return this.inventory.removeSpecificItem(item);
    }

    public PriorityQueue<FoodItem> getQueue() {
        return this.inventory.getQueue();
    }

    public void setDietaryRestrictions(Map<String, Boolean> dietaryRestrictions) {
        this.dietaryRestrictions.setDietaryRestrictions(dietaryRestrictions);
    }

    public void addRestriction(String restriction, Boolean res) {
        this.dietaryRestrictions.addRestriction(restriction, res);
    }

    public Boolean removeRestriction(String restriction, Boolean res) {
        return this.dietaryRestrictions.removeRestriction(restriction, res);
    }

    public Boolean getRestriction(String key) {
        return this.dietaryRestrictions.getRestriction(key);
    }

    public Set<String> getAllKeys() {
        return this.dietaryRestrictions.getAllKeys();
    }
}
