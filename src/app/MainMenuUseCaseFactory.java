package app;

import entities.User;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.main_menu.MainMenuPresenter;
import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.main_menu.MainMenuDataAccessInterface;
import view.MainMenuView;
import use_case.main_menu.MainMenuOutputBoundary;
import use_case.main_menu.MainMenuInputBoundary;
import use_case.main_menu.MainMenuInteractor;


import javax.swing.*;
import java.io.IOException;

public class MainMenuUseCaseFactory {

    /** Prevent instantiation. */
    private MainMenuUseCaseFactory() {}

    public static MainMenuView create(
            ViewManagerModel viewManagerModel,
            MainMenuViewModel mainMenuViewModel,
            GetRecipeViewModel getRecipeViewModel,
            MainMenuDataAccessInterface dataAccessInterface,
            UserFactory userFactory) {
        try {
            MainMenuController mainMenuController = createMainMenuUseCase(viewManagerModel, mainMenuViewModel, dataAccessInterface, userFactory);
            return new MainMenuView(mainMenuController, mainMenuViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }
    public static MainMenuController createMainMenuUseCase(
            ViewManagerModel viewManagerModel,
            MainMenuViewModel mainMenuViewModel,
            MainMenuDataAccessInterface dataAccessInterface,
            UserFactory userFactory) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        MainMenuOutputBoundary mainMenuOutputBoundary = new MainMenuPresenter(viewManagerModel,
                mainMenuViewModel);

        MainMenuInputBoundary mainMenuInteractor = new MainMenuInteractor(mainMenuOutputBoundary, dataAccessInterface, userFactory);

        return new MainMenuController(mainMenuInteractor);
    }
}