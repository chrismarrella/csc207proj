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
    public void prepareSuccessView(RemoveExpiredOutputData removeExpiredOutputData) {
        RemoveExpiredState currState = removeExpiredViewModel.getState();
        currState.setExpiredFoodItems(removeExpiredOutputData.getExpiredFoodItems());
        removeExpiredViewModel.setState(currState);
        removeExpiredViewModel.firePropertyChange();
    }

    @Override
    public void prepareFailView() {
        RemoveExpiredState currState = removeExpiredViewModel.getState();
        currState.setNoExpired("No expired food item today!");
        removeExpiredViewModel.setState(currState);
        removeExpiredViewModel.firePropertyChange();
    }
}
