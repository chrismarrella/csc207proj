package use_case.add_fooditem;

/**
 * The input data for the add food item use case.
 * This class is used to take in the input data like ingredient, date, and amount and convert them
 * accordingly to the correct data types if needed.
 */
public class AddFoodItemInputData {
    final private String ingredient;
    final private String year;
    final private  String month;
    final private String day;
    final private String amount;

    /**
     * Constructor for the add food item input data
     * @param ingredient    the ingredient to be added
     * @param year          the year of the expiration date
     * @param month         the month of the expiration date
     * @param day           the day of the expiration date
     * @param amount        the amount of the ingredient
     */
    public AddFoodItemInputData(String ingredient, String year, String month, String day, String amount) {

        this.ingredient = ingredient;
        this.year = year;
        this.month = month;
        this.day = day;
        this.amount = amount;
    }


    /**
     * Converts a string to an integer
     * @param s    the string to be converted
     * @return     the integer value of the string or -1 if the string is not an integer
     */
    Integer intError = -1;
    int toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return intError;
        }
    }

    /**
     * Converts a string to a float
     * @param str    the string to be converted
     * @return       the float value of the string or -1.0 if the string is not a float
     */
    Float floatError = -1.0f;
    Float toFloat(String str) {
        try {
            return Float.valueOf(str);
        } catch (NumberFormatException e) {
            return floatError;
        }
    }

    /**
     * Getter for the input ingredient
     * @return the ingredient that was inputted
     */
    String getIngredient() {
        return ingredient;
    }

    /**
     * Getter for the input year
     * @return the year that was inputted
     */
    Integer getYear(){return toInt(year);}

    /**
     * Getter for the input month
     * @return the month that was inputted
     */
    Integer getMonth(){return toInt(month);}

    /**
     * Getter for the input day
     * @return the day that was inputted
     */
    Integer getDay(){return toInt(day);}

    /**
     * Getter for the input amount
     * @return the amount that was inputted
     */
    Float getAmount() {return toFloat(amount);}
}
