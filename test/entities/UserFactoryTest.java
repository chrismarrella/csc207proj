package entities;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void testCreate() {
        UserFactory userFactory = new UserFactory();
        Map<String, Float> dietaryRestrictions = null;
        User user = userFactory.create(dietaryRestrictions);
        assertNotNull(user);
    }

}