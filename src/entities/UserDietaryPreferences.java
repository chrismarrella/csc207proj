package entities;

import java.util.Map;
import java.util.Set;

public class UserDietaryPreferences implements DietaryPreferences{
    private Map<String, Boolean> dietaryRestrictions;

    public UserDietaryPreferences(Map<String, Boolean> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public DietaryPreferences getDietaryRestrictions() {
        return this;
    }

    public void setDietaryRestrictions(Map<String, Boolean> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public void addRestriction(String restriction, Boolean res) {
        this.dietaryRestrictions.put(restriction, res);
    }

    public Boolean removeRestriction(String restriction, Boolean res) {
        return this.dietaryRestrictions.remove(restriction, res);
    }

    public Boolean getRestriction(String key) {
        return this.dietaryRestrictions.get(key);
    }

    public Set<String> getAllKeys() {
        return this.dietaryRestrictions.keySet();
    }
}
