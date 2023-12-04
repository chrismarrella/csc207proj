package app;

import data_access.FileUserDataAccessObject;
import entities.User;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.main_menu.MainMenuPresenter;
import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.main_menu.MainMenuDataAccessInterface;
import interface_adapter.removeExpired.RemoveExpiredController;
import interface_adapter.removeExpired.RemoveExpiredPresenter;
import interface_adapter.removeExpired.RemoveExpiredViewModel;
import use_case.removeExpired.RemoveExpiredDataAccessInterface;
import use_case.removeExpired.RemoveExpiredInputBoundary;
import use_case.removeExpired.RemoveExpiredInteractor;
import use_case.removeExpired.RemoveExpiredOutputBoundary;
import view.MainMenuView;
import use_case.main_menu.MainMenuOutputBoundary;
import use_case.main_menu.MainMenuInputBoundary;
import use_case.main_menu.MainMenuInteractor;


import javax.swing.*;
import java.io.IOException;

public class MainMenuUseCaseFactory {

    /** Prevent instantiation. */
    private MainMenuUseCaseFactory() {}

    /**
     * This method creates the main menu view.
     * @param viewManagerModel The view manager model.
     * @param mainMenuViewModel The view model for the main menu view.
     * @param dataAccessObject The data access object for the main menu view.
     * @param userFactory The user factory for the main menu view.
     * @param removeExpiredViewModel The view model for the remove expired view.
     * @return  The main menu view.
     */
    public static MainMenuView create(
            ViewManagerModel viewManagerModel,
            MainMenuViewModel mainMenuViewModel,
            FileUserDataAccessObject dataAccessObject,
            UserFactory userFactory,
            RemoveExpiredViewModel removeExpiredViewModel) {
        try {
            MainMenuController mainMenuController = createMainMenuUseCase(viewManagerModel, mainMenuViewModel, dataAccessObject, userFactory);
            RemoveExpiredController removeExpiredController = createRemoveExpiredUseCase(viewManagerModel,
                    removeExpiredViewModel, dataAccessObject);

            return new MainMenuView(mainMenuController, mainMenuViewModel, removeExpiredController, removeExpiredViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     * This method creates the main menu controller.
     * @param viewManagerModel The view manager model.
     * @param mainMenuViewModel The view model for the main menu view.
     * @param dataAccessInterface The data access object for the main menu view.
     * @param userFactory The user factory for the main menu view.
     * @throws IOException If the user data csv file cannot be opened.
     * @return  The main menu controller.
     */
    public static MainMenuController createMainMenuUseCase(
            ViewManagerModel viewManagerModel,
            MainMenuViewModel mainMenuViewModel,
            MainMenuDataAccessInterface dataAccessInterface,
            UserFactory userFactory) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        MainMenuOutputBoundary mainMenuOutputBoundary = new MainMenuPresenter(viewManagerModel,
                mainMenuViewModel);

        MainMenuInputBoundary mainMenuInteractor =
                new MainMenuInteractor(mainMenuOutputBoundary, dataAccessInterface, userFactory);

        return new MainMenuController(mainMenuInteractor);
    }

    /**
     * This method creates the remove expired controller.
     * @param viewManagerModel The view manager model.
     * @param removeExpiredViewModel The view model for the remove expired view.
     * @param removeExpiredDataAccessInterface The data access object for removing expired food items.
     * @throws IOException If the user data csv file cannot be opened.
     * @return  The remove expired controller.
     */
    private static RemoveExpiredController createRemoveExpiredUseCase(
            ViewManagerModel viewManagerModel, RemoveExpiredViewModel removeExpiredViewModel,
            RemoveExpiredDataAccessInterface removeExpiredDataAccessInterface) throws IOException {

        RemoveExpiredOutputBoundary removeExpiredOutputBoundary =
                new RemoveExpiredPresenter(removeExpiredViewModel, viewManagerModel);
        RemoveExpiredInputBoundary removeExpiredInteractor =
                new RemoveExpiredInteractor(removeExpiredDataAccessInterface, removeExpiredOutputBoundary);

        return new RemoveExpiredController(removeExpiredInteractor);
    }
}