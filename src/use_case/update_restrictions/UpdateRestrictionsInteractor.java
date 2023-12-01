package use_case.update_restrictions;

import entities.DietaryPreferences;
import entities.User;
import entities.UserDietaryPreferences;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;


public class UpdateRestrictionsInteractor implements UpdateRestrictionsInputBoundary {
    final UpdateRestrictionsDataAccessInterface urDataAccessInterface;
    final UpdateRestrictionsOutputBoundary urOutputBoundary;
    final UserDietaryPreferences usermap;

    public UpdateRestrictionsInteractor(UpdateRestrictionsDataAccessInterface urDataAccessInterface,
                                        UpdateRestrictionsOutputBoundary urOutputBoundary,
                                        UserDietaryPreferences usermap) {
        this.urDataAccessInterface = urDataAccessInterface;
        this.urOutputBoundary = urOutputBoundary;
        this.usermap = usermap;
    }
    @Override
    public void execute(UpdateRestrictionsInputData updateRestrictionsInputData) {
        String restriction = updateRestrictionsInputData.getRestriction();
        Float value = updateRestrictionsInputData.getValue();
        Set<String> restrictedRestrictions = new HashSet<>(Arrays.asList(
                "ketogenic", "vegan", "vegetarian", "maxprotein", "minprotein",
                "maxcarbs", "mincarbs", "maxfat", "minfat", "maxcals", "mincals"));
        User user =  urDataAccessInterface.get(0);
        DietaryPreferences dietaryPreferences = urDataAccessInterface.retrievePreferences();
        Set<String> dietTypes = new HashSet<>(Arrays.asList("ketogenic", "vegan", "vegetarian"));

        if (restrictedRestrictions.contains(restriction.toLowerCase())) {
            System.out.println("First if statement passed: " + restriction + value);

            if (dietTypes.contains(restriction.toLowerCase())) {
                // Remove the existing restriction and add the new one
                dietaryPreferences.removeRestriction(restriction, dietaryPreferences.getRestriction(restriction));
                dietaryPreferences.addRestriction(restriction, value);
                urOutputBoundary.prepareUpdatedView("Successfully Updated restriction: " + restriction);
                System.out.println("Second if statement passed: " + dietaryPreferences.getAllKeys());
                urDataAccessInterface.save(user);
            } else {
                // Update or add the restriction
                dietaryPreferences.removeRestriction(restriction, dietaryPreferences.getRestriction(restriction));
                dietaryPreferences.addRestriction(restriction, value);
                urOutputBoundary.prepareUpdatedView("Successfully Added Restriction: " + restriction);
                System.out.println("Second if statement passed: " + dietaryPreferences.getAllKeys());
                urDataAccessInterface.save(user);
            }
        } else {
            // Add the new restriction
            dietaryPreferences.addRestriction(restriction, value);
            urOutputBoundary.prepareUpdatedView("Successfully Updated restriction: " + restriction);
            urDataAccessInterface.save(user);
        }
    }
}
