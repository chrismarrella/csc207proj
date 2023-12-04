package use_case.update_restrictions;

import entities.DietaryPreferences;
import entities.User;

/**
 * The UpdateRestrictionsDataAccessInterface interface allows the UpdateRestrictionsInteractor to retrieve the user's
 * dietary preferences and save the user's dietary preferences.
 */
public interface UpdateRestrictionsDataAccessInterface {
    DietaryPreferences retrievePreferences();
    User get(int usernum);
    void save(User user);
}
