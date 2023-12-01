package use_case.update_restrictions;

import entities.DietaryPreferences;
import entities.User;

public interface UpdateRestrictionsDataAccessInterface {
    DietaryPreferences retrievePreferences();
    User get(int usernum);
    void save(User user);
}
