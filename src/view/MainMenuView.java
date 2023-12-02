package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuController;
import use_case.main_menu.MainMenuInputData;
import use_case.main_menu.MainMenuInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class MainMenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "main menu";
    public final JButton GoToGetRecipes;
    private final MainMenuViewModel mainMenuViewModel;
    private final JButton GoToUpdateRestrictions;
    private final MainMenuController mainMenuController;

    public MainMenuView(MainMenuController mainMenuController ,MainMenuViewModel mainMenuViewModel) {
        this.mainMenuViewModel = mainMenuViewModel;
        this.mainMenuController = mainMenuController;
        mainMenuViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(MainMenuViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        JPanel buttons = new JPanel();

        // Go to Get Recipes button
        GoToGetRecipes = new JButton(MainMenuViewModel.GO_TO_GET_RECIPES_BUTTON_LABEL);
        buttons.add(GoToGetRecipes);
        add(buttons);

        // Go to Update Restrictions button
        GoToUpdateRestrictions = new JButton(MainMenuViewModel.GO_TO_UPDATE_RESTRICTIONS_BUTTON_LABEL);
        buttons.add(GoToUpdateRestrictions);
        add(buttons);

        GoToGetRecipes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(GoToGetRecipes)) {
                    MainMenuState currentState = mainMenuViewModel.getState();
                    currentState.setView_name("get recipe");
                    mainMenuController.execute(currentState.getView_name());
                }
            }
        });
        GoToUpdateRestrictions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(GoToUpdateRestrictions)) {
                    MainMenuState currentState = mainMenuViewModel.getState();
                    currentState.setView_name("update restriction");
                    mainMenuController.execute(currentState.getView_name());

                }
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        MainMenuState state = (MainMenuState) evt.getNewValue();
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError());
        }
    }
}
