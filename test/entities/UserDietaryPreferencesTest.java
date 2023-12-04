package entities;

import entities.UserDietaryPreferences;
import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.PriorityQueue;
import static org.junit.jupiter.api.Assertions.*;

class UserDietaryPreferencesTest {

    private UserDietaryPreferences userDietaryPreferences;

    @BeforeEach
    void setUp() {
        Map<String, Float> dietaryRestrictions = new HashMap<>();
        dietaryRestrictions.put("apple", 1.0f);
        userDietaryPreferences = new UserDietaryPreferences(dietaryRestrictions);
    }

    @Test
    void testGetRestrictionMap() {
        Map<String, Float> dietaryRestrictions = new HashMap<>();
        dietaryRestrictions.put("apple", 1.0f);
        assertEquals(dietaryRestrictions, userDietaryPreferences.getRestrictionMap());
    }

    @Test
    void testGetDietaryRestrictions() {
        Map<String, Float> dietaryRestrictions = new HashMap<>();
        dietaryRestrictions.put("apple", 1.0f);
        assertEquals(userDietaryPreferences, userDietaryPreferences.getDietaryRestrictions());
    }

}