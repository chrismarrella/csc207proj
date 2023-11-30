package data_access;

import entities.DietaryPreferences;
import entities.FoodItem;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

public class RecipeGetter {
    private final List<String> macros = Arrays.asList("minCarbs", "maxCarbs",
            "minProtein", "maxProtein", "minCalories", "maxCalories", "minSaturatedFat", "maxSaturatedFat");

    private final List<String> diets = Arrays.asList("Vegetarian", "Ketogenic", "Vegan");

    public JSONObject getRecipe(String key, List<Object> settings) {
        String incFood = (String) settings.get(0);
        String excFood = (String) settings.get(1);
        String diet = (String) settings.get(2);
        Map<String, Float> newPrefs = (HashMap) settings.get(3);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format(
                        "https://api.spoonacular.com/recipes/complexSearch?apiKey=%s&diet=%s&includeIngredients=%s&excludeIngredients=%s&minCarbs=%s&maxCarbs=%s&minProtein=%s&maxProtein=%s&minCalories=%s&maxCalories=%s&minSaturatedFat=%s&maxSaturatedFat=%s&number=%s",
                        key, diet, incFood, excFood, newPrefs.get("minCarbs"), newPrefs.get("maxCarbs"), newPrefs.get("minProtein"),
                        newPrefs.get("maxProtein"), newPrefs.get("minCalories"), newPrefs.get("maxCalories"),
                        newPrefs.get("minSaturatedFat"), newPrefs.get("maxSaturatedFat"), 1))
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());

            return responseBody;
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object> preferenceConverter(List<FoodItem> ingredients, DietaryPreferences dietaryPreferences) {
        // index 0 will be included food items, index 1 will be excluded food items, index 2 will be diet, index 3 will be macros
        Set<String> prefs = dietaryPreferences.getAllKeys();
        List<Object> res = new ArrayList<>(4);
        StringBuilder includedFood = new StringBuilder();
        StringBuilder excludedFood = new StringBuilder();
        StringBuilder diet = new StringBuilder();
        Map<String, Float> newPrefs = new HashMap<>();

        for (String item: prefs) {
            if (macros.contains(item)) {
                newPrefs.put(item, dietaryPreferences.getRestriction(item));
            } else if (diets.contains(item) && dietaryPreferences.getRestriction(item) == 1) {
                diet.append(item);
                diet.append("|");
            } else if (dietaryPreferences.getRestriction(item) == 1) {
                excludedFood.append(item);
                excludedFood.append(",");
            }
        }

        for (FoodItem ingredient: ingredients) {
            includedFood.append(ingredient.getName());
            includedFood.append(",");
        }

        if (includedFood.length() > 0) {includedFood.deleteCharAt(includedFood.length() - 1);}

        if (excludedFood.length() > 0) {excludedFood.deleteCharAt(excludedFood.length() - 1);}

        if (diet.length() > 0) {diet.deleteCharAt(diet.length() - 1);}

        res.add(includedFood.toString());
        res.add(excludedFood.toString());
        res.add(diet.toString());
        res.add(newPrefs);

        assert res.get(0).equals(includedFood.toString());
        assert res.get(1).equals(excludedFood.toString());
        assert res.get(2).equals(diet.toString());
        assert res.get(3).equals(newPrefs);
//        res.set(0, includedFood.toString());
//        res.set(1, excludedFood.toString());
//        res.set(2, diet.toString());
//        res.set(3, newPrefs);

        return res;
    }

    public JSONObject getIngredients(Integer id, String key) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.spoonacular.com/recipes/%s/ingredientWidget.json?apiKey=%s", id, key))
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());

            return responseBody;
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject getNutrients(Integer id, String key) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.spoonacular.com/recipes/%s/nutritionWidget.json?apiKey=%s", id, key))
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());

            return responseBody;
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject getInstructions(Integer id, String key) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.spoonacular.com/recipes/%s/analyzedInstructions?apiKey=%s", id, key))
                .build();
        try {
            Response response = client.newCall(request).execute();
            String t1 = response.body().string();
            JSONObject responseBody = new JSONObject(t1.substring(1, t1.length() - 1));

            return responseBody;
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
