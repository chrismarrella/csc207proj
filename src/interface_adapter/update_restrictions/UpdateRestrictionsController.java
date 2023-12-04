package interface_adapter.update_restrictions;

import use_case.update_restrictions.UpdateRestrictionsInputBoundary;
import use_case.update_restrictions.UpdateRestrictionsInputData;

/**
 * This class is the controller for the update restrictions use case.
 * It is responsible for receiving the input from the view and passing it to the interactor.
 */
public class UpdateRestrictionsController {
    final UpdateRestrictionsInputBoundary updateRestrictionsInteractor;

    /**
     * Initializes the Constructor for UpdateRestrictionsController.
     * @param updateRestrictionsInteractor The UpdateRestrictionsInputBoundary instance.
     */
    public UpdateRestrictionsController(UpdateRestrictionsInputBoundary updateRestrictionsInteractor){
        this.updateRestrictionsInteractor = updateRestrictionsInteractor;
    }

    /**
     * Executes the update restrictions use case.
     * @param restriction The restriction name to be updated.
     * @param value The value to be updated, either some float between the max and min values for the restriction, or
     *              1.0 (true) or 0.0 (false) for the boolean restrictions.
     */
    public void execute(String restriction, Float value){
        UpdateRestrictionsInputData updateRestrictionsInputData = new UpdateRestrictionsInputData(restriction, value);

        updateRestrictionsInteractor.execute(updateRestrictionsInputData);
    }

}
