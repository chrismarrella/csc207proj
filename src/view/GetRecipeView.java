package view;

import interface_adapter.get_recipe.GetRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetRecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get recipe";


    private final GetRecipeViewModel getRecipeViewModel;
    private final JButton generate;

    public GetRecipeView(GetRecipeViewModel getRecipeViewModel) {

        this.getRecipeViewModel = getRecipeViewModel;
        getRecipeViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GetRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        generate = new JButton(GetRecipeViewModel.GET_RECIPE_BUTTON_LABEL);
        buttons.add(generate);

        generate.addActionListener(

                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        System.out.println("Cancel not implemented yet.");
                    }
                    //if (e.getSource().equals(generate)) {
                    //GetRecipeState currentState = getRecipeViewModel.getState();
                    //getrecipeController.execute(
                    //currentState.getRecipe()
                    //Will fix this when GetRecipeState is completed

                }
        );


    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Cancel not implemented yet.");
    }
}