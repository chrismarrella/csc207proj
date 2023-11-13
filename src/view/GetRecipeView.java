package view;

import interface_adapter.get_recipe.GetRecipeViewModel;

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
    private final JButton generate;
    private final JTextArea resultTextArea;

    public GetRecipeView(GetRecipeViewModel getRecipeViewModel) {
        this.getRecipeViewModel = getRecipeViewModel;
        getRecipeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GetRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        JPanel buttons = new JPanel();
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
                getRecipeViewModel.firePropertyChange();
            }
        });
    }

    private void showRecipes(List<String> recipes) {
        resultTextArea.setText("");
        for (String recipe : recipes) {
            resultTextArea.append(recipe + "\n");
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


