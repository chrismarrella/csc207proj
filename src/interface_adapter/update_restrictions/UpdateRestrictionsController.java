package interface_adapter.update_restrictions;

import use_case.update_restrictions.UpdateRestrictionsInputBoundary;
import use_case.update_restrictions.UpdateRestrictionsInputData;

public class UpdateRestrictionsController {
    final UpdateRestrictionsInputBoundary updateRestrictionsInteractor;

    public UpdateRestrictionsController(UpdateRestrictionsInputBoundary updateRestrictionsInteractor){
        this.updateRestrictionsInteractor = updateRestrictionsInteractor;
    }

    public void execute(Float protein, Float carbs, Float fat, Float cals, String fooditem){
        UpdateRestrictionsInputData updateRestrictionsInputData = new UpdateRestrictionsInputData(
                protein, carbs, fat, cals, fooditem);

        updateRestrictionsInteractor.execute(updateRestrictionsInputData);
    }

}
