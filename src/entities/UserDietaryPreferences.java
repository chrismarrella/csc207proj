package entities;

import java.util.Map;
import java.util.Set;

/**
 * This class represents the dietary preferences of a user.
 * float value of 1 is true, 0 is false, any other value for macros is considered as quantity per serving
 */
public class UserDietaryPreferences implements DietaryPreferences{
    private Map<String, Float> dietaryRestrictions;

    /**
     * Constructor for UserDietaryPreferences
     * @param dietaryRestrictions the dietary restrictions of the user
     *
     * @return a UserDietaryPreferences object
     */
    public UserDietaryPreferences(Map<String, Float> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    /**
     * Get the dietary restrictions of the user
     * @return the dietary restrictions of the user
     */
    public DietaryPreferences getDietaryRestrictions() {
        return this;
    }

    /**
     * Get the dietary restrictions of the user
     * @return the dietary restrictions of the user
     */
    public Map<String, Float> getRestrictionMap() {
        return dietaryRestrictions;
    }

    /**
     * Set the dietary restrictions of the user
     * @param dietaryRestrictions the dietary restrictions of the user
     */
    public void setDietaryRestrictions(Map<String, Float> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    /**
     * Add a dietary restriction to the user
     * @param restriction the dietary restriction to add
     * @param res the value of the dietary restriction
     */
    public void addRestriction(String restriction, Float res) {
        this.dietaryRestrictions.put(restriction, res);
    }

    /**
     * Remove a dietary restriction from the user
     * @param restriction the dietary restriction to remove
     * @param res the value of the dietary restriction
     * @return true if the dietary restriction was removed, false otherwise
     */
    public Boolean removeRestriction(String restriction, Float res) {
        return this.dietaryRestrictions.remove(restriction, res);
    }

    /**
     * Get a dietary restriction from the user
     * @param key the dietary restriction to get
     * @return the value of the dietary restriction
     */
    public Float getRestriction(String key) {
        return this.dietaryRestrictions.get(key);
    }

    /**
     * Get all the keys of the dietary restrictions
     * @return all the keys of the dietary restrictions
     */
    public Set<String> getAllKeys() {
        return this.dietaryRestrictions.keySet();
    }
}
