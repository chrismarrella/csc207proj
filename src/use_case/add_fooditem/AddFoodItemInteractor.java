package use_case.add_fooditem;

import com.sun.jdi.IntegerValue;
import entities.FoodItem;
import entities.DateValidatorService;
import entities.IngredientValidatorService;

/**
 * The interactor for the add food item use case.
 * This class is used to execute the use case.
 */
public class AddFoodItemInteractor implements AddFoodItemInputBoundary {
    AddFoodItemOutputBoundary addFoodItemPresenter;
    AddFoodItemDataAccessInterface addFoodItemDataAccessObject;

    /**
     * The constructor for the add food item interactor.
     * @param addFoodItemPresenter    the presenter for the use case
     * @param addFoodItemDataAccessObject    the data access object for the use case
     */
    public AddFoodItemInteractor(AddFoodItemOutputBoundary addFoodItemPresenter,
                                 AddFoodItemDataAccessInterface addFoodItemDataAccessObject) {
        this.addFoodItemPresenter = addFoodItemPresenter;
        this.addFoodItemDataAccessObject = addFoodItemDataAccessObject;
    }

    /**
     * Executes the use case.
     * The method calls the inputs and checks whether each input is valid or not. If the input
     * is not valid, then the method will call the presenter to prepare the fail view. If the input
     * is valid, then the method will call the data access object to add the food item to the database
     * and prepare the success view.
     * @param addFoodItemInputData    the input data for the use case
     */
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
