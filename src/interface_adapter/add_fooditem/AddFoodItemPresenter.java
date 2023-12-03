package interface_adapter.add_fooditem;

import use_case.add_fooditem.AddFoodItemOutputBoundary;
import use_case.add_fooditem.AddFoodItemOutputData;
import interface_adapter.add_fooditem.AddFoodItemViewModel;
import interface_adapter.add_fooditem.AddFoodItemState;

import java.util.Objects;
/**
 * Presenter responsible for handling the output data from the add food item use case.
 * This class acts as a bridge between the interactor and the view model.
 * It receives output data related to adding a food item and prepare the success view or failed
 * view accordingly.
 */
public class AddFoodItemPresenter implements AddFoodItemOutputBoundary {
    private final AddFoodItemViewModel addFoodItemViewModel;

    /**
     * Constructor for the AddFoodItemPresenter
     * @param addFoodItemViewModel    the view model responsible for handling the output data
     */
    public AddFoodItemPresenter(AddFoodItemViewModel addFoodItemViewModel) {
        this.addFoodItemViewModel = addFoodItemViewModel;
    }


    /**
     * Prepares the success view with the given output data. The set is then set and
     * the view model fire a property change.
     */
    @Override
    public void prepareSuccessView() {
        AddFoodItemState addFoodItemState = addFoodItemViewModel.getState();
        addFoodItemViewModel.setState(addFoodItemState);
        addFoodItemViewModel.firePropertyChange();
    }

    /**
     * Prepares the failed view with the given error. The set is then set and
     * the view model fire a property change.
     * @param error    the error that occurred represented in a String.
     */
    @Override
    public void prepareFailView(String error) {
        AddFoodItemState addFoodItemState = addFoodItemViewModel.getState();
        if (error.equals("Ingredient is invalid!")) {
            addFoodItemState.setIngredientError(error);
        } else if (error.equals("Invalid Date!")) {
            addFoodItemState.setDateError(error);
        } else {
            addFoodItemState.setAmountError(error);
        }
        addFoodItemViewModel.setState(addFoodItemState);
        addFoodItemViewModel.firePropertyChange();
    }
}
