package use_case.removeExpired;

public interface RemoveExpiredOutputBoundary {

    void prepareSuccessView(RemoveExpiredOutputData removeExpiredOutputData);

    void prepareFailView();

}
