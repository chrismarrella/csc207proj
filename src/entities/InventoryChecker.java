package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This class represents the inventory checker of a user.
 */
public class InventoryChecker {
    /**
     * This method checks the inventory of a user for items expiring within the next week.
     * @param userInventory the inventory of the user
     * @return a list of FoodItems expiring within the next week
     */
    public List<FoodItem> weekCheck(Inventory userInventory) {
        PriorityQueue<FoodItem> inv = userInventory.getQueue();
        List<FoodItem> res = new ArrayList<>();
        Calendar plusWeek = Calendar.getInstance();
        plusWeek.add(Calendar.DAY_OF_MONTH, 7);

        for (FoodItem item: inv) {
            if (item.getCalendarObject().compareTo(plusWeek) < 0) {
                res.add(item);
            } else {
                break;
            }
        }

        return res;
    }
}
