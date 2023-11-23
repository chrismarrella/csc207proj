package use_case.update_restrictions;

import entities.User;
import entities.UserDietaryPreferences;
public interface UpdateRestrictionsDataAccessInterface {

    boolean restrictionExist(String identifier);

    void save(User user);
}
