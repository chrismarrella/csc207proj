package use_case.get_recipe;

import data_access.RecipeGetter;
import data_access.RecipeParser;
import entities.*;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * get recipe interactor tests
 */
class GetRecipeInteractorTest {
    /**
     * This class is to test the get recipe interactor
     */
    private static class TestGetRecipeDataAccessInterface implements GetRecipeDataAccessInterface {
        private User user;
        private final String key = "1178e228ddeb4ba484e64911de9db1a8";

        /**
         * This is the constructor for the test get recipe data access interface
         * @param user the user
         */
        public TestGetRecipeDataAccessInterface(User user) {
            this.user = user;
        }

        /**
         * This method is to retrieve the user's dietary preferences
         * @return the user's dietary preferences
         */
        @Override
        public DietaryPreferences retrievePreferences() {
            return user.getDietaryRestrictions();
        }

        /**
         * This method is to retrieve the user's inventory
         * @param preferences
         * @return
         */
        @Override
        public List<Recipe> retrieveRecipes(DietaryPreferences preferences) {
            InventoryChecker checker = new InventoryChecker();
            RecipeGetter getter = new RecipeGetter();
            RecipeParser parser = new RecipeParser();

            List<FoodItem> expiresSoon = checker.weekCheck(user.getInventory());
            List<Object> settings = getter.preferenceConverter(expiresSoon, preferences);
            JSONObject recipeInfo = getter.getRecipe(key, settings);
            List<String> titles = parser.getNames(recipeInfo);
            List<Integer> ids = parser.getIds(recipeInfo);
            List<Recipe> res = new ArrayList<>();

            int i = 0;
            for (Integer id: ids) {
                List<FoodItem> ingredients = parser.parseIngredients(getter.getIngredients(id, key));
                Map<String, Float> macros = parser.parseMacros(getter.getNutrients(id, key));
                List<String> instructions = parser.parseInstructions(getter.getInstructions(id, key));
                res.add(new Recipe(titles.get(i), instructions, ingredients, macros));
                i++;
            }

            return res;
        }
    }

    private GetRecipeDataAccessInterface getRecipeDataAccessInterface1;
    private GetRecipeDataAccessInterface getRecipeDataAccessInterface2;
    private GetRecipeInteractor getRecipeInteractor;
    private GetRecipeOutputBoundary getRecipeOutputBoundary;
    private UserDietaryPreferences preferences;

    /**
     * This method is to set up the test
     */
    @BeforeEach
    void setUp() {
        UserFactory userFactory = new UserFactory();
        Map<String, Float> pref = new HashMap<>();
        pref.put("maxCarbs", 100f);
        pref.put("minCarbs", 10f);
        pref.put("maxProtein", 100f);
        pref.put("minProtein", 10f);
        pref.put("maxCalories", 800f);
        pref.put("minCalories", 50f);
        pref.put("maxSaturatedFat", 100f);
        pref.put("minSaturatedFat", 0f);
        User user1 = userFactory.create(pref);
        getRecipeDataAccessInterface1 = new TestGetRecipeDataAccessInterface(user1);

        User user2 = userFactory.create(pref);
        user2.addItem(new FoodItem("banana", 2023, 12, 5, 1));
        user2.addItem(new FoodItem("lobster", 2023, 12, 5, 1));
        getRecipeDataAccessInterface2 = new TestGetRecipeDataAccessInterface(user2);


        getRecipeOutputBoundary = new GetRecipeOutputBoundary() {

            /**
             * This method is to check if the output data is correct
             */
            @Override
            public void prepareSuccessView(GetRecipeOutputData name) {
                Recipe recipe = new Recipe("Cannellini Bean and Asparagus Salad with Mushrooms", new ArrayList<>(), new ArrayList<>(), new HashMap<>());
                List<Recipe> result = new ArrayList<>();
                result.add(recipe);
                GetRecipeOutputData getRecipeOutputData = new GetRecipeOutputData(result, false);

                assertEquals(getRecipeOutputData.getRecipeData().get(0).get("Name"), name.getRecipeData().get(0).get("Name"));
            }

            /**
             * This method is to check if the error message is correct
             * @param error the error message
             */
            @Override
            public void prepareFailView(String error) {
                assertEquals("no available recipes", error);
            }
        };
    }

    /**
     * This test is to check if the execute method will return a list of recipes that meets the user's dietary
     * preferences and user's inventory
     */
    @Test
    public void testExecuteValid() {
        getRecipeInteractor = new GetRecipeInteractor(getRecipeDataAccessInterface1, getRecipeOutputBoundary);
        getRecipeInteractor.execute();
    }

    /**
     * This test is to check if the execute method will return an error message when there is no recipe that meets
     * the user's dietary preferences and user's inventory
     */
    @Test
    public void testExecuteInvalid() {
        getRecipeInteractor = new GetRecipeInteractor(getRecipeDataAccessInterface2, getRecipeOutputBoundary);
        getRecipeInteractor.execute();
    }

}