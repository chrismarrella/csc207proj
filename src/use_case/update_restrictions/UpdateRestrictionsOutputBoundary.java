package use_case.update_restrictions;

public interface UpdateRestrictionsOutputBoundary {
    void prepareUpdatedView(String success);

    void prepareFailView(String error);
}
