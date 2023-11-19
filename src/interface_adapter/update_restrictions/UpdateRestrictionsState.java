package interface_adapter.update_restrictions;

import java.util.ArrayList;
import java.util.List;

public class UpdateRestrictionsState {
    private Float maxprotein = null;
    private Float maxcarbs = null;
    private Float maxfat = null;
    private Float maxcalories = null;
    private Float minprotein = null;
    private Float mincarbs = null;
    private Float minfat = null;
    private Float mincalories = null;
    private String error = null;
    private String fooditem = null;
    private String success = null;
    private Float vegan = null;
    private Float vegetarian = null;
    private Float keto = null;

    public UpdateRestrictionsState(UpdateRestrictionsState copy){
        maxprotein = copy.maxprotein;
        maxcarbs = copy.maxcarbs;
        maxfat = copy.maxfat;
        maxcalories = copy.maxcalories;
        minprotein = copy.minprotein;
        mincarbs = copy.mincarbs;
        minfat = copy.minfat;
        mincalories = copy.mincalories;
        fooditem = copy.fooditem;
        vegan = copy.vegan;
        vegetarian = copy.vegetarian;
        keto = copy.keto;
        error = copy.error;
        success = copy.success;
    }

    public UpdateRestrictionsState(){}

    public Float getVegan() {return vegan;}
    public void setVegan(Float vegan) {this.vegan = vegan;}

    public Float getVegetarian() {return vegetarian;}
    public void setVegetarian (Float vegetarian)  {this.vegetarian = vegetarian;}

    public Float getKeto() {return keto;}
    public void setKeto(Float keto) {this.keto = keto;}

    public Float getmaxProtein() {return maxprotein;}

    public void setMaxProtein(Float maxprotein) {this.maxprotein = maxprotein;}
    public Float getminProtein() {return minprotein;}

    public void setMinProtein(Float minprotein) {this.minprotein = minprotein;}

    public Float getMaxCarbs(){return maxcarbs;}

    public void setMaxCarbs(Float maxcarbs) {this.maxcarbs = maxcarbs;}
    public Float getMinCarbs(){return mincarbs;}

    public void setMinCarbs(Float mincarbs) {this.mincarbs = mincarbs;}

    public Float getMaxFat(){
        return maxfat;
    }

    public void setMaxFat(Float maxfat) {
        this.maxfat = maxfat;
    }
    public Float getMinFat(){
        return minfat;
    }

    public void setMinFat(Float minfat) {
        this.minfat = minfat;
    }

    public Float getMaxCalories(){
        return maxcalories;
    }

    public void setMaxCalories(Float maxcalories) {
        this.maxcalories = maxcalories;
    }
    public Float getMinCalories(){
        return mincalories;
    }

    public void setMinCalories(Float mincalories) {
        this.mincalories = mincalories;
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

    public String getSuccess() { return success; }

    public void setSuccess(String success) { this.success = success; }
}
