package interface_adapter.update_restrictions;

import java.util.ArrayList;
import java.util.List;

public class UpdateRestrictionsState {
    private Float protein = null;
    private Float carbs = null;
    private Float fat = null;
    private Float calories = null;
    private String error = null;
    private String fooditem = null;

    public UpdateRestrictionsState(UpdateRestrictionsState copy){
        protein = copy.protein;
        carbs = copy.carbs;
        fat = copy.fat;
        calories = copy.calories;
        fooditem = copy.fooditem;
        error = copy.error;
    }

    public UpdateRestrictionsState(){}

    public Float getProtein(){return protein;}

    public void setProtein(Float protein) {this.protein = protein;}

    public Float getCarbs(){return carbs;}

    public void setCarbs(Float carbs) {this.carbs = carbs;}

    public Float getFat(){
        return fat;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    public Float getCalories(){
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public void setFoodItem(String fooditem) {this.fooditem = fooditem;}

    public String getFoodItem(){
        return fooditem;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
