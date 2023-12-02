package interface_adapter.add_fooditem;
import use_case.add_fooditem.AddFoodItemInputData;
import use_case.add_fooditem.AddFoodItemInputBoundary;
/**
 * Controller responsible for handling the addition of food items.
 *
 * This class acts as a bridge between the user interface and the application logic.
 * It receives input data related to adding a food item and implements the execution
 * of the addFoodItemIteractor.
 */
public class AddFoodItemController {
    /**
     * The addFoodItemInteractor is responsible for handling the addition of food items.
     */
    final AddFoodItemInputBoundary addFoodItemInteractor;
    public AddFoodItemController(AddFoodItemInputBoundary addFoodItemInteractor) {
        this.addFoodItemInteractor = addFoodItemInteractor;
    }
    public void execute(String ingredient, String year, String month, String day, String amount) {
        AddFoodItemInputData addFoodItemInputData = new AddFoodItemInputData(ingredient, year, month, day, amount);
        addFoodItemInteractor.execute(addFoodItemInputData);
    }
}
