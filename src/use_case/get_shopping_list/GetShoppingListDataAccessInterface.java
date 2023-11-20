package use_case.get_shopping_list;

import entities.FoodItem;
import java.util.List;

public interface GetShoppingListDataAccessInterface {
    List<FoodItem> getInventory();
}
