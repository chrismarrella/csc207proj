package interface_adapter.remove_expired;

import interface_adapter.ViewManagerModel;
import use_case.remove_expired.RemoveExpiredOutputBoundary;
import use_case.remove_expired.RemoveExpiredOutputData;

public class RemoveExpiredPresenter implements RemoveExpiredOutputBoundary {

    private final RemoveExpiredViewModel removeExpiredViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * This method creates the delete food item presenter.
     * @param removeExpiredViewModel The view model for the remove expired food item view.
     * @param viewManagerModel The view manager model.
     */
    public RemoveExpiredPresenter(RemoveExpiredViewModel removeExpiredViewModel,
                                  ViewManagerModel viewManagerModel) {
        this.removeExpiredViewModel = removeExpiredViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * This method prepares the success view for the remove expired food item use case when there are expired food items.
     * @param removeExpiredOutputData The output data from the remove expired food item use case.
     */
    @Override
    public void prepareSuccessView(RemoveExpiredOutputData removeExpiredOutputData) {
        RemoveExpiredState currState = removeExpiredViewModel.getState();
        currState.setExpiredFoodItems(removeExpiredOutputData.getExpiredFoodItems());
        removeExpiredViewModel.setState(currState);
    }

    /**
     * This method prepares the fail view for the remove expired food item use case when there is no expired food item.
     */
    @Override
    public void prepareFailView() {
        RemoveExpiredState currState = removeExpiredViewModel.getState();
        currState.setNoExpired("No expired food item today!");
        removeExpiredViewModel.setState(currState);
    }
}
