package interface_adapter.get_shopping_list;

import entities.FoodItem;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.get_shopping_list.GetShoppingListOutputData;

import static org.junit.jupiter.api.Assertions.*;

class GetShoppingListPresenterTest {
    private GetShoppingListPresenter getShoppingListPresenter;
    private GetShoppingListViewModel getShoppingListViewModel;

    private TestView testView;

    private class TestView implements PropertyChangeListener {
        List<String> shoppingList = null;
        String error = null;
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            GetShoppingListState state = (GetShoppingListState) evt.getNewValue();
            shoppingList = state.getShoppingList();
            error = state.getError();
        }
    }
    @BeforeEach
    void init() {
        getShoppingListViewModel = new GetShoppingListViewModel();
        getShoppingListPresenter = new GetShoppingListPresenter(getShoppingListViewModel);
        testView = new TestView();
        getShoppingListViewModel.addPropertyChangeListener(testView);
    }
    @Test
    void testPrepareSuccessView() {
        List<FoodItem> recipeItems = new ArrayList<>();
        recipeItems.add(new FoodItem("apple", 1.0f));
        recipeItems.add(new FoodItem("potato", 5.0f));
        recipeItems.add(new FoodItem("egg", 12.0f));
        List<FoodItem> userInventory = new ArrayList<>();
        userInventory.add(new FoodItem("apple", 1.0f));
        userInventory.add(new FoodItem("potato", 2.75f));
        userInventory.add(new FoodItem("egg", 6.0f));
        GetShoppingListOutputData outputData = new GetShoppingListOutputData(recipeItems, userInventory, false);
        getShoppingListPresenter.prepareSuccessView(outputData);
        List<String> expectedFoodItemData = new ArrayList<>();
        expectedFoodItemData.add("potato:2.25");
        expectedFoodItemData.add("egg:6.0");
        assertEquals(expectedFoodItemData, testView.shoppingList);
    }
    @Test
    void testPrepareFailView() {
        getShoppingListPresenter.prepareFailView("Failed to generate a shopping list");
        assertEquals("Failed to generate a shopping list", testView.error);
    }
}