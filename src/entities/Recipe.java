package entities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
    /**
     * This class represents a recipe.
     */
    // Temporary
    public String recipeText;

    private String name;
    private List<String> instructions;
    private List<FoodItem> ingredients;
    private Map<String, Float> macros;

    public Recipe(String name, List<String> instructions, List<FoodItem> ingredients,
                  Map<String, Float> macros) {
        /**
         * Constructor for Recipe
         * @param name the name of the recipe
         * @param instructions the instructions for the recipe
         * @param ingredients the ingredients for the recipe
         * @param macros the macros for the recipe
         *
         * @return a Recipe object
         */
        this.name = name;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.macros = macros;
    }

    public String getName() {
        /**
         * Get the name of the recipe
         * @return the name of the recipe
         */
        return this.name;
    }

    public void setName(String name) {
        /**
         * Set the name of the recipe
         * @param name the name of the recipe
         */
        this.name = name;
    }

    public List<String> getInstructions() {
        /**
         * Get the instructions for the recipe
         * @return the instructions for the recipe
         */
        return this.instructions;
    }

    public void setInstructions(List<String> instructions) {
        /**
         * Set the instructions for the recipe
         * @param instructions the instructions for the recipe
         */
        this.instructions = instructions;
    }

    public List<FoodItem> getIngredients() {
        /**
         * Get the ingredients for the recipe
         * @return the ingredients for the recipe
         */
        return this.ingredients;
    }

    public void setIngredients(List<FoodItem> ingredients) {
        /**
         * Set the ingredients for the recipe
         * @param ingredients the ingredients for the recipe
         */
        this.ingredients = ingredients;
    }

    public Map<String, Float> getMacros() {
        /**
         * Get the macros for the recipe
         * @return the macros for the recipe
         */
        return this.macros;
    }

    public void setMacros(Map<String, Float> macros) {
        /**
         * Set the macros for the recipe
         * @param macros the macros for the recipe
         */
        this.macros = macros;
    }

    public Map<String, List<String>> toMap() {
        /**
         * Converts a recipe into a map of strings to lists of strings
         *
         * @returns a map of strings to lists of strings where the strings are Name, Ingredients, Instructions, or Macros
         * and the corresponding value is the name of the recipe, the ingredients for the recipe, the instructions for
         * the recipe, or the macros for the recipe
         */
        Map<String, List<String>> pref = new HashMap<>();
        List<String> foods = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<String> nutrients = new ArrayList<>();

        name.add(this.name);

        // food items will be formatted as name:amount, just split by colon when parsing
        for (FoodItem item: this.ingredients) {
            foods.add(item.getName() + ":" + item.getAmount());
        }

        for (String macro: macros.keySet()) {
            nutrients.add(macro + ":" + macros.get(macro));
        }

        pref.put("Name", name);
        pref.put("Ingredients", foods);
        pref.put("Instructions", this.instructions);
        pref.put("Macros", nutrients);

        return pref;
    }

    @Override
    public String toString() {
        /**
         * Converts a recipe into a string
         *
         * @returns a string representation of the recipe
         */
        StringBuilder newInstructions = new StringBuilder();
        for (String instruction: this.instructions) {
            newInstructions.append(instruction);
            newInstructions.append("\n");
        }

        StringBuilder newIngredients = new StringBuilder();
        for (FoodItem ingredient: this.ingredients) {
            newIngredients.append(ingredient.getName() + ": " + ingredient.getAmount());
            newIngredients.append("\n");
        }

        StringBuilder newMacros = new StringBuilder();
        for (String macro: this.macros.keySet()) {
            newMacros.append(macro + ": " + this.macros.get(macro));
            newMacros.append("\n");
        }

        return "Name: " + this.name + '\n' +
                "Instructions: " + newInstructions +
                "Ingredients: " + newIngredients +
                "Macros: " + newMacros;
    }
}
