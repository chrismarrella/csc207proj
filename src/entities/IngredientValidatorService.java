package entities;

public class IngredientValidatorService implements IngredientValidator{
    @Override
    public boolean ingredientIsValid(String ingredient) {
        if (ingredient.matches(".*\\d+.*")) {
            return false;
        }
        return !ingredient.isEmpty();
    }
}
