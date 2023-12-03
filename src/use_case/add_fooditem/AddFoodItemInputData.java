package use_case.add_fooditem;

public class AddFoodItemInputData {
    final private String ingredient;
    final private String year;
    final private  String month;
    final private String day;
    // I set this <amount> to Float for now to match FoodItem, but there may be units like "500ml"
    final private String amount;
    public AddFoodItemInputData(String ingredient, String year, String month, String day, String amount) {

        this.ingredient = ingredient;
        this.year = year;
        this.month = month;
        this.day = day;
        this.amount = amount;
    }
    Integer intError = -1;
    int toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return intError;
        }
    }
    Float floatError = -1.0f;
    Float toFloat(String str) {
        try {
            return Float.valueOf(str);
        } catch (NumberFormatException e) {
            return floatError;
        }
    }
    String getIngredient() {
        return ingredient;
    }
    Integer getYear(){return toInt(year);}
    Integer getMonth(){return toInt(month);}
    Integer getDay(){return toInt(day);}
    Float getAmount() {return toFloat(amount);}
}
