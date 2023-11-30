package interface_adapter.removeExpired;

import interface_adapter.ViewManagerModel;
import use_case.removeExpired.RemoveExpiredOutputBoundary;
import use_case.removeExpired.RemoveExpiredOutputData;

public class RemoveExpiredPresenter implements RemoveExpiredOutputBoundary {

    private final RemoveExpiredViewModel removeExpiredViewModel;
    private ViewManagerModel viewManagerModel;

    public RemoveExpiredPresenter(RemoveExpiredViewModel removeExpiredViewModel,
                                  ViewManagerModel viewManagerModel) {
        this.removeExpiredViewModel = removeExpiredViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareView(RemoveExpiredOutputData removeExpiredOutputData) {
        removeExpiredViewModel.firePropertyChange();

        viewManagerModel.setActiveView(removeExpiredViewModel.getViewName());
        viewManagerModel.firePropertyChange();
    }

}
