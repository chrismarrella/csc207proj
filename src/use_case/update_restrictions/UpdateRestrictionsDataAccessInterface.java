package use_case.update_restrictions;

import entities.DietaryPreferences;
import entities.User;
public interface UpdateRestrictionsDataAccessInterface {
    boolean restrictionexist(String identifier);

    void saverestriction(User user);
}
