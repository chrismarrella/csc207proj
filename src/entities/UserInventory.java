package entities;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * This class represents the inventory of a user.
 */
public class UserInventory implements Inventory, Iterable<FoodItem> {
    private PriorityQueue<FoodItem> inventory;

    /**
     * Constructor for UserInventory
     *
     */
    public UserInventory() {
        this.inventory = new PriorityQueue<>(new FoodItemComparator());
    }

    /**
     * Add an item to the inventory of the user
     * @param item the item to add to the inventory
     */
    public void addItem(FoodItem item) {
        this.inventory.add(item);
    }

    /**
     * Remove an item from the inventory of the user
     * @return the item removed from the inventory
     */
    public FoodItem removeItem() {
        return this.inventory.remove();
    }

    /**
     * Remove a specific item from the inventory of the user
     * @param item the item to remove from the inventory
     * @return true if the item was removed, false otherwise
     */
    public boolean removeSpecificItem(FoodItem item) {
        return this.inventory.remove(item);
    }

    /**
     * Get the inventory of the user
     * @return the inventory of the user
     */
    public PriorityQueue<FoodItem> getQueue() {
        return this.inventory;
    }

    /**
     * This class represents the comparator for FoodItems.
     */
    private class FoodItemComparator implements Comparator<FoodItem> {
        /**
         * Compare two FoodItems
         * @param item1 the first FoodItem to compare
         * @param item2 the second FoodItem to compare
         * @return 1 if item1 is greater than item2, -1 if item1 is less than item2, 0 if item1 is equal to item2
         */
        @Override
        public int compare(FoodItem item1, FoodItem item2) {
            return item1.getCalendarObject().compareTo(item2.getCalendarObject());
        }
    }

    /**
     * Get an iterator for the inventory
     * @return an iterator for the inventory
     */
    @Override
    public Iterator<FoodItem> iterator() {
        return new Iter();
    }

    /**
     * This class represents the iterator for the inventory.
     */
    private class Iter implements Iterator<FoodItem>{
        private int index = 0;
        private FoodItem[] temp = inventory.toArray(new FoodItem[inventory.size()]);

        /**
         * Check if the iterator has a next element
         * @return true if the iterator has a next element, false otherwise
         */
        @Override
        public boolean hasNext() {
            return index < inventory.size();
        }

        /**
         * Get the next element of the iterator
         * @return the next element of the iterator
         */
        @Override
        public FoodItem next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return temp[index++];
        }
    }

}
