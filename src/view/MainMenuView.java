package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.remove_expired.RemoveExpiredController;
import interface_adapter.remove_expired.RemoveExpiredState;
import interface_adapter.remove_expired.RemoveExpiredViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;

/**
 * This class represents the view for the main menu.
 */
public class MainMenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "main menu";
    private final MainMenuViewModel mainMenuViewModel;
    private final MainMenuController mainMenuController;
    private final RemoveExpiredViewModel removeExpiredViewModel;
    private final RemoveExpiredController removeExpiredController;
    public final JButton GoToGetRecipes;
    public final JButton GoToUpdateRestrictions;
    public final JButton GoToDeleteFoodItem;
    public final JButton GoToAddFoodItem;

    /**
     * This constructor instantiates a new main menu view.
     * @param mainMenuController The main menu controller.
     * @param mainMenuViewModel The main menu view model.
     * @param removeExpiredController The remove expired controller.
     * @param removeExpiredViewModel The remove expired view model.
     */
    public MainMenuView(MainMenuController mainMenuController,
                        MainMenuViewModel mainMenuViewModel,
                        RemoveExpiredController removeExpiredController,
                        RemoveExpiredViewModel removeExpiredViewModel) {
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

        // Go to Add Food Item button
        GoToAddFoodItem = new JButton(MainMenuViewModel.GO_TO_ADD_FOOD_ITEM);
        buttons.add(GoToAddFoodItem);
        add(buttons);

        // Go to Delete Food Item button
        GoToDeleteFoodItem = new JButton(MainMenuViewModel.GO_TO_REMOVE_FOOD_ITEM);
        buttons.add(GoToDeleteFoodItem);
        add(buttons);

        GoToGetRecipes.addActionListener(new ActionListener() {
            /**
             * This method executes the action listener for the get recipes button.
             * @param evt The action event.
             */
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(GoToGetRecipes)) {
                    MainMenuState currentState = mainMenuViewModel.getState();
                    currentState.setView_name("get recipe");
                    mainMenuController.execute(currentState.getView_name());
                }
            }
        });

        GoToUpdateRestrictions.addActionListener(new ActionListener() {
            /**
             * This method executes the action listener for the update restrictions button.
             * @param evt The action event.
             */
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(GoToUpdateRestrictions)) {
                    MainMenuState currentState = mainMenuViewModel.getState();
                    currentState.setView_name("update restriction");
                    mainMenuController.execute(currentState.getView_name());

                }
            }
        });

        GoToAddFoodItem.addActionListener(new ActionListener() {
            /**
             * This method executes the action listener for the add food item button.
             * @param e The action event.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(GoToAddFoodItem)) {
                    MainMenuState currentState = mainMenuViewModel.getState();
                    currentState.setView_name("add food item");
                    mainMenuController.execute(currentState.getView_name());
                }
            }
        });

        GoToDeleteFoodItem.addActionListener(new ActionListener() {
            /**
             * This method executes the action listener for the delete food item button.
             * @param evt The action event.
             */
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(GoToDeleteFoodItem)) {
                    MainMenuState currentState = mainMenuViewModel.getState();
                    currentState.setView_name("delete food item");
                    mainMenuController.execute(currentState.getView_name());
                }
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Remove expired food items use case is triggered here, when the program starts running.
        removeExpired(this.removeExpiredController, this.removeExpiredViewModel);
    }

    /**
     * This method removes expired food items.
     * @param removeExpiredController The remove expired controller.
     * @param removeExpiredViewModel The remove expired view model.
     */
    public void removeExpired(RemoveExpiredController removeExpiredController,
                              RemoveExpiredViewModel removeExpiredViewModel) {

        removeExpiredController.execute(Calendar.getInstance());
        RemoveExpiredState currState = removeExpiredViewModel.getState();

        if (currState.getNoExpired() != null) {
            // fail view when there are no expired food items
            JOptionPane.showMessageDialog(this, currState.getNoExpired());
        } else {
            // success view when there are expired food items
            JOptionPane.showMessageDialog(this, currState.getExpiredFoodItems());
        }
    }

    /**
     * This method executes the action listener for the main menu view.
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");

    }

    /**
     * This method executes the property change listener for the main menu view.
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // preventing error caused from casting state that is not MainMenuState
        if (evt.getPropertyName().equals("main menu")) {
            MainMenuState state = (MainMenuState) evt.getNewValue();

            if (state.getError() != null) {
                JOptionPane.showMessageDialog(this, state.getError());
            }

        }
    }
}
