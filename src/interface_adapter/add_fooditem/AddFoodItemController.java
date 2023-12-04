package interface_adapter.add_fooditem;
import use_case.add_fooditem.AddFoodItemInputData;
import use_case.add_fooditem.AddFoodItemInputBoundary;
/**
 * Controller responsible for handling the addition of food items.
 * This class acts as a bridge between the user interface and the interactor.
 * It receives input data related to adding a food item and implements the execution
 * of the addFoodItemIteractor.
 */
public class AddFoodItemController {
    /**
     * The addFoodItemInteractor is responsible for handling the addition of food items.
     */
    final AddFoodItemInputBoundary addFoodItemInteractor;

    /**
     * Constructor for the AddFoodItemController
     * @param addFoodItemInteractor    the interactor responsible for handling the addition of food items.
     */
    public AddFoodItemController(AddFoodItemInputBoundary addFoodItemInteractor) {
        this.addFoodItemInteractor = addFoodItemInteractor;
    }

    /**
     * Executes the addFoodItemInteractor with the given input data.
     * @param ingredient    the ingredient to be added
     * @param year          the year of the date inputted
     * @param month         the month of the date inputted
     * @param day           the day of the date inputted
     * @param amount        the amount of the ingredient to be added
     */
    public void execute(String ingredient, String year, String month, String day, String amount) {
        AddFoodItemInputData addFoodItemInputData = new AddFoodItemInputData(ingredient, year, month, day, amount);
        addFoodItemInteractor.execute(addFoodItemInputData);
    }
}
