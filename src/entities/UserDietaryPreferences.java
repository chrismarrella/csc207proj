package entities;

import java.util.Map;
import java.util.Set;

public class UserDietaryPreferences implements DietaryPreferences{
    private Map<String, Float> dietaryRestrictions;

    public UserDietaryPreferences(Map<String, Float> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public DietaryPreferences getDietaryRestrictions() {
        return this;
    }

    public void setDietaryRestrictions(Map<String, Float> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public void addRestriction(String restriction, Float res) {
        this.dietaryRestrictions.put(restriction, res);
    }

    public Boolean removeRestriction(String restriction, Float res) {
        return this.dietaryRestrictions.remove(restriction, res);
    }

    public Float getRestriction(String key) {
        return this.dietaryRestrictions.get(key);
    }

    public Set<String> getAllKeys() {
        return this.dietaryRestrictions.keySet();
    }
}
