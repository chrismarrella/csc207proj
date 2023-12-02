package view.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListGenerator {
    private FileWriter shoppingListFile;

    public ShoppingListGenerator(String filePath) {
        try {
            this.shoppingListFile = new FileWriter(filePath);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeShoppingListToFile(List<String> shoppingList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(shoppingListFile);
            bufferedWriter.write("**Shopping List**");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("|Name    | Amount |");
            bufferedWriter.newLine();
            bufferedWriter.write("|-----| ---:|");
            bufferedWriter.newLine();
            for (String foodItem : shoppingList) {
                String[] foodItemData = foodItem.split(":");
                bufferedWriter.write("| " + foodItemData[0] + " | " + foodItemData[1] + " |");
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ShoppingListGenerator shoppingListGenerator = new ShoppingListGenerator("./output/Shopping_List.md");
        List<String> foodItemList = new ArrayList<>();
        foodItemList.add("tomato:1.0");
        foodItemList.add("potato:2.0");
        foodItemList.add("orange juice:200");
        shoppingListGenerator.writeShoppingListToFile(foodItemList);
    }

}
