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
        addFoodItemState.updateState(null);
        addFoodItemViewModel.firePropertyChange();
    }

    @Override
    public void prepareFailView(String error) {
        AddFoodItemState addFoodItemState = addFoodItemViewModel.getState();
        addFoodItemState.setFoodItemError(error);
        addFoodItemViewModel.firePropertyChange();
        addFoodItemState.setFoodItemError(null);
    }
}
