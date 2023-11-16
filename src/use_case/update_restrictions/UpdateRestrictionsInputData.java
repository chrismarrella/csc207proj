package use_case.update_restrictions;

public class UpdateRestrictionsInputData {
    final private Float protein;
    final private Float carbs;
    final private Float fats;
    final private Float calories;
    final private String fooditem;

    public UpdateRestrictionsInputData(Float protein, Float carbs, Float fats, Float calories, String fooditem) {
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.fooditem = fooditem;
    }

    public Float getcalories() {return calories;}
    public Float getcarbs() {return carbs;}
    public Float getfats() {return fats;}
    public Float getprotein() {return protein;}
    public String getFooditem() {return fooditem;}

}
