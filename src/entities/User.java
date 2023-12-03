package entities;

import java.util.*;

public class User {
    /**
     * This class represents a user of the application.
     */
    private Inventory inventory;
    private DietaryPreferences dietaryRestrictions;

    public User(Map<String, Float> dietaryRestrictions) {
        /**
         * Constructor for User
         * @param dietaryRestrictions the dietary restrictions of the user
         *
         * @return a User object
         */
        this.inventory = new UserInventory();
        this.dietaryRestrictions = new UserDietaryPreferences(dietaryRestrictions);
    }

    public DietaryPreferences getDietaryRestrictions() {
        /**
         * Get the dietary restrictions of the user
         * @return the dietary restrictions of the user
         */
        return this.dietaryRestrictions;
    }

    public Inventory getInventory() {
        /**
         * Get the inventory of the user
         * @return the inventory of the user
         */
        return this.inventory;
    }

    public void addItem(FoodItem item) {
        /**
         * Add an item to the inventory of the user
         * @param item the item to add to the inventory
         */
        this.inventory.addItem(item);
    }

    public FoodItem removeItem() {
        /**
         * Remove an item from the inventory of the user
         * @return the item removed from the inventory
         */
        return this.inventory.removeItem();
    }

    public boolean removeSpecificItem(FoodItem item) {
        /**
         * Remove a specific item from the inventory of the user
         * @param item the item to remove from the inventory
         * @return true if the item was removed, false otherwise
         */
        return this.inventory.removeSpecificItem(item);
    }

    public PriorityQueue<FoodItem> getQueue() {
        /**
         * Get the queue of the inventory of the user
         * @return the queue of the inventory of the user
         */
        return this.inventory.getQueue();
    }

    public void setDietaryRestrictions(Map<String, Float> dietaryRestrictions) {
        /**
         * Set the dietary restrictions of the user
         * @param dietaryRestrictions the dietary restrictions of the user
         */
        this.dietaryRestrictions.setDietaryRestrictions(dietaryRestrictions);
    }

    public void addRestriction(String restriction, Float res) {
        /**
         * Add a dietary restriction to the user
         * @param restriction the dietary restriction to add
         * @param res the value of the dietary restriction
         */
        this.dietaryRestrictions.addRestriction(restriction, res);
    }

    public Boolean removeRestriction(String restriction, Float res) {
        /**
         * Remove a dietary restriction from the user
         * @param restriction the dietary restriction to remove
         * @param res the value of the dietary restriction
         * @return true if the dietary restriction was removed, false otherwise
         */
        return this.dietaryRestrictions.removeRestriction(restriction, res);
    }

    public Float getRestriction(String key) {
        /**
         * Get the value of a dietary restriction
         * @param key the dietary restriction to get the value of
         * @return the value of the dietary restriction
         */
        return this.dietaryRestrictions.getRestriction(key);
    }

    public Set<String> getAllKeys() {
        /**
         * Get all the keys of the dietary restrictions
         * @return all the keys of the dietary restrictions
         */
        return this.dietaryRestrictions.getAllKeys();
    }
}
