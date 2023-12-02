package interface_adapter.delete_foodItem;

import app.Main;
import interface_adapter.ViewManagerModel;
import interface_adapter.delete_foodItem.DeleteFoodItemState;
import interface_adapter.delete_foodItem.DeleteFoodItemViewModel;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import use_case.delete_foodItem.DeleteFoodItemOutputBoundary;
import use_case.delete_foodItem.DeleteFoodItemOutputData;

public class DeleteFoodItemPresenter implements DeleteFoodItemOutputBoundary {

    private final DeleteFoodItemViewModel deleteFoodItemViewModel;
    private final MainMenuViewModel mainMenuViewModel;
    private ViewManagerModel viewManagerModel;

    public DeleteFoodItemPresenter(DeleteFoodItemViewModel deleteFoodItemViewModel,
                                   MainMenuViewModel mainMenuViewModel,
                                   ViewManagerModel viewManagerModel) {
        this.deleteFoodItemViewModel = deleteFoodItemViewModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DeleteFoodItemOutputData deleteFoodItemOutputData) {
        DeleteFoodItemState state = deleteFoodItemViewModel.getState();
        state.setDeletedFoodItem(deleteFoodItemOutputData.getDeletedFoodItem());
        deleteFoodItemViewModel.setState(state);
        deleteFoodItemViewModel.firePropertyChange();
    }

    @Override
    public void prepareFailView(String error) {
        DeleteFoodItemState state = deleteFoodItemViewModel.getState();

        if (error.equals("No such food item.")) {
            state.setFoodItemError(error);
        } else if (error.equals("Too large amount.")){
            state.setAmountError(error);
        } else {
            state.setAmountDataTypeError(error);
        }

        deleteFoodItemViewModel.setState(state);
        deleteFoodItemViewModel.firePropertyChange();
    }
}
