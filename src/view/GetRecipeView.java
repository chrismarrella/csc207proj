package view;

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

public class GetRecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get recipe";
    public final JButton MainMenu;
    private final GetRecipeViewModel getRecipeViewModel;
    private final ViewManagerModel viewManagerModel;
    private final JButton generate;
    private final JTextArea resultTextArea;

    public GetRecipeView(ViewManagerModel viewManagerModel, GetRecipeViewModel getRecipeViewModel) {
        this.getRecipeViewModel = getRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
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
                getRecipeViewModel.firePropertyChange();
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
        GetRecipeState state = (GetRecipeState) evt.getNewValue();
        if (state.getError() != null)
            JOptionPane.showMessageDialog(this, "Recipes: Will finalize when API works");
    }
}



