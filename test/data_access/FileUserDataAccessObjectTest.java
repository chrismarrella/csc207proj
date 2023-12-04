package data_access;

import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileUserDataAccessObjectTest {

    FileUserDataAccessObject dataAccessObject;
    User testUser;
    UserFactory userFactory = new UserFactory();

    private boolean usersEqual(User user1, User user2) {
        if (inventoriesEqual(new ArrayList<>(user1.getInventory().getQueue()), new ArrayList<>(user2.getInventory().getQueue()) )) {
            return dietraryRestrictionsEqual(user1.getDietaryRestrictions(), user2.getDietaryRestrictions());
        }
        else {
            return false;
        }
    }

    private boolean inventoriesEqual(List<FoodItem> inventory1, List<FoodItem> inventory2) {
        if (inventory1.size() == inventory2.size()) {
            for (int i = 0; i < inventory1.size(); i++) {
                if(!foodItemsEqual(inventory1.get(i), inventory2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    private boolean foodItemsEqual(FoodItem item1, FoodItem item2) {
        return item1.getName().equals(item2.getName()) &&
                item1.getExpirationDate().equals(item2.getExpirationDate()) &&
                item1.getAmount().equals(item2.getAmount());
    }

    private boolean dietraryRestrictionsEqual(DietaryPreferences restrictions1, DietaryPreferences restrictions2) {
        for (String key : restrictions1.getAllKeys()) {
            if (!restrictions1.getRestriction(key).equals(restrictions2.getRestriction(key))) {
                return false;
            }
        }

        return true;
    }

    @BeforeEach
    void init() throws IOException {
        dataAccessObject = new FileUserDataAccessObject("./test/data_access/test.csv", userFactory);
        testUser = userFactory.create(new HashMap<>());
        testUser.addItem(new FoodItem("apple", 2023, 10, 10, 1.0f));
        testUser.addItem(new FoodItem("potato", 2023, 10, 10, 5.0f));
        testUser.addItem(new FoodItem("cucumber", 2023, 10, 10, 10.0f));
        testUser.addRestriction("minCarbs", 10F);
        testUser.addRestriction("maxCarbs", 100F);
        testUser.addRestriction("minProtein", 10F);
        testUser.addRestriction("maxProtein", 100F);
        testUser.addRestriction("minCalories", 50F);
        testUser.addRestriction("maxCalories", 800F);
        testUser.addRestriction("minSaturatedFat", 0F);
        testUser.addRestriction("maxSaturatedFat", 100F);
    }

    @Test
    void testSave() throws IOException {
        dataAccessObject.save(testUser);
        // Create secondary dataAccessObject to read from file
        FileUserDataAccessObject dataAccessObject = new FileUserDataAccessObject("./test/data_access/test.csv", userFactory);
        User user = dataAccessObject.get(0);
        assertTrue(usersEqual(testUser, user));
    }

    @Test
    void testGetters() {
        dataAccessObject.save(testUser);
        DietaryPreferences preferences = dataAccessObject.retrievePreferences();
        List<FoodItem> inventory = dataAccessObject.getInventory();
        assertTrue(inventoriesEqual(inventory, new ArrayList<>(testUser.getInventory().getQueue())));
        assertTrue(dietraryRestrictionsEqual(preferences, testUser.getDietaryRestrictions()));
    }

}