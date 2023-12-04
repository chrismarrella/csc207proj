package entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryCheckerTest {

    private static Calendar calendar;
    @BeforeAll
    static void setUp() {
        calendar = Calendar.getInstance();
    }

    /**
     * Test week checker with different "food" items :)
     */
    @Test
    void testWeekChecker() {
        int year;
        int month;
        int day;

        calendar.add(Calendar.DAY_OF_MONTH, 2);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        //2 days from now
        FoodItem item1 = new FoodItem("sam", year, month, day, 1);

        calendar.add(Calendar.DAY_OF_MONTH, 5);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        //7 days from now
        FoodItem item2 = new FoodItem("junhee", year, month, day, 1);

        calendar.add(Calendar.DAY_OF_MONTH, 3);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        //10 days from now
        FoodItem item3 = new FoodItem("sasha", year, month, day, 1);

        calendar.add(Calendar.MONTH, 1);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        //~1 month from now
        FoodItem item4 = new FoodItem("chris", year, month, day, 1);

        calendar.add(Calendar.YEAR, 1);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        //~1 year from now
        FoodItem item5 = new FoodItem("jin hao", year, month, day, 1);

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