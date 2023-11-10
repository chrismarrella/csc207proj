package entities;
import java.util.List;
import java.util.Map;

public class Recipe implements DietaryPreferences {

    // Temporary
    public String recipeText;

    private String name;
    private List<String> instructions;
    private List<FoodItem> ingredients;
    private List<Float> macros;
    private Map<String, Boolean> satisfiedDietaryRestrictions;

    public Recipe(String name, List<String> instructions, List<FoodItem> ingredients,
                  List<Float> macros, Map<String, Boolean> satisfiedDietaryRestrictions) {
        this.name = name;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.macros = macros;
        this.satisfiedDietaryRestrictions = satisfiedDietaryRestrictions;
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

    public List<Float> getMacros() {
        return this.macros;
    }

    public void setMacros(List<Float> macros) {
        this.macros = macros;
    }

    public Map<String, Boolean> getDietaryRestrictions() {
        return this.satisfiedDietaryRestrictions;
    }

    public void setDietaryRestrictions(Map<String, Boolean> dietaryRestrictions) {
        this.satisfiedDietaryRestrictions = dietaryRestrictions;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", instructions='" + instructions + '\'' +
                ", ingredients=" + ingredients +
                ", macros=" + macros +
                ", satisfiedDietaryRestrictions=" + satisfiedDietaryRestrictions +
                '}';
    }
}
