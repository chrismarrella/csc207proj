package use_case.update_restrictions;

public class UpdateRestrictionsOutputData {
    final private String fooditem;
    final private Float calories;
    final private Boolean UseCaseFailed;

    public UpdateRestrictionsOutputData(Float calories, String fooditem, Boolean UseCaseFailed) {
        this.fooditem = fooditem;
        this.calories = calories;
        this.UseCaseFailed = UseCaseFailed;
    }
    public String getFooditem() {return fooditem;}

    public Float getcalories() {return calories;}

}
