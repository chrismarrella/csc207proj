package use_case.delete_fooditem;

import entities.FoodItem;
import entities.UserFactory;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteFoodItemInteractorTest {

    /**
     * This class is a simulation of the delete food item data access interface.
     */
    private static class testDAO implements DeleteFoodItemDataAccessInterface {

        private User user;

        /**
         * This method creates a test data access object with the given test user.
         * @param user the user to be stored in the test data access object.
         */
        public testDAO(User user) {
            this.user = user;
        }

        @Override
        public boolean removeSpecificItem(FoodItem item) {
            return user.removeSpecificItem(item);
        }

        @Override
        public PriorityQueue<FoodItem> getQueue() {
            return user.getQueue();
        }

        @Override
        public void addItem(FoodItem item) {
            user.addItem(item);
        }
    }

    private DeleteFoodItemDataAccessInterface dataAccessInterface;
    private DeleteFoodItemOutputBoundary outputBoundary;
    private DeleteFoodItemInteractor interactor;


    /**
     * This method adds two food items to the test user's inventory for testing.
     */
    public void addTwoFoodItems() {
        dataAccessInterface.addItem(new FoodItem("apple", 2024, 1, 1, 5));
        dataAccessInterface.addItem(new FoodItem("pasta", 2024, 3, 1, 300));
    }

    /**
     * This method sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
        UserFactory userFactory = new UserFactory();
        dataAccessInterface = new testDAO(userFactory.create(new HashMap<>()));
    }

    /**
     * This method tests the delete food item use case when the user deletes a food item successfully,
     * with the same amount of deleting food item as the stored food item in the inventory.
     */
    @Test
    public void testDeleteFoodItemSuccess1() {
        outputBoundary = new DeleteFoodItemOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteFoodItemOutputData outputData) {
                assertEquals("5.0 units of apple removed from the inventory", outputData.getDeletedFoodItem());
            }
            @Test
            public void testDeleteFoodItemSuccess1() {
                outputBoundary = new DeleteFoodItemOutputBoundary() {
                    @Override
                    public void prepareSuccessView(DeleteFoodItemOutputData outputData) {
                        assertEquals("5.0 units of apple removed from the inventory", outputData.getDeletedFoodItem());
                    }

                    @Override
                    public void prepareFailView(String error) {
                    }
                };
                interactor = new DeleteFoodItemInteractor(dataAccessInterface, outputBoundary);

                addTwoFoodItems();
                DeleteFoodItemInputData inputData = new DeleteFoodItemInputData("apple", "5");
                PriorityQueue<FoodItem> queue = dataAccessInterface.getQueue();
                interactor.execute(inputData);
                assertEquals("pasta", queue.peek().getName());
            }
            @Override
            public void prepareFailView(String error) {
            }
        };
        interactor = new DeleteFoodItemInteractor(dataAccessInterface, outputBoundary);

        addTwoFoodItems();
        DeleteFoodItemInputData inputData = new DeleteFoodItemInputData("apple", "5");
        PriorityQueue<FoodItem> queue = dataAccessInterface.getQueue();
        interactor.execute(inputData);
        assertEquals("pasta", queue.peek().getName());
    }

    /**
     * This method tests the delete food item use case when the user deletes a food item successfully,
     * with less amount of deleting food item than the stored food item in the inventory.
     */
    @Test
    public void testDeleteFoodItemSuccess2() {
        outputBoundary = new DeleteFoodItemOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteFoodItemOutputData outputData) {
                assertEquals("1.0 units of apple removed from the inventory", outputData.getDeletedFoodItem());
            }

            @Override
            public void prepareFailView(String error) {
            }
        };
        interactor = new DeleteFoodItemInteractor(dataAccessInterface, outputBoundary);

        addTwoFoodItems();
        DeleteFoodItemInputData inputData = new DeleteFoodItemInputData("apple", "1");
        PriorityQueue<FoodItem> queue = dataAccessInterface.getQueue();
        interactor.execute(inputData);
        assertEquals("apple", queue.peek().getName());
        assertEquals(4.0f, queue.peek().getAmount());
    }


    /**
     * This method tests the delete food item use case when the user tries to delete a food item but fails,
     * as the input amount is not a number.
     */
    @Test
    public void testDeleteFoodItemFail1() {
        outputBoundary = new DeleteFoodItemOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteFoodItemOutputData outputData) {
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Input amount is not a valid number.", error);
            }
        };
        interactor = new DeleteFoodItemInteractor(dataAccessInterface, outputBoundary);

        addTwoFoodItems();
        DeleteFoodItemInputData inputData = new DeleteFoodItemInputData("apple", "abc");
        PriorityQueue<FoodItem> queue = dataAccessInterface.getQueue();
        interactor.execute(inputData);
        assertEquals("apple", queue.peek().getName());
        assertEquals(5.0f, queue.peek().getAmount());
    }

    /**
     * This method tests the delete food item use case when the user tries to delete a food item but fails,
     * as the input amount is larger than the stored food item in the inventory.
     */
    @Test
    public void testDeleteFoodItemFail2() {
        outputBoundary = new DeleteFoodItemOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteFoodItemOutputData outputData) {
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Too large amount.", error);
            }
        };
        interactor = new DeleteFoodItemInteractor(dataAccessInterface, outputBoundary);

        addTwoFoodItems();

        DeleteFoodItemInputData inputData = new DeleteFoodItemInputData("apple", "8");
        PriorityQueue<FoodItem> queue = dataAccessInterface.getQueue();
        interactor.execute(inputData);
        assertEquals("apple", queue.peek().getName());
        assertEquals(5.0f, queue.peek().getAmount());
    }

    /**
     * This method tests the delete food item use case when the user tries to delete a food item but fails,
     * as the input food item is not in the user inventory.
     */
    @Test
    public void testDeleteFoodItemFail3() {
        outputBoundary = new DeleteFoodItemOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteFoodItemOutputData outputData) {
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("No such food item.", error);
            }
        };
        interactor = new DeleteFoodItemInteractor(dataAccessInterface, outputBoundary);

        addTwoFoodItems();

        DeleteFoodItemInputData inputData = new DeleteFoodItemInputData("banana", "1");
        PriorityQueue<FoodItem> queue = dataAccessInterface.getQueue();
        interactor.execute(inputData);
        assertEquals("apple", queue.peek().getName());
        assertEquals(5.0f, queue.peek().getAmount());
    }

    /**
     * This method tests the delete food item use case when the user tries to delete a food item but fails,
     * as the input amount is not a positive number.
     */
    @Test
    public void testDeleteFoodItemFail4() {
        outputBoundary = new DeleteFoodItemOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteFoodItemOutputData outputData) {
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Input amount is not a valid number.", error);
            }
        };
        interactor = new DeleteFoodItemInteractor(dataAccessInterface, outputBoundary);

        addTwoFoodItems();
        DeleteFoodItemInputData inputData = new DeleteFoodItemInputData("apple", "-1");
        PriorityQueue<FoodItem> queue = dataAccessInterface.getQueue();
        interactor.execute(inputData);
        assertEquals("apple", queue.peek().getName());
        assertEquals(5.0f, queue.peek().getAmount());

    }
}
