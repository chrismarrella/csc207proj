package use_case.update_restrictions;

import entities.DietaryPreferences;
public interface UpdateRestrictionsDataAccessInterface {

    boolean foodexists(String identifier);

    void savepreference(DietaryPreferences dietaryPreference);

    DietaryPreferences getpreference(String dietaryPreference);
}
