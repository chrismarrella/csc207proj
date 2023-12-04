package data_access;

import entities.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.add_fooditem.AddFoodItemDataAccessInterface;
import use_case.get_recipe.GetRecipeDataAccessInterface;
import use_case.get_shopping_list.GetShoppingListDataAccessInterface;
import use_case.main_menu.MainMenuDataAccessInterface;
import use_case.delete_foodItem.DeleteFoodItemDataAccessInterface;
import use_case.removeExpired.RemoveExpiredDataAccessInterface;
import use_case.update_restrictions.UpdateRestrictionsDataAccessInterface;

import java.io.*;
import java.util.*;

public class FileUserDataAccessObject implements GetRecipeDataAccessInterface, MainMenuDataAccessInterface, DeleteFoodItemDataAccessInterface, UpdateRestrictionsDataAccessInterface, RemoveExpiredDataAccessInterface, AddFoodItemDataAccessInterface, GetShoppingListDataAccessInterface {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<Integer, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    private final String key = "1178e228ddeb4ba484e64911de9db1a8";

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("inventory", 0);
        headers.put("dietaryRestrictions", 1);

        if (csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String row;
                reader.readLine();
                int numUsers = 0;
                while ((row = reader.readLine()) != null) {
                    // set up user object
                    String[] col = row.split(",");
                    Map<String, Float> dietaryRestrictions = new HashMap<>();
                    User user = userFactory.create(dietaryRestrictions);

                    // split inventory column like Name:Year:Month:Date:Amount/Name:Year:Month:Date:Amount...
                    // split the rows based on slashes for each element of the queue and then by colon for foodItem
                    String[] invItems = new String[0];
                    if (col.length > 0) {
                        String tempInv = String.valueOf(col[headers.get("inventory")]);
                        invItems = tempInv.split("/");
                    }

                    for (String item: invItems) {
                        if (item.isEmpty()) {
                            break;
                        }
                        String[] details = item.split(":");
                        FoodItem newItem = new FoodItem(details[0],
                                Integer.parseInt(details[1]),
                                Integer.parseInt(details[2]),
                                Integer.parseInt(details[3]),
                                Float.parseFloat(details[4]));
                        user.addItem(newItem);
                    }

                    // split dietary restrictions column like String:Boolean/String:Boolean...
                    // similar format to inventory
                    String[] restItems = new String[0];
                    if (col.length > 1) {
                        String tempRest = String.valueOf(col[headers.get("dietaryRestrictions")]);
                        restItems = tempRest.split("/");
                    }

                    for (String item: restItems) {
                        if (item.isEmpty()) {
                            break;
                        }
                        String[] details = item.split(":");
                        user.addRestriction(details[0], Float.valueOf(details[1]));
                    }
                    this.accounts.put(numUsers, user);
                    numUsers += 1;
                }
            }
        }
    }

    public void save(User user) {
        accounts.put(0, user);
        this.save();
    }

    public User get(int userNum) {
        return accounts.get(userNum);
    }

    public List<User> getAllUsers() {
        List<User> res = new ArrayList<>();
        for (int key: accounts.keySet()) {
            res.add(accounts.get(key));
        }
        return res;
    }

    public List<FoodItem> getInventory() {
        User user = accounts.get(0);
        return new ArrayList<FoodItem>(user.getInventory().getQueue());
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                // handle inventory
                StringBuilder inv = new StringBuilder();
                for (FoodItem item : user.getQueue()) {
                    // year/month/day
                    String[] expDate = item.getExpirationDate().split("/");
                    String food = String.format("%s:%s:%s:%s:%s",
                            item.getName(), expDate[0], expDate[1], expDate[2], String.valueOf(item.getAmount()));
                    inv.append(food);
                    inv.append("/");
                }
                if (inv.length() != 0) {
                    inv.deleteCharAt(inv.length() - 1);
                }
                String newInv = inv.toString();

                // handle DietaryRestrictions
                StringBuilder rest = new StringBuilder();
                for (String key : user.getAllKeys()) {
                    String restriction = String.format("%s:%s",
                            key, String.valueOf(user.getRestriction(key)));
                    rest.append(restriction);
                    rest.append("/");
                }
                if (rest.length() != 0) {
                    rest.deleteCharAt(rest.length() - 1);
                }
                String newRest = rest.toString();

                String line = String.format("%s,%s", newInv, newRest);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public DietaryPreferences retrievePreferences() {
        User user = accounts.get(0);
        return user.getDietaryRestrictions();
    }

    public List<Recipe> retrieveRecipes(DietaryPreferences preferences) {
        User user = accounts.get(0);
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

    @Override
    public boolean removeSpecificItem(FoodItem item) {
        boolean res = accounts.get(0).removeSpecificItem(item);
        this.save();
        return res;
    }

    @Override
    public PriorityQueue<FoodItem> getQueue() {
        return accounts.get(0).getQueue();
    }

    @Override
    public void removeItem() {
        accounts.get(0).removeItem();
        this.save();
    }

    @Override
    public void addItem(FoodItem item) {
        accounts.get(0).addItem(item);
        this.save();
    }

    @Override
    public List<String> standardizeNames(List<String> names) {
        return FoodNameParser.parseFoodItemNames(key, names);
    }

}
