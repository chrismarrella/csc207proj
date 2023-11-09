package entities.get_recipe;
import java.util.Map;

public class UserFactory {
    public User create(Map<String, Boolean> dietaryRestrictions) {
        return new User(dietaryRestrictions);
    }
}
