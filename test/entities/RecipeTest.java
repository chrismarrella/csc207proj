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
    /**
     * Test toMap() method
     */
    @Test
    void testToMap() {
        List<String> instructions = new ArrayList<>();
        instructions.add("test1");
        instructions.add("test2");

        List<FoodItem> ingredients = new ArrayList<>();
        ingredients.add(new FoodItem("test3", 2023, 12, 4, 1));
        ingredients.add(new FoodItem("test4", 2023, 12, 4, 2));

        Map<String, Float> macros = Map.of("test5", 1.0f, "test6", 2.0f);
        Recipe recipe = new Recipe("test recipe", instructions, ingredients, macros);

        Map<String, List<String>> res = new HashMap<>();
        res.put("Name", List.of("test recipe"));
        res.put("Ingredients", List.of("test3:1.0", "test4:2.0"));
        res.put("Instructions", List.of("test1", "test2"));
        res.put("Macros", List.of("test5:1.0", "test6:2.0"));

        assertEquals(res.get("Name"), recipe.toMap().get("Name"));
        assertEquals(res.get("Ingredients"), recipe.toMap().get("Ingredients"));
        assertEquals(res.get("Instructions"), recipe.toMap().get("Instructions"));
    }

    /**
     * Test toString() method
     */
    @Test
    void testToString() {
        List<String> instructions = new ArrayList<>();
        instructions.add("test1");
        instructions.add("test2");

        List<FoodItem> ingredients = new ArrayList<>();
        ingredients.add(new FoodItem("test3", 2023, 12, 4, 1));
        ingredients.add(new FoodItem("test4", 2023, 12, 4, 2));

        Map<String, Float> macros = Map.of("test5", 1.0f, "test6", 2.0f);
        Recipe recipe = new Recipe("test recipe", instructions, ingredients, macros);

        String res = "Name: test recipe\n" +
                "Instructions: test1\ntest2\n" +
                "Ingredients: test3: 1.0\ntest4: 2.0\n" +
                "Macros: test5: 1.0\ntest6: 2.0\n";

        assertEquals(res.substring(0, res.indexOf("Macros")), recipe.toString().substring(0, recipe.toString().indexOf("Macros")));
    }
}