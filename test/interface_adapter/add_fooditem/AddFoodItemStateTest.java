package interface_adapter.add_fooditem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddFoodItemStateTest {
    @Test
    public void testDefaultConstructor() {
        AddFoodItemState addFoodItemState = new AddFoodItemState();
        assertNull(addFoodItemState.getIngredientError());
        assertNull(addFoodItemState.getAmountError());
        assertNull(addFoodItemState.getDateError());
        assertEquals("", addFoodItemState.getAmount());
        assertEquals("", addFoodItemState.getYear());
        assertEquals("", addFoodItemState.getMonth());
        assertEquals("", addFoodItemState.getDay());
        assertEquals("", addFoodItemState.getIngredient());
    }

    @Test
    public void testSetIngredientError() {
        AddFoodItemState addFoodItemState = new AddFoodItemState();
        addFoodItemState.setIngredientError("Ingredient is invalid!");
        assertEquals("Ingredient is invalid!", addFoodItemState.getIngredientError());
        assertTrue(addFoodItemState.hasErrors());
    }

    @Test
    public void testSetAmountError() {
        AddFoodItemState addFoodItemState = new AddFoodItemState();
        addFoodItemState.setAmountError("Invalid Amount!");
        assertEquals("Invalid Amount!", addFoodItemState.getAmountError());
    }

    @Test
    public void testSetDateError() {
        AddFoodItemState addFoodItemState = new AddFoodItemState();
        addFoodItemState.setDateError("Invalid Date!");
        assertEquals("Invalid Date!", addFoodItemState.getDateError());
    }

    @Test
    public void testSetAmount() {
        AddFoodItemState addFoodItemState = new AddFoodItemState();
        addFoodItemState.setAmount("1");
        assertEquals("1", addFoodItemState.getAmount());
    }

    @Test
    public void testSetYear() {
        AddFoodItemState addFoodItemState = new AddFoodItemState();
        addFoodItemState.setYear("2024");
        assertEquals("2024", addFoodItemState.getYear());
    }

    @Test
    public void testSetMonth() {
        AddFoodItemState addFoodItemState = new AddFoodItemState();
        addFoodItemState.setMonth("1");
        assertEquals("1", addFoodItemState.getMonth());
    }

    @Test
    public void testSetDay() {
        AddFoodItemState addFoodItemState = new AddFoodItemState();
        addFoodItemState.setDay("1");
        assertEquals("1", addFoodItemState.getDay());
    }

    @Test
    public void testSetIngredient() {
        AddFoodItemState addFoodItemState = new AddFoodItemState();
        addFoodItemState.setIngredient("Banana");
        assertEquals("Banana", addFoodItemState.getIngredient());
    }
}
