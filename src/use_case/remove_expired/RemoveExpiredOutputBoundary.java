package use_case.remove_expired;

public interface RemoveExpiredOutputBoundary {

    /**
     * Prepare the success view with the given output data when there exists some expired food items in the user's inventory.
     * @param removeExpiredOutputData the output data to prepare the view with.
     */
    void prepareSuccessView(RemoveExpiredOutputData removeExpiredOutputData);

    /**
     * Prepare the fail view when there are no expired food items in the user's inventory.
     */
    void prepareFailView();

}
