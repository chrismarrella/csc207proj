package use_case.update_restrictions;

import entities.DietaryPreferences;
public interface UpdateRestrictionsDataAccessInterface {
    boolean restrictionexist(String identifier);

    void saverestriction(DietaryPreferences Restriction);
}
