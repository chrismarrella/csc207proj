package entities.get_recipe;

import java.util.Map;

public interface DietaryPreferences {
    Map<String, Boolean> getDietaryRestrictions();

    void setDietaryRestrictions(Map<String, Boolean> dietaryRestrictions);

}
