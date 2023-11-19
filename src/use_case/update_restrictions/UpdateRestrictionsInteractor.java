package use_case.update_restrictions;

import entities.UserDietaryPreferences;

public class UpdateRestrictionsInteractor implements UpdateRestrictionsInputBoundary{
    final UpdateRestrictionsDataAccessInterface updateRestrictionsDataAccessInterface;
    final UpdateRestrictionsOutputBoundary updateRestrictionsOutputBoundary;
    final UserDietaryPreferences userDietaryPreferences;

    public UpdateRestrictionsInteractor(UpdateRestrictionsDataAccessInterface updateRestrictionsDataAccessInterface,
                                        UpdateRestrictionsOutputBoundary updateRestrictionsOutputBoundary,
                                        UserDietaryPreferences userDietaryPreferences) {
        this.updateRestrictionsDataAccessInterface = updateRestrictionsDataAccessInterface;
        this.updateRestrictionsOutputBoundary = updateRestrictionsOutputBoundary;
        this.userDietaryPreferences = userDietaryPreferences;
    }

    @Override
    public void execute(UpdateRestrictionsInputData updateRestrictionsInputData){

    }
}
