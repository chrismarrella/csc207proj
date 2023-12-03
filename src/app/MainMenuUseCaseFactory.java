package app;

import data_access.FileUserDataAccessObject;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.main_menu.MainMenuPresenter;
import use_case.main_menu.MainMenuDataAccessInterface;
import interface_adapter.remove_expired.RemoveExpiredController;
import interface_adapter.remove_expired.RemoveExpiredPresenter;
import interface_adapter.remove_expired.RemoveExpiredViewModel;
import use_case.remove_expired.RemoveExpiredDataAccessInterface;
import use_case.remove_expired.RemoveExpiredInputBoundary;
import use_case.remove_expired.RemoveExpiredInteractor;
import use_case.remove_expired.RemoveExpiredOutputBoundary;
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
     * Creates the main menu view.
     * @param viewManagerModel ViewManagerModel is the model that keeps track of which view is currently showing.
     * @param mainMenuViewModel MainMenuViewModel is the model that contains the data for the main menu view.
     * @param dataAccessObject FileUserDataAccessObject is the data access object that contains the data for the user.
     * @param userFactory UserFactory is the factory that creates the user.
     * @param removeExpiredViewModel RemoveExpiredViewModel is the model that contains the data for the remove expired view.
     * @return MainMenuView is the view that is created.
     */
    public static MainMenuView create(
            ViewManagerModel viewManagerModel,
            MainMenuViewModel mainMenuViewModel,
            FileUserDataAccessObject dataAccessObject,
            UserFactory userFactory,
            RemoveExpiredViewModel removeExpiredViewModel) {
        try {
            MainMenuController mainMenuController =
                    createMainMenuUseCase(viewManagerModel, mainMenuViewModel, dataAccessObject, userFactory);
            RemoveExpiredController removeExpiredController = createRemoveExpiredUseCase(viewManagerModel,
                    removeExpiredViewModel, dataAccessObject);

            return new MainMenuView(mainMenuController, mainMenuViewModel, removeExpiredController, removeExpiredViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     * Creates the main menu use case.
     * @param viewManagerModel ViewManagerModel is the model that keeps track of which view is currently showing.
     * @param mainMenuViewModel MainMenuViewModel is the model that contains the data for the main menu view.
     * @param dataAccessInterface MainMenuDataAccessInterface is the data access object that contains the data for the user.
     * @param userFactory UserFactory is the factory that creates the user.
     * @return MainMenuController is the controller that is created.
     * @throws IOException FileUserDataAccessObject may involve file operations that can result in an IOException.
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

    /** Creates the remove expired use case.
     * @param viewManagerModel ViewManagerModel is the model that keeps track of which view is currently showing.
     * @param removeExpiredViewModel RemoveExpiredViewModel is the model that contains the data for the remove expired view.
     * @param removeExpiredDataAccessInterface RemoveExpiredDataAccessInterface is the data access object that contains the data for the remove expired view.
     * @return RemoveExpiredController is the controller that is created.
     * @throws IOException FileUserDataAccessObject may involve file operations that can result in an IOException.
     */
    private static RemoveExpiredController createRemoveExpiredUseCase(
            ViewManagerModel viewManagerModel,
            RemoveExpiredViewModel removeExpiredViewModel,
            RemoveExpiredDataAccessInterface removeExpiredDataAccessInterface) throws IOException {
        RemoveExpiredOutputBoundary removeExpiredOutputBoundary =
                new RemoveExpiredPresenter(removeExpiredViewModel, viewManagerModel);
        RemoveExpiredInputBoundary removeExpiredInteractor =
                new RemoveExpiredInteractor(removeExpiredDataAccessInterface, removeExpiredOutputBoundary);

        return new RemoveExpiredController(removeExpiredInteractor);
    }
}