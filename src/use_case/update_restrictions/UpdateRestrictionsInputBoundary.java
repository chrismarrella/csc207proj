package use_case.update_restrictions;

/**
 * The UpdateRestrictionsInputBoundary interface allows the UpdateRestrictionsController to execute the update
 * restrictions use case.
 */
public interface UpdateRestrictionsInputBoundary {
    void execute(UpdateRestrictionsInputData updateRestrictionsInputData);
}
