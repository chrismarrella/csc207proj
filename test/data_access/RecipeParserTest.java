package data_access;

import entities.FoodItem;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RecipeParserTest {
    private static JSONObject testCallResult;

    private boolean listOfFoodItemsEqual(List<FoodItem> item1, List<FoodItem> item2) {
        for (int i = 0; i < item1.size(); i++) {
            if (!item1.get(i).getName().equals(item2.get(i).getName()) ||
                    !item1.get(i).getAmount().equals(item2.get(i).getAmount())) {
                return false;
            }
        }
        return true;
    }

    // Example call result from the API documentation
    //{
    //    "offset": 0,
    //    "number": 2,
    //    "results": [
    //        {
    //            "id": 716429,
    //            "title": "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs",
    //            "image": "https://spoonacular.com/recipeImages/716429-312x231.jpg",
    //            "imageType": "jpg",
    //        },
    //        {
    //            "id": 715538,
    //            "title": "What to make for dinner tonight?? Bruschetta Style Pork & Pasta",
    //            "image": "https://spoonacular.com/recipeImages/715538-312x231.jpg",
    //            "imageType": "jpg",
    //        }
    //    ],
    //    "totalResults": 86
    //}

    @BeforeAll
    static void init() {
        testCallResult = new JSONObject();
        testCallResult.put("offset", 0);
        testCallResult.put("number", 2);

        JSONArray recipes = new JSONArray();
        recipes.put(new JSONObject().put("id", 716429)
                .put("title", "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs")
                .put("image", "https://spoonacular.com/recipeImages/716429-312x231.jpg")
                .put("imageType", "jpg"));
        recipes.put(new JSONObject().put("id", 715538)
                .put("title", "What to make for dinner tonight?? Bruschetta Style Pork & Pasta")
                .put("image", "https://spoonacular.com/recipeImages/715538-312x231.jpg")
                .put("imageType", "jpg"));
        testCallResult.put("results", recipes);
        testCallResult.put("totalResults", 86);
    }
    @Test
    void getId() {
        List<Integer> expectedIds = new ArrayList<>();
        expectedIds.add(716429);
        expectedIds.add(715538);

        assertEquals(expectedIds, new RecipeParser().getIds(testCallResult));
    }

    @Test
    void getNames() {
        List<String> expectedNames = new ArrayList<>();
        expectedNames.add("Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs");
        expectedNames.add("What to make for dinner tonight?? Bruschetta Style Pork & Pasta");

        assertEquals(expectedNames, new RecipeParser().getNames(testCallResult));
    }

    // Example call result from a sample API call (shortened for convenience)
    //[
    //  {
    //    "name": "",
    //    "steps": [
    //      {
    //        "number": 1,
    //        "step": "Crumble sausage into a large skillet. Cook over medium heat, stirring often, until meat is well browned.",
    //        "ingredients": ...,
    //        "equipment": ...
    //      },
    //      {
    //        "number": 2,
    //        "step": "Drain and set aside. In same skillet, cook onion, pepper, garlic, basil and fennel in 1 tb olive oil over medium heat, stirring often to scrape up browned bits from the bottom of pan. Cook until onion is translucent, about 5 minutes.",
    //        "ingredients": ...,
    //        "equipment": ...,
    //        "length": ...
    //      },
    //    ]
    //  }
    //]
    @Test
    void parseInstructions() {
        JSONObject testCallResult = new JSONObject();
        JSONArray steps = new JSONArray();
        steps.put(new JSONObject().put("number", 1)
                .put("step", "Crumble sausage into a large skillet. Cook over medium heat, stirring often, until meat is well browned."));
        steps.put(new JSONObject().put("number", 2)
                .put("step", "Drain and set aside. In same skillet, cook onion, pepper, garlic, basil and fennel in 1 tb olive oil over medium heat, stirring often to scrape up browned bits from the bottom of pan. Cook until onion is translucent, about 5 minutes."));
        testCallResult.put("steps", steps);

        List<String> expectedInstructions = new ArrayList<>();
        expectedInstructions.add("Crumble sausage into a large skillet. Cook over medium heat, stirring often, until meat is well browned.");
        expectedInstructions.add("Drain and set aside. In same skillet, cook onion, pepper, garlic, basil and fennel in 1 tb olive oil over medium heat, stirring often to scrape up browned bits from the bottom of pan. Cook until onion is translucent, about 5 minutes.");

        assertEquals(expectedInstructions, new RecipeParser().parseInstructions(testCallResult));
    }

    // Sample result from a sample API call. Only relevant parts shown
    // {
    //....
    // "nutrients": [
    //    {
    //      "name": "Calories",
    //      "amount": 886.1,
    //      "unit": "kcal",
    //      "percentOfDailyNeeds": 44.3
    //    },
    //    ...
    //    {
    //      "name": "Saturated Fat",
    //      "amount": 16.76,
    //      "unit": "g",
    //      "percentOfDailyNeeds": 104.72
    //    },
    //    {
    //      "name": "Carbohydrates",
    //      "amount": 72.68,
    //      "unit": "g",
    //      "percentOfDailyNeeds": 24.23
    //    },
    //   ...
    //    {
    //      "name": "Protein",
    //      "amount": 32.08,
    //      "unit": "g",
    //      "percentOfDailyNeeds": 64.17
    //    },
    //    ...
    //  ]
    // ...
    //  }

    @Test
    void parseMacros() {
        JSONObject testCallResult = new JSONObject();
        JSONArray nutrients = new JSONArray();
        nutrients.put(new JSONObject().put("name", "Calories")
                .put("amount", 886.1)
                .put("unit", "kcal")
                .put("percentOfDailyNeeds", 44.3));
        nutrients.put(new JSONObject().put("name", "Saturated Fat")
                .put("amount", 16.76)
                .put("unit", "g")
                .put("percentOfDailyNeeds", 104.72));
        nutrients.put(new JSONObject().put("name", "Carbohydrates")
                .put("amount", 72.68)
                .put("unit", "g")
                .put("percentOfDailyNeeds", 24.23));
        nutrients.put(new JSONObject().put("name", "Protein")
                .put("amount", 32.08)
                .put("unit", "g")
                .put("percentOfDailyNeeds", 64.17));

        testCallResult.put("nutrients", nutrients);

        Map<String, Float> expectedMacros = Map.of("Calories", 886.1f,
                "Saturated Fat", 16.76f,
                "Carbohydrates", 72.68f,
                "Protein", 32.08f);

        assertEquals(expectedMacros, new RecipeParser().parseMacros(testCallResult));
    }

    // Sample result from a sample API call (shortened for convenience)
    // {
    //  "ingredients": [
    //    {
    //      "name": "parmesean cheese",
    //      "image": "cheddar-cheese.png",
    //      "amount": {
    //        "metric": {
    //          "value": 56.5,
    //          "unit": "g"
    //        },
    //        "us": {
    //          "value": 0.5,
    //          "unit": "cup"
    //        }
    //      }
    //    },
    //    {
    //      "name": "fennel seed",
    //      "image": "fennel-seeds.jpg",
    //      "amount": {
    //        "metric": {
    //          "value": 0.25,
    //          "unit": "tsps"
    //        },
    //        "us": {
    //          "value": 0.25,
    //          "unit": "tsps"
    //        }
    //      }
    //    },
    //    {
    //      "name": "fresh basil",
    //      "image": "fresh-basil.jpg",
    //      "amount": {
    //        "metric": {
    //          "value": 6.0,
    //          "unit": "g"
    //        },
    //        "us": {
    //          "value": 0.25,
    //          "unit": "cup"
    //        }
    //      }
    //    }
    //  ]
    // }
    @Test
    void parseIngredients() {
        JSONObject testCallResult = new JSONObject();
        JSONArray ingredients = new JSONArray();
        ingredients.put(new JSONObject().put("name", "parmesean cheese")
                .put("image", "cheddar-cheese.png")
                .put("amount", new JSONObject().put("metric", new JSONObject().put("value", 56.5).put("unit", "g"))
                .put("us", new JSONObject().put("value", 0.5).put("unit", "cup"))));
        ingredients.put(new JSONObject().put("name", "fennel seed")
                .put("image", "fennel-seeds.jpg")
                .put("amount", new JSONObject().put("metric", new JSONObject().put("value", 0.25).put("unit", "tsps"))
                .put("us", new JSONObject().put("value", 0.25).put("unit", "tsps"))));
        ingredients.put(new JSONObject().put("name", "fresh basil")
                .put("image", "fresh-basil.jpg")
                .put("amount", new JSONObject().put("metric", new JSONObject().put("value", 6.0).put("unit", "g"))
                .put("us", new JSONObject().put("value", 0.25).put("unit", "cup"))));
        testCallResult.put("ingredients", ingredients);
        // For code handling repeating ingredients
        ingredients.put(new JSONObject().put("name", "fresh basil")
                .put("image", "fresh-basil.jpg")
                .put("amount", new JSONObject().put("metric", new JSONObject().put("value", 8.0).put("unit", "g"))
                        .put("us", new JSONObject().put("value", 0.25).put("unit", "cup"))));
        testCallResult.put("ingredients", ingredients);

        List<FoodItem> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(new FoodItem("parmesean cheese", 56.5f));
        expectedIngredients.add(new FoodItem("fennel seed", 0.25f));
        expectedIngredients.add(new FoodItem("fresh basil", 14.0f));    // 6.0 + 8.0 = 14.0

        assertTrue(listOfFoodItemsEqual(expectedIngredients, new RecipeParser().parseIngredients(testCallResult)));
    }
}