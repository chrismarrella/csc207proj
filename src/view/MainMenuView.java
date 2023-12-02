package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.removeExpired.RemoveExpiredController;
import interface_adapter.removeExpired.RemoveExpiredPresenter;
import interface_adapter.removeExpired.RemoveExpiredState;
import interface_adapter.removeExpired.RemoveExpiredViewModel;
import use_case.main_menu.MainMenuInputData;
import use_case.main_menu.MainMenuInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.util.Calendar;


public class MainMenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "main menu";
    public final JButton GoToGetRecipes;
    private final MainMenuViewModel mainMenuViewModel;
    private final JButton GoToUpdateRestrictions;
    private final MainMenuController mainMenuController;
    private final RemoveExpiredViewModel removeExpiredViewModel;
    private final RemoveExpiredController removeExpiredController;
    public final JButton GoToGetRecipes;
    private final JButton GoToUpdateRestrictions;
    private final JButton GoToDeleteFoodItem;

    public MainMenuView(MainMenuController mainMenuController, MainMenuViewModel mainMenuViewModel,
                        RemoveExpiredController removeExpiredController, RemoveExpiredViewModel removeExpiredViewModel) {
        this.mainMenuViewModel = mainMenuViewModel;
        this.mainMenuController = mainMenuController;
        this.removeExpiredViewModel = removeExpiredViewModel;
        this.removeExpiredController = removeExpiredController;
        mainMenuViewModel.addPropertyChangeListener(this);
        removeExpiredViewModel.addPropertyChangeListener(this);

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

        // Go to Delete Food Item button
        GoToDeleteFoodItem = new JButton(MainMenuViewModel.GO_TO_REMOVE_FOOD_ITEM);
        buttons.add(GoToDeleteFoodItem);
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

        GoToDeleteFoodItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(GoToDeleteFoodItem)) {
                    MainMenuState currentState = mainMenuViewModel.getState();
                    currentState.setView_name("delete food item");
                    mainMenuController.execute(currentState.getView_name());
                }
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        removeExpired(this.removeExpiredController, this.removeExpiredViewModel);
    }

    public void removeExpired(RemoveExpiredController removeExpiredController,
                              RemoveExpiredViewModel removeExpiredViewModel) {

        RemoveExpiredState currState = removeExpiredViewModel.getState();
        removeExpiredController.execute(Calendar.getInstance());

        if (currState.getNoExpired() != null) {
            JOptionPane.showMessageDialog(this, currState.getNoExpired());
        } else {
            JOptionPane.showMessageDialog(this, currState.getExpiredFoodItems());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // preventing error caused from casting state that is not MainMenuState
        if (evt.getPropertyName().equals("main menu")) {
            MainMenuState state = (MainMenuState) evt.getNewValue();

            if (state.getError() != null) {
                JOptionPane.showMessageDialog(this, state.getError());
            }

        } else if (evt.getPropertyName().equals("remove food items")) {
            RemoveExpiredState state = (RemoveExpiredState) evt.getNewValue();
        }
    }
}
