package entities;

import static org.junit.jupiter.api.Assertions.*;
import entities.UserInventory.FoodItemComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

public class UserInventoryTest {

    private UserInventory userInventory;
    private FoodItemComparator comparator;
    private InventoryChecker inventoryChecker;

    @Test
    void testIterator() {
        UserInventory userInventory = new UserInventory();
        FoodItem item1 = new FoodItem("apple", 2024, 1, 1, 1.0f);
        FoodItem item2 = new FoodItem("banana", 2024, 1, 1, 1.0f);
        userInventory.addItem(item1);
        userInventory.addItem(item2);

        Iterator<FoodItem> iterator = userInventory.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(item1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(item2, iterator.next());

        assertFalse(iterator.hasNext());
        assertThrows(java.util.NoSuchElementException.class, iterator::next);
    }
}
