package use_case.update_restrictions;

public interface UpdateRestrictionsOutputBoundary {
    void prepareGoBackView(UpdateRestrictionsOutputData response);
    void prepareAddedView(String success);
    void prepareUpdatedView(String success);

    void prepareFailView(String error);
}
