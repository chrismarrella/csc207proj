package use_case.add_fooditem;

public class AddFoodItemInputData {
    final private String ingredient;
    final private Integer year;
    final private  Integer month;
    final private Integer day;
    // I set this <amount> to String for now as there may be units like "500ml"
    final private String amount;
    public AddFoodItemInputData(String ingredient, Integer year, Integer month, Integer day, String amount) {

        this.ingredient = ingredient;
        this.year = year;
        this.month = month;
        this.day = day;
        this.amount = amount;
    }
    String getIngredient() {
        return ingredient;
    }
    Integer getYear(){return year;}
    Integer getMonth(){return month;}
    Integer getDay(){return day;}
    String getAmount() {return amount;}
}
