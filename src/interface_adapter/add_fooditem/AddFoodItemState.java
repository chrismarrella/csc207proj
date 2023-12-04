package interface_adapter.add_fooditem;
/**
 * The state for the add food item use case.
 * This state is used to store the input data like ingredient, date, and amount and the
 * corresponding errors that may occur.
 */
public class AddFoodItemState {
    private String ingredient = "";
    private String ingredientError = null;
    private String month = "";
    private String day = "";
    private String year = "";
    private String dateError = null;
    private String amount = "";
    private String amountError = null;

    /**
     * Constructor for the add food item state
     */
    public AddFoodItemState() {}

    /**
     * Getter for the ingredient
     * @return the ingredient that was inputted
     */
    public String getIngredient() {
        return ingredient;
    }

    /**
     * Setter for the input ingredient
     * @param ingredient    the ingredient to be set
     */
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * Getter for the input month
     * @return the month that was inputted
     */
    public String getMonth() {
        return month;
    }

    /**
     * Setter for the input month
     * @param month    the month to be set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * Getter for the ingredient error
     * @return the ingredient error
     */
    public String getIngredientError() {
        return ingredientError;
    }

    /**
     * Setter for the ingredient error
     * @param ingredientError    the ingredient error to be set
     */
    public void setIngredientError(String ingredientError) {
        this.ingredientError = ingredientError;
    }

    /**
     * Getter for the date error
     * @return the date error
     */
    public String getDateError() {
        return dateError;
    }

    /**
     * Setter for the date error
     * @param monthError    the date error to be set
     */
    public void setDateError(String monthError) {
        this.dateError = monthError;
    }

    /**
     * Getter for the input day
     * @return the day that was inputted
     */
    public String getDay() {
        return day;
    }

    /**
     * Setter for the input day
     * @param day    the day to be set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * Getter for the input year
     * @return the year that was inputted
     */
    public String getYear() {
        return year;
    }

    /**
     * Setter for the input year
     * @param year    the year to be set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Getter for the input amount
     * @return the amount that was inputted
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Setter for the input amount
     * @param amount    the amount to be set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Getter for the amount error
     * @return the amount error
     */
    public String getAmountError() {
        return amountError;
    }

    /**
     * Setter for the amount error
     * @param amountError    the amount error to be set
     */
    public void setAmountError(String amountError) {
        this.amountError = amountError;
    }

    /**
     * Checks if there are any errors in the state
     * @return true if there are errors in AddFoodItemState, false otherwise
     */
    public boolean hasErrors() {
        return ingredientError != null || amountError != null || dateError != null;
    }

}
