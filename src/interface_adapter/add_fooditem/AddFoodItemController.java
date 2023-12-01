package interface_adapter.add_fooditem;
import use_case.add_fooditem.AddFoodItemInputData;
import use_case.add_fooditem.AddFoodItemInputBoundary;

public class AddFoodItemController {
    final AddFoodItemInputBoundary addFoodItemInteractor;
    public AddFoodItemController(AddFoodItemInputBoundary addFoodItemInteractor) {
        this.addFoodItemInteractor = addFoodItemInteractor;
    }
    public void execute(String ingredient, String year, String month, String day, String amount) {
        AddFoodItemInputData addFoodItemInputData = new AddFoodItemInputData(ingredient, year, month, day, amount);
        addFoodItemInteractor.execute(addFoodItemInputData);
    }
}
