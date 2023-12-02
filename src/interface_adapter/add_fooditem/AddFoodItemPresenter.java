package interface_adapter.add_fooditem;

import use_case.add_fooditem.AddFoodItemOutputBoundary;
import use_case.add_fooditem.AddFoodItemOutputData;
import interface_adapter.add_fooditem.AddFoodItemViewModel;
import interface_adapter.add_fooditem.AddFoodItemState;

import java.util.Objects;

public class AddFoodItemPresenter implements AddFoodItemOutputBoundary {
    private final AddFoodItemViewModel addFoodItemViewModel;

    public AddFoodItemPresenter(AddFoodItemViewModel addFoodItemViewModel) {
        this.addFoodItemViewModel = addFoodItemViewModel;
    }

    @Override
    public void prepareSuccessView() {
        AddFoodItemState addFoodItemState = addFoodItemViewModel.getState();
        addFoodItemViewModel.setState(addFoodItemState);
        addFoodItemViewModel.firePropertyChange();
    }

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
//        addFoodItemState.setFoodItemError(error);
        addFoodItemViewModel.setState(addFoodItemState);
        addFoodItemViewModel.firePropertyChange();
    }
}
