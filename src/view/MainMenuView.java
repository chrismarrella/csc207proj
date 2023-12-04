package view;

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
     * This is the constructor for the main menu view
     * @param mainMenuController the controller for the main menu view.
     * @param mainMenuViewModel the view model for the main menu view.
     * @param removeExpiredController the controller for the remove expired view.
     * @param removeExpiredViewModel the view model for the remove expired view.
     */
    public MainMenuView(MainMenuController mainMenuController, MainMenuViewModel mainMenuViewModel,
                        RemoveExpiredController removeExpiredController, RemoveExpiredViewModel removeExpiredViewModel) {

        // Instantiating the view models and controllers
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

        GoToAddFoodItem.addActionListener(new ActionListener() {
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
             * @param evt the event to be processed when the delete food item button is clicked.
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
     * This method is used to remove expired food items from the user's inventory.
     * Executes the remove expired food items use case.
     * @param removeExpiredController the controller for the remove expired view.
     * @param removeExpiredViewModel the view model for the remove expired view.
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

        }
    }
}
