package interface_adapter.update_restrictions;

import use_case.update_restrictions.UpdateRestrictionsInputBoundary;
import use_case.update_restrictions.UpdateRestrictionsInputData;

public class UpdateRestrictionsController {
    final UpdateRestrictionsInputBoundary updateRestrictionsInteractor;

    public UpdateRestrictionsController(UpdateRestrictionsInputBoundary updateRestrictionsInteractor){
        this.updateRestrictionsInteractor = updateRestrictionsInteractor;
    }

    public void execute(String restriction, Float value){
        UpdateRestrictionsInputData updateRestrictionsInputData = new UpdateRestrictionsInputData(restriction, value);

        updateRestrictionsInteractor.execute(updateRestrictionsInputData);
    }

}
