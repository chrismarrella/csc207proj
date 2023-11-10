package entities;

import java.util.Map;

public interface DietaryPreferences {
    Map<String, Boolean> getDietaryRestrictions();

    void setDietaryRestrictions(Map<String, Boolean> dietaryRestrictions);

}
