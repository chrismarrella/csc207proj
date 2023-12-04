package interface_adapter.delete_fooditem;

public class DeleteFoodItemState {

    private String foodItem;
    private String foodItemError = null;
    private String amount;
    private String amountError = null;
    private String amountDataTypeError = null;
    private String deletedFoodItem;

    /**
     * Copy constructor
     * This method creates the delete food item state.
     * @param copy The copy of the delete food item state.
     */
    public DeleteFoodItemState(DeleteFoodItemState copy) {
        foodItem = copy.foodItem;
        foodItemError = copy.foodItemError;
        amount = copy.amount;
        amountError = copy.amountError;
        amountDataTypeError = copy.amountDataTypeError;
        deletedFoodItem = copy.deletedFoodItem;
    }

    /**
     * This is the default constructor.
     */
    public DeleteFoodItemState() {
    }

    /**
     * This method gets the food item to delete.
     * @return The name of the food item to delete in string format.
     */
    public String getFoodItem() {
        return foodItem;
    }

    /**
     * This method sets the food item to delete.
     * @param foodItem The food item to delete.
     */
    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    /**
     * This method gets the amount of the food item to delete.
     * @return The amount of the food item to delete in string format.
     */
    public String getAmount() {
        return amount;
    }

    /**
     * This method sets the amount of the food item to delete.
     * @param amount The amount of the food item to delete.
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * This method gets the food item error.
     * @return The error message regarding the name of the food item.
     */
    public String getFoodItemError() {
        return foodItemError;
    }

    /**
     * This method sets the food item error.
     * @param foodItemError The food item error.
     */
    public void setFoodItemError(String foodItemError) {
        this.foodItemError = foodItemError;
    }

    /**
     * This method gets the amount error.
     * @return The error message regarding the amount of the food item.
     */
    public String getAmountError() {
        return amountError;
    }

    /**
     * This method sets the amount error.
     * @param amountError The amount error.
     */
    public void setAmountError(String amountError) {
        this.amountError = amountError;
    }

    /**
     * This method gets the amount data type error.
     * @return The error message regarding the data type of the amount of the food item.
     */
    public String getAmountDataTypeError() {
        return amountDataTypeError;
    }

    /**
     * This method sets the amount data type error.
     * @param amountDataTypeError The amount data type error.
     */
    public void setAmountDataTypeError(String amountDataTypeError) {
        this.amountDataTypeError = amountDataTypeError;
    }

    /**
     * This method gets the deleted food item.
     * @return The name of the deleted food item in string format.
     */
    public String getDeletedFoodItem() {
        return deletedFoodItem;
    }

    /**
     * This method sets the deleted food item.
     * @param deletedFoodItem The deleted food item.
     */
    public void setDeletedFoodItem(String deletedFoodItem) {
        this.deletedFoodItem = deletedFoodItem;
    }
}
