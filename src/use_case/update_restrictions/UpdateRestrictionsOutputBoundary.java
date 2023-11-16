package use_case.update_restrictions;

public interface UpdateRestrictionsOutputBoundary {
    void prepareSuccessView(UpdateRestrictionsOutputData response);

    void prepareFailView(String error);
}
