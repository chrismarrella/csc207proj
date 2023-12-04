package view;

import interface_adapter.add_fooditem.AddFoodItemController;
import interface_adapter.add_fooditem.AddFoodItemState;
import interface_adapter.add_fooditem.AddFoodItemViewModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;

public class AddFoodItemView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "add food item";
    public final AddFoodItemViewModel addFoodItemViewModel;
    private final AddFoodItemController addFoodItemController;
    private final MainMenuViewModel mainMenuViewModel;
    private final MainMenuController mainMenuController;
    public final JButton addIngredient;
    public final JButton mainMenu;
    public final JTextField foodItemInputField = new JTextField(15);
    public final JSpinner yearSpinner;
    public final JSpinner monthSpinner;
    public final JSpinner daySpinner;
    public final JTextField amountInputField = new JTextField(15);
    Calendar calendar = Calendar.getInstance();
    int defaultMaxYearValue = calendar.get(Calendar.YEAR);
    // add one as it starts at 0
    int defaultMaxMonthValue = calendar.get(Calendar.MONTH) + 1;
    int defaultMaxDayValue = calendar.get(Calendar.DAY_OF_MONTH);

    /**
     * Constructor for the add food item view
     * @param addFoodItemController    the controller for the add food item use case
     * @param addFoodItemViewModel     the view model for the add food item use case
     * @param mainMenuController       the controller for the main menu use case
     * @param mainMenuViewModel        the view model for the main menu use case
     */
    public AddFoodItemView(AddFoodItemController addFoodItemController, AddFoodItemViewModel addFoodItemViewModel, MainMenuController mainMenuController, MainMenuViewModel mainMenuViewModel) {
        this.addFoodItemViewModel = addFoodItemViewModel;
        this.addFoodItemController = addFoodItemController;
        this.mainMenuController = mainMenuController;
        this.mainMenuViewModel = mainMenuViewModel;
        addFoodItemViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(addFoodItemViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel buttons = new JPanel();

        SpinnerNumberModel maxYearModel = new SpinnerNumberModel(defaultMaxYearValue, 2023, 2050, 1);
        SpinnerNumberModel maxMonthModel = new SpinnerNumberModel(defaultMaxMonthValue, 1, 12, 1);
        SpinnerNumberModel maxDayModel = new SpinnerNumberModel(defaultMaxDayValue, 1, 31, 1);

        AddFoodItemState currState = addFoodItemViewModel.getState();

        currState.setMonth(String.valueOf(defaultMaxMonthValue));
        currState.setDay(String.valueOf(defaultMaxDayValue));
        currState.setYear(String.valueOf(defaultMaxYearValue));

        addFoodItemViewModel.setState(currState);

        yearSpinner = new JSpinner(maxYearModel);
        yearSpinner.setAlignmentX(BOTTOM_ALIGNMENT);
        monthSpinner = new JSpinner(maxMonthModel);
        daySpinner = new JSpinner(maxDayModel);

        LabelTextPanel amountInfo = new LabelTextPanel(
                new JLabel(AddFoodItemViewModel.AMOUNT_LABEL), amountInputField);

        LabelTextPanel ingredientInfo = new LabelTextPanel(
                new JLabel(AddFoodItemViewModel.FOOD_ITEM_NAME_LABEL), foodItemInputField);

        addIngredient = new JButton(addFoodItemViewModel.ADD_FOOD_ITEM_BUTTON_LABEL);
        mainMenu = new JButton(MainMenuViewModel.GO_TO_MAIN_MENU);
        buttons.add(mainMenu);
        buttons.add(addIngredient);

        addIngredient.addActionListener(new ActionListener() {

            /**
             * Action listener for the add ingredient button.
             * The action listener will call the add food item controller to execute the use case.
             * Afterwards, the input fields will be cleared, and the spinners set back to
             * default values.
             * @param e    the action event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add food item button clicked.");
                addFoodItemController.execute(
                        addFoodItemViewModel.getState().getIngredient(),
                        addFoodItemViewModel.getState().getYear(),
                        addFoodItemViewModel.getState().getMonth(),
                        addFoodItemViewModel.getState().getDay(),
                        addFoodItemViewModel.getState().getAmount());
                amountInputField.setText("");
                foodItemInputField.setText("");
                yearSpinner.setValue(defaultMaxYearValue);
                monthSpinner.setValue(defaultMaxMonthValue);
                daySpinner.setValue(defaultMaxDayValue);
                AddFoodItemState state = addFoodItemViewModel.getState();
                state.setMonth(String.valueOf(defaultMaxMonthValue));
                state.setDay(String.valueOf(defaultMaxDayValue));
                state.setYear(String.valueOf(defaultMaxYearValue));
                state.setIngredient("");
                state.setAmount("");
                addFoodItemViewModel.setState(state);
            }
        });
        mainMenu.addActionListener(new ActionListener() {

            /**
             * Action listener for the main menu button. When clicked, the main menu controller
             * will be called to execute the use case. Afterwards, the input fields will be cleared,
             * the spinners set back to default values, and the state will be reset.
             * @param e    the action event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Main Menu button clicked.");
                MainMenuState currState = mainMenuViewModel.getState();
                currState.setView_name("main menu");
                mainMenuController.execute(currState.getView_name());
                amountInputField.setText("");
                foodItemInputField.setText("");
                yearSpinner.setValue(defaultMaxYearValue);
                monthSpinner.setValue(defaultMaxMonthValue);
                daySpinner.setValue(defaultMaxDayValue);
                AddFoodItemState state = addFoodItemViewModel.getState();
                state.setMonth(String.valueOf(defaultMaxMonthValue));
                state.setDay(String.valueOf(defaultMaxDayValue));
                state.setYear(String.valueOf(defaultMaxYearValue));
                state.setIngredient("");
                state.setAmount("");
                addFoodItemViewModel.setState(state);

            }
        });
        amountInputField.addKeyListener(
                new KeyListener() {

                    /**
                     * Key listener for the amount input field. When a key is typed, the state
                     * will be updated with the new amount. And view model will be updated by
                     * setting this new state.
                     * @param e    the key event
                     */
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddFoodItemState currState = addFoodItemViewModel.getState();
                        currState.setAmount(amountInputField.getText() + e.getKeyChar());
                        addFoodItemViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        foodItemInputField.addKeyListener(
                new KeyListener() {

                    /**
                     * Key listener for the food item input field. When a key is typed, the state
                     * will be updated with the new ingredient. And view model will be updated by
                     * setting this new state.
                     * @param e    the key event
                     */
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddFoodItemState currState = addFoodItemViewModel.getState();
                        currState.setIngredient(foodItemInputField.getText() + e.getKeyChar());
                        addFoodItemViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        yearSpinner.addChangeListener(
                new ChangeListener() {
                    /**
                     * Change listener for the year spinner. When the value is changed, the state
                     * will be updated with the new year input. And view model will be updated by
                     * setting this new state.
                     * @param e    the change event
                     */
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        AddFoodItemState currState = addFoodItemViewModel.getState();
                        currState.setYear(yearSpinner.getValue().toString());
                        addFoodItemViewModel.setState(currState);
                    }
                }
        );

        monthSpinner.addChangeListener(
                new ChangeListener() {
                    /**
                     * Change listener for the month spinner. When the value is changed, the state
                     * will be updated with the new month input. And view model will be updated by
                     * setting this new state.
                     * @param e    the change event
                     */
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        AddFoodItemState currState = addFoodItemViewModel.getState();
                        currState.setMonth(monthSpinner.getValue().toString());
                        addFoodItemViewModel.setState(currState);
                    }
                }
        );

        daySpinner.addChangeListener(
                new ChangeListener() {
                    /**
                     * Change listener for the day spinner. When the value is changed, the state
                     * will be updated with the new day input. And view model will be updated by
                     * setting this new state.
                     * @param e    the change event
                     */
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        AddFoodItemState currState = addFoodItemViewModel.getState();
                        currState.setDay(daySpinner.getValue().toString());
                        addFoodItemViewModel.setState(currState);
                    }
                }
        );
        this.add(title);
        this.add(ingredientInfo);
        this.add(amountInfo);
        this.add(new JLabel(AddFoodItemViewModel.EXPIRY_DATE_YEAR_LABEL));
        this.add(yearSpinner);
        this.add(new JLabel(AddFoodItemViewModel.EXPIRY_DATE_MONTH_LABEL));
        this.add(monthSpinner);
        this.add(new JLabel(AddFoodItemViewModel.EXPIRY_DATE_DAY_LABEL));
        this.add(daySpinner);
        this.add(buttons);
    }

    /**
     * Action performed method for the add food item view. When the add ingredient button is clicked,
     * the add food item controller will be called to execute the use case.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addIngredient)) {
            AddFoodItemState state = addFoodItemViewModel.getState();
            if (!state.hasErrors()) {
                addFoodItemController.execute(
                        state.getIngredient(),
                        state.getYear(),
                        state.getMonth(),
                        state.getDay(),
                        state.getAmount()
                );
            }
        }

    }

    /**
     * Property change method for the add food item view. When the state is changed, the view will
     * be updated accordingly. If there is an error, the corresponding error message will be
     * displayed.
     * @param evt    the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            AddFoodItemState state = addFoodItemViewModel.getState();
            if (state.getIngredientError() != null) {
                String errorMessage = state.getIngredientError();
                JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.INFORMATION_MESSAGE);
                state.setIngredientError(null);
            } else if (state.getDateError() != null) {
                String errorMessage = state.getDateError();
                JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.INFORMATION_MESSAGE);
                state.setDateError(null);
            } else if (state.getAmountError() != null) {
                String errorMessage = state.getAmountError();
                JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.INFORMATION_MESSAGE);
                state.setAmountError(null);
            } else {
                String message = "Ingredient Added!";
                JOptionPane.showMessageDialog(this, message, "Confirmation", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }
}
