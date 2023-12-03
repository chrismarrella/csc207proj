package entities;

import java.util.Map;
import java.util.Set;

public class UserDietaryPreferences implements DietaryPreferences{
    /**
     * This class represents the dietary preferences of a user.
     * float value of 1 is true, 0 is false, any other value for macros is considered as quantity per serving
     */
    private Map<String, Float> dietaryRestrictions;

    public UserDietaryPreferences(Map<String, Float> dietaryRestrictions) {
        /**
         * Constructor for UserDietaryPreferences
         * @param dietaryRestrictions the dietary restrictions of the user
         *
         * @return a UserDietaryPreferences object
         */
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public DietaryPreferences getDietaryRestrictions() {
        /**
         * Get the dietary restrictions of the user
         * @return the dietary restrictions of the user
         */
        return this;
    }

    public Map<String, Float> getRestrictionMap() {
        /**
         * Get the dietary restrictions of the user
         * @return the dietary restrictions of the user
         */
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(Map<String, Float> dietaryRestrictions) {
        /**
         * Set the dietary restrictions of the user
         * @param dietaryRestrictions the dietary restrictions of the user
         */
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public void addRestriction(String restriction, Float res) {
        /**
         * Add a dietary restriction to the user
         * @param restriction the dietary restriction to add
         * @param res the value of the dietary restriction
         */
        this.dietaryRestrictions.put(restriction, res);
    }

    public Boolean removeRestriction(String restriction, Float res) {
        /**
         * Remove a dietary restriction from the user
         * @param restriction the dietary restriction to remove
         * @param res the value of the dietary restriction
         * @return true if the dietary restriction was removed, false otherwise
         */
        return this.dietaryRestrictions.remove(restriction, res);
    }

    public Float getRestriction(String key) {
        /**
         * Get a dietary restriction from the user
         * @param key the dietary restriction to get
         * @return the value of the dietary restriction
         */
        return this.dietaryRestrictions.get(key);
    }

    public Set<String> getAllKeys() {
        /**
         * Get all the keys of the dietary restrictions
         * @return all the keys of the dietary restrictions
         */
        return this.dietaryRestrictions.keySet();
    }
}
