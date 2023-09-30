import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class demo {
    public static void main(String[] args) {
        JSONObject recipes = getRecipe("1178e228ddeb4ba484e64911de9db1a8", "pasta", "italian");
        System.out.println(recipes);
    }
    public static JSONObject getRecipe(String key, String query, String cuisine) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.spoonacular.com/recipes/complexSearch?apiKey=%s&query=%s&cuisine=&s", key, query, cuisine))
                .build();

        System.out.println(request.url());

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            return responseBody;
            // cant include RuntimeException error, no code in response when it works but code in response when it doesn't work
//            if (responseBody.getInt("code") == 200) {
//                return responseBody;
//            } else {
//                throw new RuntimeException(responseBody.getString("message"));
//            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
