package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.update_restrictions.UpdateRestrictionsController;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.update_restrictions.UpdateRestrictionsPresenter;
import view.UpdateRestrictionsView;
import interface_adapter.update_restrictions.UpdateRestrictionsViewModel;
import use_case.update_restrictions.UpdateRestrictionsOutputBoundary;
import use_case.update_restrictions.UpdateRestrictionsInputBoundary;
import use_case.update_restrictions.UpdateRestrictionsInteractor;
import view.UpdateRestrictionsView;


import javax.swing.*;
import java.io.IOException;

public class UpdateRestrictionsUseCaseFactory {

    /** Prevent instantiation. */
    private UpdateRestrictionsUseCaseFactory() {}

    public static UpdateRestrictionsView create(
            ViewManagerModel viewManagerModel,
            UpdateRestrictionsViewModel updateRestrictionsViewModel,
            MainMenuViewModel mainMenuViewModel) {

        try {
            UpdateRestrictionsController updateRestrictionsController = createUpdateRestrictionsUseCase(viewManagerModel, updateRestrictionsViewModel);
            return new UpdateRestrictionsView(updateRestrictionsController, updateRestrictionsViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static UpdateRestrictionsController createUpdateRestrictionsUseCase(
            ViewManagerModel viewManagerModel,
            UpdateRestrictionsViewModel updateRestrictionsViewModel) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        UpdateRestrictionsOutputBoundary updateRestrictionsOutputBoundary = new UpdateRestrictionsPresenter(viewManagerModel,
                updateRestrictionsViewModel);

        UpdateRestrictionsInputBoundary updateRestrictionsInteractor = new UpdateRestrictionsInteractor(updateRestrictionsOutputBoundary);

        return new UpdateRestrictionsController(updateRestrictionsInteractor);
    }
}
