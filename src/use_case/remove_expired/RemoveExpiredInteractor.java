package use_case.remove_expired;

import entities.FoodItem;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Calendar;

public class RemoveExpiredInteractor implements RemoveExpiredInputBoundary {
    RemoveExpiredOutputBoundary removeExpiredPresenter;
    RemoveExpiredDataAccessInterface removeExpiredDataAccessObject;

    /**
     * This is the for remove expired food items interactor.
     * @param removeExpiredDataAccessObject the data access object that implements RemoveExpiredDataAccessInterface.
     * @param removeExpiredPresenter the presenter that implements RemoveExpiredOutputBoundary.
     */
    public RemoveExpiredInteractor(
            RemoveExpiredDataAccessInterface removeExpiredDataAccessObject,
            RemoveExpiredOutputBoundary removeExpiredPresenter) {
        this.removeExpiredDataAccessObject = removeExpiredDataAccessObject;
        this.removeExpiredPresenter = removeExpiredPresenter;
    }

    /**
     * This method executes the remove expired food items use case.
     * @param removeExpiredInputData the input data that implements RemoveExpiredInputData.
     */
    @Override
    public void execute(RemoveExpiredInputData removeExpiredInputData) {
        Calendar date = removeExpiredInputData.getDate();

        PriorityQueue<FoodItem> inventory = removeExpiredDataAccessObject.getQueue();

        // storing expired food items in an arraylist of food items
        ArrayList<FoodItem> expiredFoodItems = new ArrayList<>();
        boolean expiredExist = false;

        // storing the oldest food item in the priority queue without removing it
        FoodItem oldestFoodItem = inventory.peek();

        while (!(oldestFoodItem == null) &&
                oldestFoodItem.getCalendarObject().compareTo(date) < 0) {
            // repeats while the oldest food item in the queue is expired and the queue is not empty

            removeExpiredDataAccessObject.removeItem();
            expiredFoodItems.add(oldestFoodItem);
            expiredExist = true;
            oldestFoodItem = inventory.peek();
        }

        if (expiredExist) {
            // if there are expired food items, prepare the success view

            RemoveExpiredOutputData removeExpiredOutputData =
                    new RemoveExpiredOutputData(expiredFoodItems);
            removeExpiredPresenter.prepareSuccessView(removeExpiredOutputData);

        } else {
            removeExpiredPresenter.prepareFailView();
        }
    }
}
