package entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    @Test
    void testToMap() {
        /**
         * Test toMap() method
         */
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

    @Test
    void testToString() {
        /**
         * Test toString() method
         */
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