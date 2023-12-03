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
        /**
         * This method creates the delete food item presenter.
         * @param deleteFoodItemViewModel The view model for the delete food item view.
         * @param mainMenuViewModel The view model for the main menu view.
         * @param viewManagerModel The view manager model.
         */
        this.deleteFoodItemViewModel = deleteFoodItemViewModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DeleteFoodItemOutputData deleteFoodItemOutputData) {
        /**
         * This method prepares the success view for the delete food item use case.
         * @param deleteFoodItemOutputData The output data from the delete food item use case.
         */
        DeleteFoodItemState state = deleteFoodItemViewModel.getState();
        state.setDeletedFoodItem(deleteFoodItemOutputData.getDeletedFoodItem());
        deleteFoodItemViewModel.setState(state);
        deleteFoodItemViewModel.firePropertyChange();
    }

    @Override
    public void prepareFailView(String error) {
        /**
         * This method prepares the fail view for the delete food item use case of different error cases.
         * @param error The error message to display.
         */
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
