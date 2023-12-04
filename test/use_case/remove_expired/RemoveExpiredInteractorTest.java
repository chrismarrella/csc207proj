package use_case.remove_expired;

import entities.FoodItem;
import entities.User;
import entities.UserFactory;
import interface_adapter.remove_expired.RemoveExpiredViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveExpiredInteractorTest {

    /**
     * This class is a simulation of the remove expired data access interface.
     */
    private static class testDAO implements RemoveExpiredDataAccessInterface {

        private User user;

        /**
         * This method creates a test data access object with the given test user.
         * @param user the user to be stored in the test data access object.
         */
        public testDAO(User user) {
            this.user = user;
        }

        @Override
        public PriorityQueue<FoodItem> getQueue() {
            return user.getQueue();
        }

        @Override
        public void removeItem() {
            user.removeItem();
        }

        /**
         * This method adds a food item to the user's inventory.
         * This is created to support adding items to the inventory before testing.
         * @param item the food item to be added to the user's inventory.
         */
        public void addItem(FoodItem item) {
            user.addItem(item);
        }
    }

    private RemoveExpiredDataAccessInterface dataAccessInterface;
    private RemoveExpiredOutputBoundary outputBoundary;
    private RemoveExpiredInteractor interactor;
    private RemoveExpiredViewModel viewModel;

    /**
     * This method sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
        viewModel = new RemoveExpiredViewModel();

        UserFactory userFactory = new UserFactory();
        testDAO dao = new testDAO(userFactory.create(new HashMap<>()));
        dao.addItem(new FoodItem("apple", 2023, 11, 1, 5));
        dao.addItem(new FoodItem("pasta", 2024, 3, 1, 300));
        dataAccessInterface = dao;

        outputBoundary = new RemoveExpiredOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveExpiredOutputData removeExpiredOutputData) {
                assertEquals("Expired food items in your inventory: \napple", removeExpiredOutputData.getExpiredFoodItems());
            }

            @Override
            public void prepareFailView() {
                assertEquals("null\nare expired.", viewModel.getState().getExpiredFoodItems());
            }
        };

    }

    /**
     * This method tests the remove expired use case when there are no expired food items in the user's inventory.
     */
    @Test
    public void testRemoveExpiredFail() {
        Calendar date = Calendar.getInstance();
        date.set(2023, 10, 1);
        RemoveExpiredInputData inputData = new RemoveExpiredInputData(date);
        interactor = new RemoveExpiredInteractor(dataAccessInterface, outputBoundary);
        interactor.execute(inputData);
    }

    /**
     * This method tests the remove expired use case when there exists some expired food items in the user's inventory.
     */
    @Test
    public void testRemoveExpiredSuccess() {
        Calendar date = Calendar.getInstance();
        date.set(2023, 12, 1);
        RemoveExpiredInputData inputData = new RemoveExpiredInputData(date);
        interactor = new RemoveExpiredInteractor(dataAccessInterface, outputBoundary);
        interactor.execute(inputData);
    }

}
