package interface_adapter.update_restrictions;

import use_case.update_restrictions.UpdateRestrictionsInputBoundary;
import use_case.update_restrictions.UpdateRestrictionsInputData;

public class UpdateRestrictionsController {
    final UpdateRestrictionsInputBoundary updateRestrictionsInteractor;

    public UpdateRestrictionsController(UpdateRestrictionsInputBoundary updateRestrictionsInteractor){
        this.updateRestrictionsInteractor = updateRestrictionsInteractor;
    }

    public void execute(Float maxprotein, Float minprotein, Float maxcarbs ,Float mincarbs,
                        Float maxfat, Float minfat, Float maxcals, Float mincals, String fooditem, Float vegan,
                        Float vegetarian, Float keto){
        UpdateRestrictionsInputData updateRestrictionsInputData = new UpdateRestrictionsInputData(
                maxprotein, minprotein, maxcarbs, mincarbs, maxfat, minfat, maxcals, mincals,
                fooditem, vegan, vegetarian, keto);

        updateRestrictionsInteractor.execute(updateRestrictionsInputData);
    }

}
