package use_case.get_shopping_list;

import data_access.FileUserDataAccessObject;
import entities.FoodItem;
import entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class GetShoppingListInteractor implements GetShoppingListInputBoundary {

    private GetShoppingListOutputBoundary getShoppingListPresenter;
    private GetShoppingListDataAccessInterface dataAccessInterface;

    public GetShoppingListInteractor(GetShoppingListOutputBoundary getRecipePresenter, GetShoppingListDataAccessInterface dataAccessInterface) {
        this.getShoppingListPresenter = getRecipePresenter;
        this.dataAccessInterface = dataAccessInterface;
    }
    public void execute(GetShoppingListInputData inputData) {
        List<FoodItem> recipeIngredients = inputDataToFoodItems(inputData);
        if(!recipeIngredients.isEmpty()) {
            List<FoodItem> userInventory = dataAccessInterface.getInventory();
            standardizeFoodItems(userInventory);
            GetShoppingListOutputData outputData = new GetShoppingListOutputData(recipeIngredients, userInventory , false);
            getShoppingListPresenter.prepareSuccessView(outputData);
        }
        else
            getShoppingListPresenter.prepareFailView("No Ingredients Provided");
    }

    private List<FoodItem> inputDataToFoodItems(GetShoppingListInputData inputData) {
        List<String> recipeIngredients = inputData.getRecipeIngredients();

        List<FoodItem> recipeFoodItems = new ArrayList<>();

        for (String ingredient : recipeIngredients) {
            String[] ingredientData = ingredient.split(":");
            FoodItem foodItem = new FoodItem(ingredientData[0], Float.parseFloat(ingredientData[1]));
            recipeFoodItems.add(foodItem);
        }

        standardizeFoodItems(recipeFoodItems);

        return recipeFoodItems;
    }

    private void standardizeFoodItems(List<FoodItem> foodItems) {
        List<String> names = new ArrayList<>();
        for (FoodItem foodItem : foodItems) {
            names.add(foodItem.getName());
        }
        names = dataAccessInterface.standardizeNames(names);
        for (int i = 0; i < names.size(); i++) {
            FoodItem foodItem = foodItems.get(i);
            foodItem.setName(names.get(i));
        }
    }
}
