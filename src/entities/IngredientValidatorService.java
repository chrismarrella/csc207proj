package entities;

public class IngredientValidatorService implements IngredientValidator{
    @Override
    public boolean ingredientIsValid(String ingredient) {
        if (!ingredient.matches("[a-z,A-Z]*")) {
            return false;
        }

        return !ingredient.isEmpty();
    }
}
