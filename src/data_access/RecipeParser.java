package data_access;

import entities.FoodItem;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

public class RecipeParser {
    public List<Integer> getIds(JSONObject callResult) {
        JSONArray res = callResult.getJSONArray("results");
        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < res.length(); i++) {
            Integer id = res.getJSONObject(i).getInt("id");
            ids.add(id);
        }

        return ids;
    }

    public List<String> getNames(JSONObject callResult) {
        JSONArray res = callResult.getJSONArray("results");
        List<String> names = new ArrayList<>();

        for (int i = 0; i < res.length(); i++) {
            String name = res.getJSONObject(i).getString("title");
            names.add(name);
        }

        return names;
    }

    public List<String> parseInstructions(JSONObject callResult) {
        JSONArray res = callResult.getJSONArray("steps");
        List<String> steps = new ArrayList<>();

        for (int i = 0; i < res.length(); i++) {
            String step = res.getJSONObject(i).getString("step");
            steps.add(step);
        }

        return steps;
    }

    public Map<String, Float> parseMacros(JSONObject callResult) {
        JSONArray res = callResult.getJSONArray("nutrients");
        Map<String, Float> macros = new HashMap<>();
        List<String> reqMacros = Arrays.asList("Calories", "Saturated Fat", "Carbohydrates", "Protein");

        for (int i = 0; i < res.length(); i++) {
            String name = res.getJSONObject(i).getString("name");
            if (reqMacros.contains(name)) {
                Float amount = res.getJSONObject(i).getFloat("amount");
                macros.put(name, amount);
            }
        }

        return macros;
    }

    public List<FoodItem> parseIngredients(JSONObject callResult) {
        JSONArray res = callResult.getJSONArray("ingredients");
        List<FoodItem> ingredients = new ArrayList<>();
        Map<String, Integer> included = new HashMap<>();

        for (int i = 0; i < res.length(); i++) {
            String name = res.getJSONObject(i).getString("name");
            Float amount = res.getJSONObject(i).getJSONObject("amount").getJSONObject("metric").getFloat("value");

            if (included.containsKey(name)) {
                Float oldAmount = ingredients.get(included.get(name)).getAmount();
                ingredients.set(included.get(name), new FoodItem(name, 9999, 12, 1, oldAmount + amount));
            } else {
                ingredients.add(new FoodItem(name, 9999, 12, 1, amount));
                included.put(name, ingredients.size() - 1);
            }
        }

        return ingredients;
    }
}
