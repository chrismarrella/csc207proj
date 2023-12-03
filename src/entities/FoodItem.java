package entities;
import java.util.Calendar;
public class FoodItem {
    private String name;
    private final Calendar expirationDate;
    private Float amount;

    public FoodItem(String name, int year, int month, int day, float amount) {
        // January is considered as month 0
        this.name = name;
        this.expirationDate = Calendar.getInstance();
        this.expirationDate.set(Calendar.YEAR, year);
        this.expirationDate.set(Calendar.MONTH, month - 1);
        this.expirationDate.set(Calendar.DAY_OF_MONTH, day);
        this.amount = amount;
    }

    public FoodItem(String name, float amount) {
        // Used specifically for GetShoppingList use case, no need for the expiration date
        this.name = name;
        this.expirationDate = null;
        this.amount = amount;
    }

    public String getExpirationDate() {
        int year = this.expirationDate.get(Calendar.YEAR);
        int month = this.expirationDate.get(Calendar.MONTH) + 1;
        int day = this.expirationDate.get(Calendar.DAY_OF_MONTH);
        return year + "/" + month + "/" + day;
    }

    public Calendar getCalendarObject() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setName(String name) { this.name = name;}
}
