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
        DeleteFoodItemOutputBoundary deleteFoodItemOutputBoundary =
                new DeleteFoodItemPresenter(deleteFoodItemViewModel, mainMenuViewModel, viewManagerModel);

        DeleteFoodItemInputBoundary deleteFoodItemInteractor =
                new DeleteFoodItemInteractor(deleteFoodItemDataAccessInterface, deleteFoodItemOutputBoundary);

        return new DeleteFoodItemController(deleteFoodItemInteractor);
    }
}
