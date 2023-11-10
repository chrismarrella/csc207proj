package use_case.add_user_inventory;

public class AddUserInventoryInputData {
    final private String ingredient;
    public AddUserInventoryInputData(String ingredient) {
        this.ingredient = ingredient;
    }
    String getIngredient() {
        return ingredient;
    }

}
