package data_access;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses food item names from a list of ingredients using the Spoonacular API
 */
public class FoodNameParser {

    /**
     * Parses food item names from a list of ingredients using the Spoonacular API
     * @param key Spoonacular API key
     * @param foodItemNames List of ingredients
     * @return List of food item names
     */
    public static List<String> parseFoodItemNames(String key, List<String> foodItemNames) {
        String input = String.join("\n", foodItemNames);
        JSONArray jsonOutput = parseFoodItems(key, input);
        return getNames(jsonOutput);
    }
    private static JSONArray parseFoodItems(String key, String foodItemNames) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody formBody = new FormBody.Builder()
                .add("ingredientList", foodItemNames)
                .build();
        String postBody = "ingredientList=" + foodItemNames;
        Request request = new Request.Builder()
                .url(String.format(
                        "https://api.spoonacular.com/recipes/parseIngredients?apiKey=%s",
                        key))
                .post(formBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return new JSONArray(response.body().string());
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getNames(JSONArray callResult) {
        List<String> foodItemNames = new ArrayList<>();
        for (int i = 0; i < callResult.length(); i++) {
            JSONObject foodItem = callResult.getJSONObject(i);
            foodItemNames.add(foodItem.getString("name"));
        }

        return foodItemNames;
    }
}