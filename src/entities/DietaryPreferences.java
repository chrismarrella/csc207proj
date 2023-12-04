package entities;

import java.util.Map;
import java.util.Set;

/**
 * This interface represents the dietary preferences of a user.
 * float value of 1 is true, 0 is false, any other value for macros is considered as quantity per serving
 */
public interface DietaryPreferences {

    DietaryPreferences getDietaryRestrictions();

    void setDietaryRestrictions(Map<String, Float> dietaryRestrictions);

    void addRestriction(String restriction, Float res);

    Boolean removeRestriction(String restriction, Float res);

    Float getRestriction(String key);

    Set<String> getAllKeys();
}
