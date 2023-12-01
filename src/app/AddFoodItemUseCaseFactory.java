package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_fooditem.AddFoodItemController;
import interface_adapter.add_fooditem.AddFoodItemPresenter;
import interface_adapter.add_fooditem.AddFoodItemViewModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuViewModel;
import use_case.add_fooditem.AddFoodItemDataAccessInterface;
import use_case.add_fooditem.AddFoodItemInputBoundary;
import use_case.add_fooditem.AddFoodItemInteractor;
import use_case.add_fooditem.AddFoodItemOutputBoundary;
import view.AddFoodItemView;

import javax.swing.*;
import java.io.IOException;

public class AddFoodItemUseCaseFactory {
    private AddFoodItemUseCaseFactory() {
    }

    public static AddFoodItemView create(
            ViewManagerModel viewManagerModel,
            AddFoodItemViewModel addFoodItemViewModel,
            MainMenuViewModel mainMenuViewModel,
            MainMenuController mainMenuController,
            AddFoodItemDataAccessInterface userDataAccessObject) {
        try {
            AddFoodItemController addFoodItemController = createAddFoodItemUseCase(viewManagerModel, addFoodItemViewModel, userDataAccessObject);
            return new AddFoodItemView(addFoodItemController, addFoodItemViewModel, mainMenuController, mainMenuViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static AddFoodItemController createAddFoodItemUseCase(
            ViewManagerModel viewManagerModel,
            AddFoodItemViewModel addFoodItemViewModel,
            AddFoodItemDataAccessInterface userDataAccessObject) throws IOException {
        AddFoodItemOutputBoundary addFoodItemOutputBoundary = new AddFoodItemPresenter(addFoodItemViewModel);
        AddFoodItemInputBoundary addFoodItemInteractor = new AddFoodItemInteractor(addFoodItemOutputBoundary, userDataAccessObject);
        return new AddFoodItemController(addFoodItemInteractor);
    }
}
