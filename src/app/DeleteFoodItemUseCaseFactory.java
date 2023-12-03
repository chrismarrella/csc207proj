package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.delete_foodItem.DeleteFoodItemViewModel;
import interface_adapter.delete_foodItem.DeleteFoodItemController;
import interface_adapter.delete_foodItem.DeleteFoodItemPresenter;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuViewModel;
import use_case.delete_foodItem.DeleteFoodItemInputBoundary;
import use_case.delete_foodItem.DeleteFoodItemInteractor;
import use_case.delete_foodItem.DeleteFoodItemOutputBoundary;
import use_case.delete_foodItem.DeleteFoodItemDataAccessInterface;
import view.DeleteFoodItemView;
import view.MainMenuView;

import javax.swing.*;
import java.io.IOException;

public class DeleteFoodItemUseCaseFactory {

    private DeleteFoodItemUseCaseFactory() {

    }

    public static DeleteFoodItemView create(
            ViewManagerModel viewManagerModel, DeleteFoodItemViewModel deleteFoodItemViewModel,
            MainMenuViewModel mainMenuViewModel, MainMenuController mainMenuController,
            DeleteFoodItemDataAccessInterface deleteFoodItemDataAccessInterface) {
        /**
         * This method creates the delete food item view.
         * @param viewManagerModel The view manager model.
         * @param deleteFoodItemViewModel The view model for the delete food item view.
         * @param mainMenuViewModel The view model for the main menu view.
         * @param mainMenuController The controller for the main menu view.
         * @param deleteFoodItemDataAccessInterface The data access object for deleting a food item.
         */
        try {
            DeleteFoodItemController deleteFoodItemController = createDeleteFoodItemUseCase(viewManagerModel,
                    deleteFoodItemViewModel, mainMenuViewModel, deleteFoodItemDataAccessInterface);

            return new DeleteFoodItemView(
                    deleteFoodItemViewModel, deleteFoodItemController, mainMenuViewModel, mainMenuController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static DeleteFoodItemController createDeleteFoodItemUseCase(
            ViewManagerModel viewManagerModel, DeleteFoodItemViewModel deleteFoodItemViewModel,
            MainMenuViewModel mainMenuViewModel, DeleteFoodItemDataAccessInterface deleteFoodItemDataAccessInterface)
            throws IOException {
        /** This method creates the delete food item controller.
         * @param viewManagerModel The view manager model.
         * @param deleteFoodItemViewModel The view model for the delete food item view.
         * @param mainMenuViewModel The view model for the main menu view.
         * @param deleteFoodItemDataAccessInterface The data access object for deleting a food item.
         * @throws IOException If the user data csv file cannot be opened.
         */
        DeleteFoodItemOutputBoundary deleteFoodItemOutputBoundary =
                new DeleteFoodItemPresenter(deleteFoodItemViewModel, mainMenuViewModel, viewManagerModel);

        DeleteFoodItemInputBoundary deleteFoodItemInteractor =
                new DeleteFoodItemInteractor(deleteFoodItemDataAccessInterface, deleteFoodItemOutputBoundary);

        return new DeleteFoodItemController(deleteFoodItemInteractor);
    }
}
