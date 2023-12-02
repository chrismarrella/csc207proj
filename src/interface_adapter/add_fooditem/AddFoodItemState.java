package interface_adapter.add_fooditem;

public class AddFoodItemState {

    private String ingredient = "";
    private String ingredientError = null;
    private String month = "";
    private String day = "";
    private String year = "";
    private String dateError = null;
    private String amount = "";
    private String amountError = null;
    public AddFoodItemState() {
    }
    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIngredientError() {
        return ingredientError;
    }

    public void setIngredientError(String ingredientError) {
        this.ingredientError = ingredientError;
    }

    public String getDateError() {
        return dateError;
    }

    public void setDateError(String monthError) {
        this.dateError = monthError;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountError() {
        return amountError;
    }

    public void setAmountError(String amountError) {
        this.amountError = amountError;
    }
    public boolean hasErrors() {
        return ingredientError != null || amountError != null || dateError != null;
    }

}
