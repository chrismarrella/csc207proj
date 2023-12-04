package entities;

/**
 * The interface for the ingredient validator.
 * This interface is used to validate the inputs of the ingredients.
 */
public interface IngredientValidator {
    public boolean ingredientIsValid(String ingredient);
}