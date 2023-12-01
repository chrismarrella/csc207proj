package view;

import interface_adapter.delete_foodItem.DeleteFoodItemController;
import interface_adapter.delete_foodItem.DeleteFoodItemState;
import interface_adapter.delete_foodItem.DeleteFoodItemViewModel;
import interface_adapter.main_menu.MainMenuState;

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
    private JTextField foodItemInputField = new JTextField(10);
    private final JTextField amountInputField = new JTextField(10);
    private final JButton enter;
    private final JButton cancel;

    public DeleteFoodItemView(DeleteFoodItemViewModel deleteFoodItemViewModel,
                              DeleteFoodItemController deleteFoodItemController) {
        this.deleteFoodItemViewModel = deleteFoodItemViewModel;
        this.deleteFoodItemController = deleteFoodItemController;
        deleteFoodItemViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(DeleteFoodItemViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

//        JPanel inputFields = new JPanel();
//        foodItemInputField = new JTextField();
//        inputFields.add(DeleteFoodItemViewModel.DELETE_LABEL, new JLabel());
//        inputFields.add(foodItemInputField);

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

        enter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(enter)) {
                            DeleteFoodItemState currState = deleteFoodItemViewModel.getState();

                            deleteFoodItemController.execute(
                                    currState.getFoodItem(),
                                    currState.getAmount());
                        }
                    }
        });

        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(cancel)) {
                            //TODO: implement cancel - go to main menu
                        }
                    }
                }
        );

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

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("deleteFoodItemState")) {
            DeleteFoodItemState state = (DeleteFoodItemState) evt.getNewValue();

            // pop-up error messages for each error cases
            if (state.getFoodItemError() != null) {
                JOptionPane.showMessageDialog(this, state.getFoodItemError());
            } else if (state.getAmountError() != null){
                JOptionPane.showMessageDialog(this, state.getAmountError());
                setFields(state);
            } else if (state.getAmountDataTypeError() != null) {
                JOptionPane.showMessageDialog(this, state.getAmountDataTypeError());
                setFields(state);
            } else {
                // when no error occurs, a message with deleted food item and amount pops up
                JOptionPane.showMessageDialog(this, state.getDeletedFoodItem());
            }
        }
    }

    private void setFields(DeleteFoodItemState state) {
        foodItemInputField.setText(state.getFoodItem());
    }

}
