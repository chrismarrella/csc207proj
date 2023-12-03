package use_case.get_shopping_list;

import entities.FoodItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GetShoppingListInteractorTest {
    private GetShoppingListInteractor getShoppingListInteractor;
    private testOutputBoundary getShoppingListPresenter;
    private testDataAccessInterface dataAccessInterface;

    private class testDataAccessInterface implements GetShoppingListDataAccessInterface {
        private List<FoodItem> inventory;

        public testDataAccessInterface() {
            this.inventory = new ArrayList<>();
        }
        public void addToInventory(FoodItem foodItem) {
            this.inventory.add(foodItem);
        }
        @Override
        public List<FoodItem> getInventory() {
            return inventory;
        }

        @Override
        public List<String> standardizeNames(List<String> names) {
            return names;   // No need to standardize the names for testing
        }
    }

    private class testOutputBoundary implements GetShoppingListOutputBoundary {
        private List<String> foodItemData;
        private boolean useCaseFailed;

        public testOutputBoundary() {
            this.foodItemData = new ArrayList<>();
            this.useCaseFailed = false;
        }

        @Override
        public void prepareSuccessView(GetShoppingListOutputData outputData) {
            this.foodItemData = outputData.getFoodItemData();
        }

        @Override
        public void prepareFailView(String error) {
            this.useCaseFailed = true;
        }

        public List<String> getFoodItemData() {
            return foodItemData;
        }

        public boolean getUseCaseFailed() {
            return useCaseFailed;
        }
    }
    @BeforeEach
    public void init() {
        getShoppingListPresenter = new testOutputBoundary();
        dataAccessInterface = new testDataAccessInterface();
        getShoppingListInteractor = new GetShoppingListInteractor(getShoppingListPresenter, dataAccessInterface);
    }

    @Test
    public void testBasicSuccessView() {
        List<String> recipeIngredients = new ArrayList<>();
        recipeIngredients.add("apple:1.0");
        recipeIngredients.add("banana:2.0");
        recipeIngredients.add("orange:3.0");
        GetShoppingListInputData inputData = new GetShoppingListInputData(recipeIngredients);
        getShoppingListInteractor.execute(inputData);
        List<String> expectedFoodItemData = new ArrayList<>();
        expectedFoodItemData.add("apple:1.0");
        expectedFoodItemData.add("banana:2.0");
        expectedFoodItemData.add("orange:3.0");
        assertEquals(expectedFoodItemData, getShoppingListPresenter.getFoodItemData());
    }

    @Test
    public void testSuccessViewWithFilledInventory() {
        List<String> recipeIngredients = new ArrayList<>();
        recipeIngredients.add("apple:1.0");
        recipeIngredients.add("banana:2.0");
        recipeIngredients.add("orange:3.0");
        dataAccessInterface.addToInventory(new FoodItem("apple", 1.0f));
        dataAccessInterface.addToInventory(new FoodItem("orange", 1.5f));
        GetShoppingListInputData inputData = new GetShoppingListInputData(recipeIngredients);
        getShoppingListInteractor.execute(inputData);
        List<String> expectedFoodItemData = new ArrayList<>();
        expectedFoodItemData.add("banana:2.0");
        expectedFoodItemData.add("orange:1.5");
        assertEquals(expectedFoodItemData, getShoppingListPresenter.getFoodItemData());
    }

    @Test
    public void testFailViewWithEmptyRecipeItems() {
        List<String> recipeIngredients = new ArrayList<>();
        GetShoppingListInputData inputData = new GetShoppingListInputData(recipeIngredients);
        getShoppingListInteractor.execute(inputData);
        assertTrue(getShoppingListPresenter.getUseCaseFailed());
    }
}