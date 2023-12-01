package entities;
import java.util.Map;

public class UserFactory {
    // does this have to be static???
    public User create(Map<String, Float> dietaryRestrictions) {
        return new User(dietaryRestrictions);
    }
}
