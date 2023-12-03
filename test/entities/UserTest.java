package entities;

import entities.UserDietaryPreferences;
import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.PriorityQueue;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    @BeforeEach
    void setUp() {
        Map<String, Float> dietaryRestrictions = new HashMap<>();
        dietaryRestrictions.put("apple", 1.0f);
        user = new User(dietaryRestrictions);
    }

    @Test
    void testAddItemToInventory() {
        FoodItem apple = new FoodItem("Apple", 2024, 1, 1, 1.0f);
        user.addItem(apple);
        assertTrue(user.getInventory().getQueue().contains(apple));
    }

    @Test
    void testRemoveItemFromInventory() {
        FoodItem banana = new FoodItem("Banana", 2024, 1, 1, 1.0f);
        user.addItem(banana);
        FoodItem removedItem = user.removeItem();
        assertEquals(banana, removedItem);
        assertFalse(user.getInventory().getQueue().contains(banana));
    }

    @Test
    void testRemoveSpecificItemFromInventory() {
        FoodItem orange = new FoodItem("Orange", 2024, 1, 1, 1.0f);
        user.addItem(orange);
        assertTrue(user.removeSpecificItem(orange));
        assertFalse(user.getInventory().getQueue().contains(orange));
    }

    @Test
    void testGetQueue() {
        PriorityQueue<FoodItem> queue = user.getQueue();
        assertNotNull(queue);
        assertTrue(queue.isEmpty());
    }

    @Test
    void testSetDietaryRestrictions() {
        Map<String, Float> newRestrictions = new HashMap<>();
        newRestrictions.put("banana", 0.5f);
        user.setDietaryRestrictions(newRestrictions);
        assertEquals(newRestrictions.get("banana"), user.getDietaryRestrictions().getRestriction("banana"));
    }

    @Test
    void testAddRestriction() {
        user.addRestriction("banana", 0.5f);
        assertEquals(0.5f, user.getRestriction("banana"));
    }

    @Test
    void testRemoveRestriction() {
        user.addRestriction("banana", 0.5f);
        assertTrue(user.removeRestriction("banana", 0.5f));
        assertFalse(user.getDietaryRestrictions().getAllKeys().contains("banana"));
    }

    @Test
    void testGetAllKeys() {
        Set<String> keys = user.getAllKeys();
        assertEquals(1, keys.size());
        assertTrue(keys.contains("apple"));
    }
}
