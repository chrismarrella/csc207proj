package entities.get_recipe;
import java.util.Calendar;
public class FoodItem {
    private final String name;
    private final Calendar expirationDate;
    private Float amount;

    public FoodItem(String name, int year, int month, int day, float amount) {
        this.name = name;
        this.expirationDate = Calendar.getInstance();
        this.expirationDate.set(year, month, day);
        this.amount = amount;
    }

    public Calendar getExpirationDate() {
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
}
