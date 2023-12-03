package interface_adapter.update_restrictions;

import interface_adapter.ViewManagerModel;
import use_case.update_restrictions.UpdateRestrictionsOutputBoundary;

import javax.swing.*;

/**
 * This class is the presenter for the update restrictions use case.
 * It is responsible for preparing the view model for the view to display.
 */
public class UpdateRestrictionsPresenter implements UpdateRestrictionsOutputBoundary {
    private final UpdateRestrictionsViewModel updateRestrictionsViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Initializes the Constructor for UpdateRestrictionsPresenter.
     * @param updateRestrictionsViewModel The UpdateRestrictionsViewModel instance.
     * @param viewManagerModel The ViewManagerModel instance.
     */
    public UpdateRestrictionsPresenter(UpdateRestrictionsViewModel updateRestrictionsViewModel,
                                       ViewManagerModel viewManagerModel) {
        this.updateRestrictionsViewModel = updateRestrictionsViewModel;
        this.viewManagerModel = viewManagerModel;

    }

    /**
     * Prepares the pop up for the view to display when a restriction is successfully applied.
     * @param success The success message to be displayed.
     */
    @Override
    public void prepareUpdatedView(String success) {
        UpdateRestrictionsState updateRestrictionsState = updateRestrictionsViewModel.getCurrState();
        updateRestrictionsState.setError(null);
        updateRestrictionsViewModel.firePropertyChange();
    }


    /**
     * Prepares the popup for the view to display when a restriction is unsuccessfully applied.
     * @param error The error message to be displayed.
     */
    @Override
    public void prepareFailView(String error) {
        UpdateRestrictionsState updateRestrictionsState = updateRestrictionsViewModel.getCurrState();
        updateRestrictionsState.setError(error);
        updateRestrictionsViewModel.firePropertyChange();
    }

    /**
     * Prepares the popup for the view to display when a checkbox restriction is successfully applied.
     * @param success The success message to be displayed.
     */

    @Override
    public void prepareCheckedView(String success) {
        UpdateRestrictionsState updateRestrictionsState = updateRestrictionsViewModel.getCurrState();
        updateRestrictionsState.setError(null);
    }
}
