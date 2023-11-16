package entities;

import java.util.Map;
import java.util.Set;

public interface DietaryPreferences {
    DietaryPreferences getDietaryRestrictions();

    void setDietaryRestrictions(Map<String, Boolean> dietaryRestrictions);

    void addRestriction(String restriction, Boolean res);

    Boolean removeRestriction(String restriction, Boolean res);

    Boolean getRestriction(String key);

    Set<String> getAllKeys();
}
