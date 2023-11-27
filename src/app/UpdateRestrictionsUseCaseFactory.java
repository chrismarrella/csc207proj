package app;
import entities.UserDietaryPreferences;
import interface_adapter.ViewManagerModel;
import entities.User;
import interface_adapter.update_restrictions.*;
import use_case.update_restrictions.*;
import view.UpdateRestrictionsView;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class UpdateRestrictionsUseCaseFactory {
    private UpdateRestrictionsUseCaseFactory() {}

    public static UpdateRestrictionsView create(
            ViewManagerModel viewManagerModel,
            UpdateRestrictionsViewModel updateRestrictionsViewModel, UpdateRestrictionsDataAccessInterface updateRestrictionsDataAccessInterface) {

        try {
            UpdateRestrictionsController updateRestrictionsController = createUpdateRestrictionsUseCase(viewManagerModel, updateRestrictionsViewModel, updateRestrictionsDataAccessInterface);
            return new UpdateRestrictionsView(updateRestrictionsController, updateRestrictionsViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static UpdateRestrictionsController createUpdateRestrictionsUseCase(
            ViewManagerModel viewManagerModel,
            UpdateRestrictionsViewModel updateRestrictionsViewModel, UpdateRestrictionsDataAccessInterface updateRestrictionsDataAccessInterface) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        UpdateRestrictionsOutputBoundary updateRestrictionsOutputBoundary = new UpdateRestrictionsPresenter(
                updateRestrictionsViewModel, viewManagerModel);


        //possibly temp
        UserDietaryPreferences user = new UserDietaryPreferences(new HashMap<>());


        UpdateRestrictionsInteractor updateRestrictionsInteractor = new UpdateRestrictionsInteractor(updateRestrictionsDataAccessInterface, updateRestrictionsOutputBoundary, user);

        return new UpdateRestrictionsController(updateRestrictionsInteractor);
    }
}
