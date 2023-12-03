package entities;
import java.util.Calendar;
public class FoodItem {
    private String name;
    private final Calendar expirationDate;
    private Float amount;

    public FoodItem(String name, int year, int month, int day, float amount) {
        /**
         * Constructor for FoodItem
         * @param name the name of the food item
         * @param year the year of expiration
         * @param month the month of expiration
         * @param day the day of expiration
         * @param amount the amount of the food item
         *
         * @return a FoodItem object
         * Note: January is considered as month 0
         */
        this.name = name;
        this.expirationDate = Calendar.getInstance();
        this.expirationDate.set(Calendar.YEAR, year);
        this.expirationDate.set(Calendar.MONTH, month - 1);
        this.expirationDate.set(Calendar.DAY_OF_MONTH, day);
        this.amount = amount;
    }

    public FoodItem(String name, float amount) {
        /**
         * Constructor for FoodItem
         * @param name the name of the food item
         * @param amount the amount of the food item
         *
         * @return a FoodItem object
         */
        // Used specifically for GetShoppingList use case, no need for the expiration date
        this.name = name;
        this.expirationDate = null;
        this.amount = amount;
    }

    public String getExpirationDate() {
        /**
         * Get the expiration date of the food item
         * @return a string representation of the expiration date
         */
        int year = this.expirationDate.get(Calendar.YEAR);
        int month = this.expirationDate.get(Calendar.MONTH) + 1;
        int day = this.expirationDate.get(Calendar.DAY_OF_MONTH);
        return year + "/" + month + "/" + day;
    }

    public Calendar getCalendarObject() {
        /**
         * Get the expiration date of the food item
         * @return a Calendar object representation of the expiration date
         */
        return expirationDate;
    }

    public String getName() {
        /**
         * Get the name of the food item
         * @return a string representation of the name
         */
        return name;
    }

    public Float getAmount() {
        /**
         * Get the amount of the food item
         * @return a float representation of the amount
         */
        return this.amount;
    }

    public void setAmount(Float amount) {
        /**
         * Set the amount of the food item
         * @param amount the amount of the food item
         */
        this.amount = amount;
    }

    public void setName(String name) {
        /**
         * Set the name of the food item
         * @param name the name of the food item
         */
        this.name = name;}
}
