package use_case.removeExpired;

import entities.FoodItem;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Calendar;

public class RemoveExpiredInteractor implements RemoveExpiredInputBoundary {
    RemoveExpiredOutputBoundary removeExpiredPresenter;
    RemoveExpiredDataAccessInterface removeExpiredDataAccessObject;

    public RemoveExpiredInteractor(
            RemoveExpiredDataAccessInterface removeExpiredDataAccessObject,
            RemoveExpiredOutputBoundary removeExpiredPresenter) {
        this.removeExpiredDataAccessObject = removeExpiredDataAccessObject;
        this.removeExpiredPresenter = removeExpiredPresenter;
    }

    @Override
    public void execute(RemoveExpiredInputData removeExpiredInputData) {
        Calendar date = removeExpiredInputData.getDate();

        PriorityQueue<FoodItem> inventory = removeExpiredDataAccessObject.getQueue();
        ArrayList<FoodItem> expiredFoodItems = new ArrayList<>();
        boolean expiredExist = false;

        FoodItem oldestFoodItem = inventory.peek();

        while (!(oldestFoodItem == null) &&
                oldestFoodItem.getCalendarObject().compareTo(date) < 0) {
            removeExpiredDataAccessObject.removeItem();
            expiredFoodItems.add(oldestFoodItem);
            expiredExist = true;
            oldestFoodItem = inventory.peek();
        }

        if (expiredExist) {
            RemoveExpiredOutputData removeExpiredOutputData =
                    new RemoveExpiredOutputData(expiredFoodItems);
            removeExpiredPresenter.prepareSuccessView(removeExpiredOutputData);
        } else {
            removeExpiredPresenter.prepareFailView();
        }
    }
}
