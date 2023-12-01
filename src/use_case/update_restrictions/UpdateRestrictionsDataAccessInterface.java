package use_case.update_restrictions;

import entities.DietaryPreferences;
import entities.User;
import entities.UserDietaryPreferences;

import java.util.List;

public interface UpdateRestrictionsDataAccessInterface {
    DietaryPreferences retrievePreferences();
    User get(int usernum);
    void save(User user);
}
