package use_case.delete_fooditem;

public abstract class DeleteFoodItemInputData {
    final private String foodItem;

    // The amount is a string because the error regarding the data type and the number is handled in the interactor.
    final private String amount;

    /**
     * @param foodItem The name of the food item to delete.
     * @param amount The amount of the food item to delete.
     */
    public DeleteFoodItemInputData(String foodItem, String amount) {
        this.foodItem = foodItem;
        this.amount = amount;
    }

    /**
     * @return The name of the food item to delete.
     */
    public String getFoodItem() {
        return foodItem;
    }

    /**
     * @return The amount of the food item to delete.
     */
    public String getAmount() {
        return amount;
    }

    public abstract void execute(String foodItemName, String amount);
}
