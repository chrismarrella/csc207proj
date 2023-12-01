package use_case.update_restrictions;


public interface UpdateRestrictionsOutputBoundary {
    void prepareGoBackView(String response);
    void prepareUpdatedView(String success);

    void prepareAddedView(String success);

    void prepareFailView(String error);
}
