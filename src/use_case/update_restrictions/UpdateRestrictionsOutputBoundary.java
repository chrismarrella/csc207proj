package use_case.update_restrictions;

/**
 * The UpdateRestrictionsOutputBoundary interface allows the UpdateRestrictionsPresenter to prepare the success view or
 * the fail view.
 */
public interface UpdateRestrictionsOutputBoundary {
    void prepareUpdatedView(String success);

    void prepareFailView(String error);
}
