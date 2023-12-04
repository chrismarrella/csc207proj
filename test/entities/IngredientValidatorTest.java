package entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class IngredientValidatorTest implements IngredientValidator{
    @Override
    public boolean ingredientIsValid(String ingredient) {
        IngredientValidatorService ingredientValidatorService = new IngredientValidatorService();
        return ingredientValidatorService.ingredientIsValid(ingredient);
    }

    @Test
    public void TestIngredientIsValidNoHyphen() {
        assertTrue(ingredientIsValid("Banana"));
    }

    @Test
    public void TestIngredientIsValidWithHyphen() {
        assertTrue(ingredientIsValid("Banana-Bread"));
    }

    @Test
    public void TestIngredientHasHyphenEnding() {
        assertFalse(ingredientIsValid("Banana-"));
    }

    @Test
    public void TestIngredientHasHyphenBeginning() {
        assertFalse(ingredientIsValid("-Banana"));
    }

    @Test
    public void TestIngredientIsEmpty() {
        assertFalse(ingredientIsValid(""));
    }

    @Test
    public void TestIngredientHasNumbers() {
        assertFalse(ingredientIsValid("Banana1-bread"));
    }

    @Test
    public void TestIngredientHasSymbols() {
        assertFalse(ingredientIsValid("Banana-bread!"));
    }

}
