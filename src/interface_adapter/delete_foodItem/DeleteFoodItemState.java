package interface_adapter.delete_foodItem;

public class DeleteFoodItemState {

    private String foodItem;
    private String foodItemError = null;
    private String amount;
    private String amountError = null;
    private String amountDataTypeError = null;
    private String deletedFoodItem;

    public DeleteFoodItemState(DeleteFoodItemState copy) {
        /**
         * This method creates the delete food item state.
         * @param copy The copy of the delete food item state.
         */
        foodItem = copy.foodItem;
        foodItemError = copy.foodItemError;
        amount = copy.amount;
        amountError = copy.amountError;
        amountDataTypeError = copy.amountDataTypeError;
        deletedFoodItem = copy.deletedFoodItem;
    }

    // The default constructor must be explicit because of the previous copy constructor.
    public DeleteFoodItemState() {
    }

    public String getFoodItem() {
        /**
         * This method gets the food item to delete.
         */
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        /**
         * This method sets the food item to delete.
         * @param foodItem The food item to delete.
         */
        this.foodItem = foodItem;
    }

    public String getAmount() {
        /**
         * This method gets the amount of the food item to delete.
         */
        return amount;
    }

    public void setAmount(String amount) {
        /**
         * This method sets the amount of the food item to delete.
         * @param amount The amount of the food item to delete.
         */
        this.amount = amount;
    }

    public String getFoodItemError() {
        /**
         * This method gets the food item error.
         */
        return foodItemError;
    }

    public void setFoodItemError(String foodItemError) {
        /**
         * This method sets the food item error.
         * @param foodItemError The food item error.
         */
        this.foodItemError = foodItemError;
    }

    public String getAmountError() {
        /**
         * This method gets the amount error.
         */
        return amountError;
    }

    public void setAmountError(String amountError) {
        /**
         * This method sets the amount error.
         * @param amountError The amount error.
         */
        this.amountError = amountError;
    }

    public String getAmountDataTypeError() {
        /**
         * This method gets the amount data type error.
         */
        return amountDataTypeError;
    }

    public void setAmountDataTypeError(String amountDataTypeError) {
        /**
         * This method sets the amount data type error.
         * @param amountDataTypeError The amount data type error.
         */
        this.amountDataTypeError = amountDataTypeError;
    }

    public String getDeletedFoodItem() {
        /**
         * This method gets the deleted food item.
         */
        return deletedFoodItem;
    }

    public void setDeletedFoodItem(String deletedFoodItem) {
        /**
         * This method sets the deleted food item.
         * @param deletedFoodItem The deleted food item.
         */
        this.deletedFoodItem = deletedFoodItem;
    }
}
