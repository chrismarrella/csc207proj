package use_case.add_fooditem;

import com.sun.jdi.IntegerValue;
import entities.FoodItem;
import entities.DateValidatorService;
import entities.IngredientValidatorService;

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
        DateValidatorService dateValidatorService = new DateValidatorService();
        IngredientValidatorService ingredientValidatorService = new IngredientValidatorService();

        if (!ingredientValidatorService.ingredientIsValid(ingredient)) {
            addFoodItemPresenter.prepareFailView("Ingredient is invalid!");
        } else if (!dateValidatorService.dateIsValid(year, month, day)) {
            addFoodItemPresenter.prepareFailView("Invalid Date!");
        } else if  (amount <= 0.0f) {
            addFoodItemPresenter.prepareFailView("Amount is invalid!");
        }
        else {
            addFoodItemDataAccessObject.addItem(foodItem);
            addFoodItemPresenter.prepareSuccessView();
        }
    }
}
