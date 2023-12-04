package entities;

import java.util.*;

/**
 * This class represents a user of the application.
 */
public class User {
    private Inventory inventory;
    private DietaryPreferences dietaryRestrictions;

    /**
     * Constructor for User
     * @param dietaryRestrictions the dietary restrictions of the user
     *
     * @return a User object
     */
    public User(Map<String, Float> dietaryRestrictions) {
        this.inventory = new UserInventory();
        this.dietaryRestrictions = new UserDietaryPreferences(dietaryRestrictions);
    }

    /**
     * Get the dietary restrictions of the user
     * @return the dietary restrictions of the user
     */
    public DietaryPreferences getDietaryRestrictions() {
        return this.dietaryRestrictions;
    }

    /**
     * Get the inventory of the user
     * @return the inventory of the user
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Add an item to the inventory of the user
     * @param item the item to add to the inventory
     */
    public void addItem(FoodItem item) {
        this.inventory.addItem(item);
    }

    /**
     * Remove an item from the inventory of the user
     * @return the item removed from the inventory
     */
    public FoodItem removeItem() {
        return this.inventory.removeItem();
    }

    /**
     * Remove a specific item from the inventory of the user
     * @param item the item to remove from the inventory
     * @return true if the item was removed, false otherwise
     */
    public boolean removeSpecificItem(FoodItem item) {
        return this.inventory.removeSpecificItem(item);
    }

    /**
     * Get the queue of the inventory of the user
     * @return the queue of the inventory of the user
     */
    public PriorityQueue<FoodItem> getQueue() {
        return this.inventory.getQueue();
    }

    /**
     * Set the dietary restrictions of the user
     * @param dietaryRestrictions the dietary restrictions of the user
     */
    public void setDietaryRestrictions(Map<String, Float> dietaryRestrictions) {
        this.dietaryRestrictions.setDietaryRestrictions(dietaryRestrictions);
    }

    /**
     * Add a dietary restriction to the user
     * @param restriction the dietary restriction to add
     * @param res the value of the dietary restriction
     */
    public void addRestriction(String restriction, Float res) {
        this.dietaryRestrictions.addRestriction(restriction, res);
    }

    /**
     * Remove a dietary restriction from the user
     * @param restriction the dietary restriction to remove
     * @param res the value of the dietary restriction
     * @return true if the dietary restriction was removed, false otherwise
     */
    public Boolean removeRestriction(String restriction, Float res) {
        return this.dietaryRestrictions.removeRestriction(restriction, res);
    }

    /**
     * Get the value of a dietary restriction
     * @param key the dietary restriction to get the value of
     * @return the value of the dietary restriction
     */
    public Float getRestriction(String key) {
        return this.dietaryRestrictions.getRestriction(key);
    }

    /**
     * Get all the keys of the dietary restrictions
     * @return all the keys of the dietary restrictions
     */
    public Set<String> getAllKeys() {
        return this.dietaryRestrictions.getAllKeys();
    }
}
