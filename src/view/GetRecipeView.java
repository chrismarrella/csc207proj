package view;

import entities.Recipe;
import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipeState;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.ViewManagerModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Map;

public class GetRecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get recipe";
    public final JButton MainMenu;
    private final GetRecipeViewModel getRecipeViewModel;
    private final ViewManagerModel viewManagerModel;
    private final GetRecipeController getRecipeController;
    private final JButton generate;
    private final JTextArea resultTextArea;

    public GetRecipeView(ViewManagerModel viewManagerModel,
                         GetRecipeViewModel getRecipeViewModel,
                         GetRecipeController getRecipeController) {
        this.getRecipeViewModel = getRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
        this.getRecipeController = getRecipeController;
        getRecipeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GetRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        JPanel buttons = new JPanel();

        // Back to Main Menu button
        MainMenu = new JButton(GetRecipeViewModel.MAIN_MENU);
        buttons.add(MainMenu);
        add(buttons);


        generate = new JButton(GetRecipeViewModel.GET_RECIPE_BUTTON_LABEL);
        buttons.add(generate);
        add(buttons);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setLineWrap(true);
        resultTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        add(scrollPane);

        generate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Generate button clicked.");
                getRecipeController.execute();
                getRecipeViewModel.firePropertyChange();
                List<Recipe> recipes = getRecipeViewModel.getRecipes();
                showRecipes(recipes);
            }
        });

        MainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(MainMenu)) {
                    // Assuming the viewName for GetRecipeView is "get recipe"
                }
            }
        });
    }

    private void showRecipes(List<Recipe> recipes) {
        resultTextArea.setText("");
//        for (String recipe : recipes) {
//            resultTextArea.append(recipe + "\n");
//        }

        for (Recipe recipe: recipes) {
            Map<String, List<String>> recipeInfo = recipe.toMap();
            StringBuilder display = new StringBuilder();

            List<String> title = recipeInfo.get("Name");
            String name = title.get(0);

            display.append("Name: " + name + "\n");
            for (String info: recipeInfo.keySet()) {
                if (info.equals("Name")) { continue; }
                display.append(info + ": ");

                if (info.equals("Instructions")) {
                    for (String step: recipeInfo.get(info)) {
                        display.append(step + "\n");
                    }
                    continue;
                }
                for (String item: recipeInfo.get(info)) {
                    String[] temp = item.split(":");
                    display.append(temp[0] + ": " + temp[1] + "\n");
                }
            }

            resultTextArea.append(display.toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        GetRecipeState state = (GetRecipeState) evt.getNewValue();
        if (state.getError() != null)
            JOptionPane.showMessageDialog(this, "Recipes: Will finalize when API works");
    }
}



