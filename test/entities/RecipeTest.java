package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    private ArrayList<FoodItem> ingredients;
    private Map<String, Float> macros;
    private ArrayList<String> instructions;
    private Recipe recipe;
    @BeforeEach
    void setUp() {
        FoodItem item1 = new FoodItem("Apple", 2024, 1, 1, 1.0f);
        FoodItem item2 = new FoodItem("Pie", 2024, 1, 1, 1.0f);
        ingredients = new ArrayList<FoodItem>();
        macros = new HashMap<String, Float>();
        instructions = new ArrayList<String>();
        recipe = new Recipe(null, instructions,ingredients,macros);
    }

    @Test
    void testGetName() {
        assertNull(recipe.getName());
    }

    @Test
    void testSetName() {
        recipe.setName("Apple Pie");
        assertEquals("Apple Pie", recipe.getName());
    }

    @Test
    void testSetInstructions() {
        ArrayList<String> newInstructions = new ArrayList<String>();
        newInstructions.add("Step 1: Put apples in pie");
        newInstructions.add("Step 2: Bake pie");
        recipe.setInstructions(newInstructions);
        assertEquals(newInstructions, recipe.getInstructions());
    }

    @Test
    void testGetInstructions() {
        assertEquals(instructions, recipe.getInstructions());
    }

    @Test
    void testSetIngredients() {
        ArrayList<FoodItem> newIngredients = new ArrayList<FoodItem>();
        FoodItem item1 = new FoodItem("Apple", 2024, 1, 1, 1.0f);
        FoodItem item2 = new FoodItem("Pie", 2024, 1, 1, 1.0f);
        newIngredients.add(item1);
        newIngredients.add(item2);
        recipe.setIngredients(newIngredients);
        assertEquals(newIngredients, recipe.getIngredients());
    }

    @Test
    void testGetIngredients() {
        assertEquals(ingredients, recipe.getIngredients());
    }

    @Test
    void testSetMacros() {
        macros.put("Calories", 100.0f);
        macros.put("Fat", 10.0f);
        macros.put("Carbs", 20.0f);
        macros.put("Protein", 30.0f);
        recipe.setMacros(macros);
        assertEquals(macros, recipe.getMacros());
    }

    @Test
    void testGetMacros() {
        assertEquals(macros, recipe.getMacros());
    }
}