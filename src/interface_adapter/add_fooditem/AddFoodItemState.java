package interface_adapter.add_fooditem;

public class AddFoodItemState {

    private String ingredient = "";
    private String ingredientError = null;
    private String month = "";
    private String monthError = null;
    private String day = "";
    private String dayError = null;
    private String year = "";
    private String yearError = null;
    private String error = null;

    public void setFoodItemError(String error) {
        this.error = error;
    }
    public void updateState(String error) {
        this.error = error;
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

    public String getMonthError() {
        return monthError;
    }

    public void setMonthError(String monthError) {
        this.monthError = monthError;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayError() {
        return dayError;
    }

    public void setDayError(String dayError) {
        this.dayError = dayError;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYearError() {
        return yearError;
    }

    public void setYearError(String yearError) {
        this.yearError = yearError;
    }
}
