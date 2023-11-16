package use_case.update_restrictions;

import entities.DietaryPreferences;

public class UpdateRestrictionsInteractor implements UpdateRestrictionsInputBoundary{
    final UpdateRestrictionsDataAccessInterface updateRestrictionsDataAccessInterface;
    final UpdateRestrictionsOutputBoundary updateRestrictionsOutputBoundary;

    public UpdateRestrictionsInteractor(UpdateRestrictionsDataAccessInterface updateRestrictionsDataAccessInterface,
                                        UpdateRestrictionsOutputBoundary updateRestrictionsOutputBoundary) {
        this.updateRestrictionsDataAccessInterface = updateRestrictionsDataAccessInterface;
        this.updateRestrictionsOutputBoundary = updateRestrictionsOutputBoundary;
    }

    @Override
    public void execute(UpdateRestrictionsInputData updateRestrictionsInputData){
    }
}
