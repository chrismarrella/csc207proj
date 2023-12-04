package entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryCheckerTest {

    /**
     * Test week checker with different "food" items :)
     */
    @Test
    void testWeekChecker() {
        FoodItem item1 = new FoodItem("sam", 2023, 12, 4, 1);
        FoodItem item2 = new FoodItem("junhee", 2023, 12, 9, 1);
        FoodItem item3 = new FoodItem("sasha", 2023, 12, 11, 1);
        FoodItem item4 = new FoodItem("chris", 2023, 12, 12, 1);
        FoodItem item5 = new FoodItem("jin hao", 2023, 12, 15, 1);

        List<FoodItem> res = new ArrayList<>();
        res.add(item1);
        res.add(item2);

        Inventory inv = new UserInventory();
        inv.addItem(item1);
        inv.addItem(item2);
        inv.addItem(item3);
        inv.addItem(item4);
        inv.addItem(item5);

        assertEquals(res, new InventoryChecker().weekCheck(inv));
    }

}