package use_case.update_restrictions;

import entities.DietaryPreferences;
import entities.User;
import entities.UserDietaryPreferences;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the UpdateRestrictionsInteractor.
 */
public class UpdateRestrictionsInteractorTest {

    private static class TestUpdateRestrictionsDataAccessInterface implements UpdateRestrictionsDataAccessInterface {
        private User user;

        public TestUpdateRestrictionsDataAccessInterface(User user) {
            this.user = user;
        }

        @Override
        public User get(int userId) {
            return user;
        }

        @Override
        public DietaryPreferences retrievePreferences() {
            return user.getDietaryRestrictions();
        }

        @Override
        public void save(User user) {
        }
    }

    private UpdateRestrictionsDataAccessInterface dataAccessInterface;
    private UpdateRestrictionsOutputBoundary outputBoundary;
    private UserDietaryPreferences usermap;
    private UpdateRestrictionsInteractor interactor;

    /**
     * Sets up the test fixture.
     */
    @BeforeEach
    public void setUp() {
        UserFactory userFactory = new UserFactory();
        dataAccessInterface = new TestUpdateRestrictionsDataAccessInterface(userFactory.create(new HashMap<>()));
        outputBoundary = new UpdateRestrictionsOutputBoundary() {
            @Override
            public void prepareUpdatedView(String success) {
                assertEquals("Successfully Updated restriction: " + "MaxCalories", success);
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Invalid restriction: 123", error);
            }

            @Override
            public void prepareCheckedView(String success) {
                assertEquals("Successfully Updated restriction: " + "ketogenic", success);
            }
        };
        usermap = new UserDietaryPreferences(new HashMap<>());
        interactor = new UpdateRestrictionsInteractor(dataAccessInterface, outputBoundary, usermap);


    }

    /**
     * Tests the execute method in UpdateRestrictionsInteractor. Checks if the restriction is valid, if it is then it
     * passes. It also checks if the restriction is invalid, if it is then it fails.
     */
    @Test
    public void testExecuteValidRestriction() {
        UpdateRestrictionsInputData inputData = new UpdateRestrictionsInputData("MaxCalories", 750f);
        DietaryPreferences dietaryPreferences = dataAccessInterface.retrievePreferences();
        interactor.execute(inputData);
        assertEquals(750f, dietaryPreferences.getRestriction("MaxCalories"));

    }

    /**
     * Tests the execute method in UpdateRestrictionsInteractor. This test checks for an error. Since it tries to add "123"
     * it errors out and fails.
     */
    @Test
    public void testExecuteInvalidRestriction() {
        UpdateRestrictionsInputData inputData = new UpdateRestrictionsInputData("123", 1.0f);

        DietaryPreferences dietaryPreferences = dataAccessInterface.retrievePreferences();
        interactor.execute(inputData);
        assertNull(dietaryPreferences.getRestriction("123"));
    }

    /**
     * Tests the execute method in UpdateRestrictionsInteractor. This test checks if the restriction is valid and then
     * passes.
     */
    @Test
    public void testExecuteAddDietType() {
        UpdateRestrictionsInputData inputData = new UpdateRestrictionsInputData("ketogenic", 1.0f);

        DietaryPreferences dietaryPreferences = dataAccessInterface.retrievePreferences();
        interactor.execute(inputData);
        assertEquals(1.0f, dietaryPreferences.getRestriction("ketogenic"));
    }

}

