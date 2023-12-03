package entities;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class UserInventory implements Inventory, Iterable<FoodItem> {
    /**
     * This class represents the inventory of a user.
     */
    private PriorityQueue<FoodItem> inventory;

    public UserInventory() {
        /**
         * Constructor for UserInventory
         *
         * @return a UserInventory object
         */
        this.inventory = new PriorityQueue<>(new FoodItemComparator());
    }

    public void addItem(FoodItem item) {
        /**
         * Add an item to the inventory of the user
         * @param item the item to add to the inventory
         */
        this.inventory.add(item);
    }

    public FoodItem removeItem() {
        /**
         * Remove an item from the inventory of the user
         * @return the item removed from the inventory
         */
        return this.inventory.remove();
    }

    public boolean removeSpecificItem(FoodItem item) {
        /**
         * Remove a specific item from the inventory of the user
         * @param item the item to remove from the inventory
         * @return true if the item was removed, false otherwise
         */
        return this.inventory.remove(item);
    }

    public PriorityQueue<FoodItem> getQueue() {
        /**
         * Get the inventory of the user
         * @return the inventory of the user
         */
        return this.inventory;
    }

    private class FoodItemComparator implements Comparator<FoodItem> {
        /**
         * This class represents the comparator for FoodItems.
         */
        @Override
        public int compare(FoodItem item1, FoodItem item2) {
            /**
             * Compare two FoodItems
             * @param item1 the first FoodItem to compare
             * @param item2 the second FoodItem to compare
             * @return 1 if item1 is greater than item2, -1 if item1 is less than item2, 0 if item1 is equal to item2
             */
            return item1.getCalendarObject().compareTo(item2.getCalendarObject());
        }
    }

    @Override
    public Iterator<FoodItem> iterator() {
        /**
         * Get an iterator for the inventory
         * @return an iterator for the inventory
         */
        return new Iter();
    }

    private class Iter implements Iterator<FoodItem>{
        /**
         * This class represents the iterator for the inventory.
         */
        private int index = 0;
        private FoodItem[] temp = inventory.toArray(new FoodItem[inventory.size()]);

        @Override
        public boolean hasNext() {
            /**
             * Check if the iterator has a next element
             * @return true if the iterator has a next element, false otherwise
             */
            return index < inventory.size();
        }

        @Override
        public FoodItem next() {
            /**
             * Get the next element of the iterator
             * @return the next element of the iterator
             */
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return temp[index++];
        }
    }

}
