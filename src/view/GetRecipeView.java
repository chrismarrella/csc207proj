package view;

import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.get_shopping_list.GetShoppingListViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class GetRecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get recipe";
    private final GetRecipeViewModel getRecipeViewModel;
    private final GetShoppingListViewModel getShoppingListViewModel;
    private final JButton generate;
    private final JPanel recipesPanel;

    public GetRecipeView(GetRecipeViewModel getRecipeViewModel, GetShoppingListViewModel getShoppingListViewModel) {
        this.getRecipeViewModel = getRecipeViewModel;
        this.getShoppingListViewModel = getShoppingListViewModel;
        getRecipeViewModel.addPropertyChangeListener(this);
        getShoppingListViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GetRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        JPanel buttons = new JPanel();
        generate = new JButton(GetRecipeViewModel.GET_RECIPE_BUTTON_LABEL);
        buttons.add(generate);
        add(buttons);

        recipesPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(recipesPanel);
        add(scrollPane);

        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Generate button clicked.");
                getRecipeViewModel.firePropertyChange();
            }
        });
    }

    private class RecipePanel extends JPanel {
        private String recipe;
        private final JButton selectButton;

        public RecipePanel(String recipe) {
            this.recipe = recipe;
            selectButton = new JButton("Make a Shopping List");

            selectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    System.out.println("Make Shopping List button clicked.");
                    getShoppingListViewModel.firePropertyChange();
                }
            });
        }
    }



    private void showRecipes(List<String> recipes) {
        recipesPanel.removeAll();
        for (String recipe : recipes) {
            RecipePanel recipePanel = new RecipePanel(recipe);
            recipesPanel.add(recipePanel);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            List<String> recipes = getRecipeViewModel.getRecipes();
            showRecipes(recipes);
        }
    }
}


