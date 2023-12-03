package entities;

/**
 * The class for the ingredient validator.
 * This class is used to validate the inputs of the ingredients.
 */
public class IngredientValidatorService implements IngredientValidator{

    /**
     * Validates the inputs of the ingredients. The method checks if the ingreident input has
     * hypen in it or not. If it does not, then as long as the string consists of only letters,
     * and is not empty, it is valid. If it does have a hypen, then it must be in between two
     * letters, and the string must not be empty. The regular expression ensures that only
     * one hypen is allowed in the string.
     *
     * @param ingredient    the ingredient
     * @return true if the ingredient is valid, false otherwise
     */
    @Override
    public boolean ingredientIsValid(String ingredient) {
        if (!ingredient.matches("[a-zA-Z]+[-]?[a-zA-Z]+")) {
            return false;
        }

        return !ingredient.isEmpty();
    }
}
