package use_case.add_fooditem;

public class AddFoodItemInputData {
    final private String ingredient;
    final private Integer year;
    final private  Integer month;
    final private Integer day;
    public AddFoodItemInputData(String ingredient, Integer year, Integer month, Integer day) {

        this.ingredient = ingredient;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    String getIngredient() {
        return ingredient;
    }
    Integer getYear() {return year;}
    Integer getMonth() {return month;}
    Integer getDay() {return day;}
}
