package entities;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class UserInventory implements Inventory, Iterable<FoodItem> {
    private PriorityQueue<FoodItem> inventory;

    public UserInventory() {
        this.inventory = new PriorityQueue<>(new FoodItemComparator());
    }

    public void addItem(FoodItem item) {
        this.inventory.add(item);
    }

    public FoodItem removeItem() {
        return this.inventory.remove();
    }

    public boolean removeSpecificItem(FoodItem item) {
        return this.inventory.remove(item);
    }

    public PriorityQueue<FoodItem> getQueue() {
        return this.inventory;
    }

    private class FoodItemComparator implements Comparator<FoodItem> {
        @Override
        public int compare(FoodItem item1, FoodItem item2) {
            return item1.getCalendarObject().compareTo(item2.getCalendarObject());
        }
    }

    @Override
    public Iterator<FoodItem> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<FoodItem>{
        private int index = 0;
        private FoodItem[] temp = inventory.toArray(new FoodItem[inventory.size()]);

        @Override
        public boolean hasNext() {
            return index < inventory.size();
        }

        @Override
        public FoodItem next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return temp[index++];
        }
    }

}
