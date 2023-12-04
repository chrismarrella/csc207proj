package use_case.remove_expired;

public interface RemoveExpiredInputBoundary {

    /**
     * This method executes the remove expired use case.
     * @param removeExpiredInputData The input data for the remove expired use case.
     */
    void execute(RemoveExpiredInputData removeExpiredInputData);
}
