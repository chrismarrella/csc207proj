package app;
import entities.UserDietaryPreferences;
import entities.UserFactory;

import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.update_restrictions.*;

import use_case.update_restrictions.*;
import view.UpdateRestrictionsView;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class UpdateRestrictionsUseCaseFactory {
    private UpdateRestrictionsUseCaseFactory() {}


    /**
     * Creates an UpdateRestrictionsView instance.
     * @param viewManagerModel The ViewManagerModel instance.
     * @param updateRestrictionsViewModel The UpdateRestrictionsViewModel instance.
     * @param updateRestrictionsDataAccessInterface The UpdateRestrictionsDataAccessInterface instance.
     * @param mainMenuController The MainMenuController instance.
     * @param mainMenuViewModel The MainMenuViewModel instance.
     */
    public static UpdateRestrictionsView create(
            ViewManagerModel viewManagerModel,
            UpdateRestrictionsViewModel updateRestrictionsViewModel, UpdateRestrictionsDataAccessInterface updateRestrictionsDataAccessInterface, MainMenuController mainMenuController, MainMenuViewModel mainMenuViewModel) {

        try {
            UpdateRestrictionsController updateRestrictionsController = createUpdateRestrictionsUseCase(viewManagerModel, updateRestrictionsViewModel, updateRestrictionsDataAccessInterface);
            return new UpdateRestrictionsView(updateRestrictionsController, updateRestrictionsViewModel, mainMenuController, mainMenuViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static UpdateRestrictionsController createUpdateRestrictionsUseCase(
            ViewManagerModel viewManagerModel,
            UpdateRestrictionsViewModel updateRestrictionsViewModel, UpdateRestrictionsDataAccessInterface updateRestrictionsDataAccessInterface) throws IOException {

        UpdateRestrictionsOutputBoundary updateRestrictionsOutputBoundary = new UpdateRestrictionsPresenter(
                updateRestrictionsViewModel, viewManagerModel);


        UserDietaryPreferences usermap = new UserDietaryPreferences(new HashMap<>());


        UpdateRestrictionsInteractor updateRestrictionsInteractor = new UpdateRestrictionsInteractor(updateRestrictionsDataAccessInterface, updateRestrictionsOutputBoundary, usermap);

        return new UpdateRestrictionsController(updateRestrictionsInteractor);
    }
}
