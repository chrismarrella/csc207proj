package entities;
import java.util.Map;

/**
 * This class represents a factory for creating users.
 */
public class UserFactory {
    /**
     * Create a user
     * @param dietaryRestrictions the dietary restrictions of the user
     *
     * @return a User object
     */
    public User create(Map<String, Float> dietaryRestrictions) {
        return new User(dietaryRestrictions);
    }
}
