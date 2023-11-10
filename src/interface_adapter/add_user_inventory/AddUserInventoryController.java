package interface_adapter.add_user_inventory;
import use_case.add_user_inventory.AddUserInventoryInputData;
import use_case.add_user_inventory.AddUserInventoryInputBoundary;

public class AddUserInventoryController {
    final AddUserInventoryInputBoundary addUserInventoryInteractor;
    public AddUserInventoryController(AddUserInventoryInputBoundary addUserInventoryInteractor) {
        this.addUserInventoryInteractor = addUserInventoryInteractor;
    }
    public void execute(String ingredient) {
        AddUserInventoryInputData addUserInventoryInputData = new AddUserInventoryInputData(ingredient);
        addUserInventoryInteractor.execute(addUserInventoryInputData);
    }
}
