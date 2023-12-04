package view;

import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.delete_fooditem.DeleteFoodItemController;
import interface_adapter.delete_fooditem.DeleteFoodItemState;
import interface_adapter.delete_fooditem.DeleteFoodItemViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class DeleteFoodItemView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "delete food item";
    private final DeleteFoodItemViewModel deleteFoodItemViewModel;
    private final DeleteFoodItemController deleteFoodItemController;
    private final MainMenuViewModel mainMenuViewModel;
    private final MainMenuController mainMenuController;

    public JTextField foodItemInputField = new JTextField(10);
    public final JTextField amountInputField = new JTextField(10);
    public final JButton enter;
    public final JButton cancel;

    /**
     * This method creates a delete food item view.
     * @param deleteFoodItemViewModel the view model for delete food item use case.
     * @param deleteFoodItemController the controller for delete food item use case.
     * @param mainMenuViewModel the view model for main menu.
     * @param mainMenuController the controller for main menu.
     */
    public DeleteFoodItemView(DeleteFoodItemViewModel deleteFoodItemViewModel,
                              DeleteFoodItemController deleteFoodItemController,
                              MainMenuViewModel mainMenuViewModel,
                              MainMenuController mainMenuController) {

        // instantiate the view models and controllers
        this.deleteFoodItemViewModel = deleteFoodItemViewModel;
        this.deleteFoodItemController = deleteFoodItemController;
        this.mainMenuViewModel = mainMenuViewModel;
        this.mainMenuController = mainMenuController;
        deleteFoodItemViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(DeleteFoodItemViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // create the input fields and labels using LabelTextPanel class
        LabelTextPanel foodItemInput = new LabelTextPanel(
                new JLabel(DeleteFoodItemViewModel.DELETE_LABEL), foodItemInputField
        );
        LabelTextPanel amountInput = new LabelTextPanel(
                new JLabel(DeleteFoodItemViewModel.AMOUNT_LABEL), amountInputField
        );

        JPanel buttons = new JPanel();
        enter = new JButton(DeleteFoodItemViewModel.DELETE_FOODITEM_BUTTON_LABEL);
        buttons.add(enter);
        cancel = new JButton(DeleteFoodItemViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        // execute the delete food item use case when the enter button is clicked
        enter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(enter)) {
                            System.out.println("enter button clicked");
                            DeleteFoodItemState currState = deleteFoodItemViewModel.getState();

                            deleteFoodItemController.execute(currState.getFoodItem(), currState.getAmount());
                        }
                    }
        });

        // go back to main menu when the cancel button is clicked
        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(cancel)) {
                            MainMenuState currentState = mainMenuViewModel.getState();
                            currentState.setView_name("main menu");
                            mainMenuController.execute(currentState.getView_name());                        }
                    }
                }
        );

        // set the food item input field when a key is typed
        foodItemInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        DeleteFoodItemState currState = deleteFoodItemViewModel.getState();
                        String text = foodItemInputField.getText() + e.getKeyChar();
                        currState.setFoodItem(text);
                        deleteFoodItemViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        // set the amount input field when a key is typed
        amountInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        DeleteFoodItemState currState = deleteFoodItemViewModel.getState();
                        String text = amountInputField.getText() + e.getKeyChar();
                        currState.setAmount(text);
                        deleteFoodItemViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(foodItemInput);
        this.add(amountInput);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt, print out the action command.
     * @param e the action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    /**
     * This method is called when a bound property is changed.
     * @param evt the property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("delete food item")) {
            DeleteFoodItemState state = (DeleteFoodItemState) evt.getNewValue();

            // pop-up error messages for each error cases
            // when an error occurs, the input fields are set to the previous input
            // notice that the error messages are set to null after they are displayed
            if (state.getFoodItemError() != null) {
                JOptionPane.showMessageDialog(this, state.getFoodItemError());
                state.setFoodItemError(null);
            } else if (state.getAmountDataTypeError() != null) {
                JOptionPane.showMessageDialog(this, state.getAmountDataTypeError());
                setFields(state);
                state.setAmountDataTypeError(null);
            } else if (state.getAmountError() != null){
                JOptionPane.showMessageDialog(this, state.getAmountError());
                setFields(state);
                state.setAmountError(null);
            } else {
                // when no error occurs, a message with deleted food item and amount pops up
                JOptionPane.showMessageDialog(this, state.getDeletedFoodItem());
            }
        }
    }

    /**
     * This method sets the input fields to the previous input.
     * @param state the state of delete food item use case.
     */
    public void setFields(DeleteFoodItemState state) {
        foodItemInputField.setText(state.getFoodItem());
    }

}
