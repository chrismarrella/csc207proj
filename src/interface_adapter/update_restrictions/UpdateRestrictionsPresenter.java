package interface_adapter.update_restrictions;

import interface_adapter.ViewManagerModel;
import use_case.update_restrictions.UpdateRestrictionsOutputBoundary;

import javax.swing.*;

public class UpdateRestrictionsPresenter implements UpdateRestrictionsOutputBoundary {
    private final UpdateRestrictionsViewModel updateRestrictionsViewModel;
    private final ViewManagerModel viewManagerModel;

    public UpdateRestrictionsPresenter(UpdateRestrictionsViewModel updateRestrictionsViewModel,
                                       ViewManagerModel viewManagerModel) {
        this.updateRestrictionsViewModel = updateRestrictionsViewModel;
        this.viewManagerModel = viewManagerModel;

    }
    @Override
    public void prepareUpdatedView(String success) {
        UpdateRestrictionsState updateRestrictionsState = updateRestrictionsViewModel.getCurrState();
        updateRestrictionsState.setSuccess(success);
        JOptionPane.showMessageDialog(null, "Successfully Updated Restriction", "Success", JOptionPane.INFORMATION_MESSAGE);
        updateRestrictionsViewModel.firePropertyChange();
    }


    @Override
    public void prepareFailView(String error) {
        UpdateRestrictionsState updateRestrictionsState = updateRestrictionsViewModel.getCurrState();
        updateRestrictionsState.setError(error);
        updateRestrictionsViewModel.firePropertyChange();
    }
}
