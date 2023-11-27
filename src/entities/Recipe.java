package entities;
import java.util.List;
import java.util.Map;

public class Recipe {

    // Temporary
    public String recipeText;

    private String name;
    private List<String> instructions;
    private List<FoodItem> ingredients;
    private Map<String, Float> macros;

    public Recipe(String name, List<String> instructions, List<FoodItem> ingredients,
                  Map<String, Float> macros) {
        this.name = name;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.macros = macros;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getInstructions() {
        return this.instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public List<FoodItem> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<FoodItem> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<String, Float> getMacros() {
        return this.macros;
    }

    public void setMacros(Map<String, Float> macros) {
        this.macros = macros;
    }

    @Override
    public String toString() {
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
