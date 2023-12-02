package use_case.delete_foodItem;

import entities.FoodItem;
import entities.Inventory;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DeleteFoodItemInteractor implements DeleteFoodItemInputBoundary {
    DeleteFoodItemOutputBoundary deleteFoodItemPresenter;
    DeleteFoodItemDataAccessInterface deleteFoodItemDataAccessObject;

    public DeleteFoodItemInteractor(DeleteFoodItemDataAccessInterface deleteFoodItemDataAccessObject,
                                    DeleteFoodItemOutputBoundary deleteFoodItemPresenter) {
        this.deleteFoodItemDataAccessObject = deleteFoodItemDataAccessObject;
        this.deleteFoodItemPresenter = deleteFoodItemPresenter;
    }

    @Override
    public void execute(DeleteFoodItemInputData deleteFoodItemInputData) {
        String foodItem = deleteFoodItemInputData.getFoodItem();
        String amount = deleteFoodItemInputData.getAmount();
        float floatAmount;

        // exception handling when input amount is not a number
        try {
            floatAmount = Float.parseFloat(amount);

            // storing food items in user inventory in array list to search for food item with its name
            ArrayList<FoodItem> inventory = new ArrayList<>(deleteFoodItemDataAccessObject.getQueue());

            FoodItem foundFoodItem = null;
            boolean found = false;
            int i = 0;

            // if there are multiple food items with same name, then the one that expires soon
            // is removed from the inventory
            while (i < inventory.size() && !found) {
                FoodItem item = inventory.get(i);
                if (item.getName().equals(foodItem)) {
                    foundFoodItem = item;
                    found = true;
                }
                i += 1;
            }

            if (found) {
                float foundAmount = foundFoodItem.getAmount();

                if (floatAmount <= 0) {
                    deleteFoodItemPresenter.prepareFailView("Input amount is not a valid number.");

                } else if (floatAmount > foundAmount) {
                    deleteFoodItemPresenter.prepareFailView("Too large amount.");

                } else {

                    if (floatAmount < foundAmount) {
                        // when certain amount of food is removed and there's some leftover in the inventory
                        boolean deleted = deleteFoodItemDataAccessObject.removeSpecificItem(foundFoodItem);
                        foundFoodItem.setAmount(foundAmount - floatAmount);
                        deleteFoodItemDataAccessObject.addItem(foundFoodItem);

                    } else {
                        // when amount == foundAmount
                        boolean deleted = deleteFoodItemDataAccessObject.removeSpecificItem(foundFoodItem);

                    }

                    DeleteFoodItemOutputData deleteFoodItemOutputData =
                            new DeleteFoodItemOutputData(foundFoodItem, floatAmount);
                    deleteFoodItemPresenter.prepareSuccessView(deleteFoodItemOutputData);
                }

            } else {
                // if the food item to remove is not in the user inventory
                deleteFoodItemPresenter.prepareFailView("No such food item.");
            }

        } catch (Exception e) {
            deleteFoodItemPresenter.prepareFailView("Input amount is not a valid number.");
        }
    }
}
