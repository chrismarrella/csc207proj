package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.main_menu.MainMenuPresenter;
import interface_adapter.get_recipe.GetRecipeViewModel;
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
            GetRecipeViewModel getRecipeViewModel) {

        try {
            MainMenuController mainMenuController = createMainMenuUseCase(viewManagerModel, mainMenuViewModel);
            return new MainMenuView(mainMenuController, mainMenuViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static MainMenuController createMainMenuUseCase(
            ViewManagerModel viewManagerModel,
            MainMenuViewModel mainMenuViewModel) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        MainMenuOutputBoundary mainMenuOutputBoundary = new MainMenuPresenter(viewManagerModel,
                mainMenuViewModel);

        MainMenuInputBoundary mainMenuInteractor = new MainMenuInteractor(mainMenuOutputBoundary);

        return new MainMenuController(mainMenuInteractor);
    }
}