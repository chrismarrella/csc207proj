package use_case.update_restrictions;

import entities.DietaryPreferences;
import entities.User;
import entities.UserDietaryPreferences;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UpdateRestrictionsInteractor implements UpdateRestrictionsInputBoundary {
    final UpdateRestrictionsDataAccessInterface urDataAccessInterface;
    final UpdateRestrictionsOutputBoundary urOutputBoundary;
    final UserDietaryPreferences user;

    public UpdateRestrictionsInteractor(UpdateRestrictionsDataAccessInterface urDataAccessInterface,
                                        UpdateRestrictionsOutputBoundary urOutputBoundary,
                                        UserDietaryPreferences user) {
        this.urDataAccessInterface = urDataAccessInterface;
        this.urOutputBoundary = urOutputBoundary;
        this.user = user;
    }

    @Override
    public void execute(UpdateRestrictionsInputData updateRestrictionsInputData) {
        String restriction = updateRestrictionsInputData.getRestriction();
        Float value = updateRestrictionsInputData.getValue();
        Set<String> RestrictedRestrictions = new HashSet<>(Arrays.asList(
                "ketogenic", "vegan", "vegetarian", "maxprotein", "minprotein",
                "maxcarbs", "mincarbs", "maxfat", "minfat", "maxcals", "mincals"));

        if (urDataAccessInterface.restrictionExist(restriction)) {
            // Check if the restriction is one of the restricted restrictions
            if (RestrictedRestrictions.contains(restriction.toLowerCase())) {
                // Check if the value is 1.0 or 0.0
                if (value.equals(1.0f) || value.equals(0.0f)) {
                    // Remove the existing restriction and add the new one
                    user.removeRestriction(restriction, user.getRestriction(restriction));
                    user.addRestriction(restriction, value);
                    urOutputBoundary.prepareUpdatedView("Successfully Updated restriction: " + restriction);
                } else if (value.equals(0.25f) && restriction.equals("main menu")) {
                    urOutputBoundary.prepareGoBackView(restriction);

                } else {
                    urOutputBoundary.prepareFailView("Invalid value for restriction: " + value);
                }
            } else {
                // Add the new restriction
                user.addRestriction(restriction, value);
                urOutputBoundary.prepareUpdatedView("Successfully Updated restriction: " + restriction);
            }
        } else {
            // Add the new restriction
            user.addRestriction(restriction, value);
            urOutputBoundary.prepareAddedView("Successfully Added Restriction: " + restriction);
        }
    }
}
