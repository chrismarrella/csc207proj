import entities.FoodItem;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

public class demo {
    public static void main(String[] args) {
//        JSONObject recipes = getRecipe("1178e228ddeb4ba484e64911de9db1a8", "pasta", "italian");
//        JSONObject steps = getInstructions(324694, "1178e228ddeb4ba484e64911de9db1a8");
//        List<String> instructions = parseInstructions(steps);
        JSONObject ingredients = getNutrients(1003464, "1178e228ddeb4ba484e64911de9db1a8");
        Map<String, Float> items = parseMacros(ingredients);

        for (String macro: items.keySet()) {
            System.out.println(macro + ": " + items.get(macro));
        }
    }
    public static JSONObject getRecipe(String key, String query, String cuisine) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.spoonacular.com/recipes/complexSearch?apiKey=%s&query=%s&cuisine=%s&instructionsRequired=%s&addRecipeInformation=%s&addRecipeNutrition=%s",
                        key, query, cuisine, true, true, true))
                .build();

        System.out.println(request.url());

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            return responseBody;
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject getNutrients(Integer id, String key) {
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

    public static Map<String, Float> parseMacros(JSONObject callResult) {
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
}
