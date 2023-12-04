package use_case.main_menu;

import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the MainMenuInteractor.
 */
class MainMenuInteractorTest {
    /**
     * Initialize the test data access interface.
     */
    private static class TestMainMenuDataAccessInterface implements MainMenuDataAccessInterface {
        private UserFactory userFactory;
        private List<User> userList = new ArrayList<>();  // Change to a mutable list

        /**
         * Constructor for the test data access interface.
         * @param userFactory the user factory
         */
        public TestMainMenuDataAccessInterface(UserFactory userFactory) {
            this.userFactory = userFactory;
        }

        /**
         * Saves the user.
         * @param user the user
         */
        @Override
        public void save(User user) {
            userList.add(user);
        }

        /**
         * Gets all the users.
         * @return the list of users
         */
        @Override
        public List<User> getAllUsers() {
            return userList;
        }
    }

    private MainMenuInteractor interactor;

    /**
     * Sets up the test fixture.
     */
    @BeforeEach
    public void setUp() {
        UserFactory userFactory = new UserFactory();
        List<User> userList = List.of();
        TestMainMenuDataAccessInterface testDataAccess = new TestMainMenuDataAccessInterface(userFactory);
        MainMenuOutputBoundary outputBoundary = new MainMenuOutputBoundary() {
            @Override
            public void prepareSwitchView(String viewName) {
                assertEquals("update restriction", viewName);
            }
        };
        interactor = new MainMenuInteractor(outputBoundary, testDataAccess, userFactory);
    }

    /**
     * Tests the execute method. Passes when the view name is updated and switched.
     */
    @Test
    public void testExecute() {
        MainMenuInputData inputData = new MainMenuInputData("update restriction");
        interactor.execute(inputData.getViewName());
        assertEquals("update restriction", inputData.getViewName());
    }
}
