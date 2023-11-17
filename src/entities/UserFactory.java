package entities;
import java.util.Map;

public class UserFactory {
    public User create(Map<String, Float> dietaryRestrictions) {
        return new User(dietaryRestrictions);
    }
}
