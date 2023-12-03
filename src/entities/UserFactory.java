package entities;
import java.util.Map;

public class UserFactory {
    /**
     * This class represents a factory for creating users.
     */
    public User create(Map<String, Float> dietaryRestrictions) {
        /**
         * Create a user
         * @param dietaryRestrictions the dietary restrictions of the user
         *
         * @return a User object
         */
        return new User(dietaryRestrictions);
    }
}
