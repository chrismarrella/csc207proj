package use_case.add_fooditem;

import entities.FoodItem;


public class AddFoodItemInteractor implements AddFoodItemInputBoundary {
    AddFoodItemOutputBoundary addFoodItemPresenter;
    AddFoodItemDataAccessInterface addFoodItemDataAccessObject;
    public AddFoodItemInteractor(AddFoodItemOutputBoundary addFoodItemPresenter,
                                 AddFoodItemDataAccessInterface addFoodItemDataAccessObject) {
        this.addFoodItemPresenter = addFoodItemPresenter;
        this.addFoodItemDataAccessObject = addFoodItemDataAccessObject;
    }
    @Override
    public void execute(AddFoodItemInputData addFoodItemInputData) {
        String ingredient = addFoodItemInputData.getIngredient();
        Integer year = addFoodItemInputData.getYear();
        Integer month = addFoodItemInputData.getMonth();
        Integer day = addFoodItemInputData.getDay();
        Float amount = addFoodItemInputData.getAmount();
        FoodItem foodItem = new FoodItem(ingredient, year, month, day, amount);

        addFoodItemDataAccessObject.addItem(foodItem);
        if (ingredient.isEmpty()) {
            addFoodItemPresenter.prepareFailView("Ingredient is empty!");
        }
        else if (month > 12 || day > 31 || day < 0 || month < 0|| year < 0) {
            addFoodItemPresenter.prepareFailView("Invalid date!");
        }
        else {
            addFoodItemDataAccessObject.addItem(foodItem);
            addFoodItemPresenter.prepareSuccessView();
        }
    }
}
