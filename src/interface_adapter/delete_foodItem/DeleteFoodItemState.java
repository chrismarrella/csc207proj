package interface_adapter.delete_foodItem;

public class DeleteFoodItemState {

    private String foodItem;
    private String foodItemError = null;
    private String amount;
    private String amountError = null;
    private String amountDataTypeError = null;
    private String deletedFoodItem;

    public DeleteFoodItemState(DeleteFoodItemState copy) {
        foodItem = copy.foodItem;
        foodItemError = copy.foodItemError;
        amount = copy.amount;
        amountError = copy.amountError;
        amountDataTypeError = copy.amountDataTypeError;
        deletedFoodItem = copy.deletedFoodItem;
    }

    public DeleteFoodItemState() {
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFoodItemError() {
        return foodItemError;
    }

    public void setFoodItemError(String foodItemError) {
        this.foodItemError = foodItemError;
    }

    public String getAmountError() {
        return amountError;
    }

    public void setAmountError(String amountError) {
        this.amountError = amountError;
    }

    public String getAmountDataTypeError() {
        return amountDataTypeError;
    }

    public void setAmountDataTypeError(String amountDataTypeError) {
        this.amountDataTypeError = amountDataTypeError;
    }

    public String getDeletedFoodItem() {
        return deletedFoodItem;
    }

    public void setDeletedFoodItem(String deletedFoodItem) {
        this.deletedFoodItem = deletedFoodItem;
    }
}
