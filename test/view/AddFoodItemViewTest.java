package view;

import interface_adapter.add_fooditem.AddFoodItemController;
import interface_adapter.add_fooditem.AddFoodItemState;
import interface_adapter.add_fooditem.AddFoodItemViewModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.add_fooditem.AddFoodItemInputBoundary;
import use_case.add_fooditem.AddFoodItemInputData;
import use_case.main_menu.MainMenuInputBoundary;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddFoodItemViewTest {
    private AddFoodItemView addFoodItemView;
    private AddFoodItemViewModel addFoodItemViewModel;
    private AddFoodItemInputBoundary addFoodItemInputBoundary;
    private AddFoodItemController addFoodItemController;
    private MainMenuController mainMenuController;
    private MainMenuViewModel mainMenuViewModel;
    private MainMenuInputBoundary mainMenuInputBoundary;
    private MainMenuState mainMenuState;

    @BeforeEach
    public void setUp() {
        addFoodItemViewModel = new AddFoodItemViewModel();
        addFoodItemInputBoundary = new AddFoodItemInputBoundary() {
            @Override
            public void execute(AddFoodItemInputData addFoodItemInputData) {
                AddFoodItemState curr_state = addFoodItemViewModel.getState();
                curr_state.setIngredientError(null);
                curr_state.setDateError(null);
                curr_state.setAmountError(null);
                addFoodItemViewModel.firePropertyChange();
            }
        };
        addFoodItemController = new AddFoodItemController(addFoodItemInputBoundary);
        mainMenuInputBoundary = new MainMenuInputBoundary() {
            @Override
            public void execute(String view_name) {
                MainMenuState mainMenuState = mainMenuViewModel.getState();
                mainMenuState.setView_name(view_name);
                mainMenuViewModel.firePropertyChange();
            }
        };
        mainMenuController = new MainMenuController(mainMenuInputBoundary);
        mainMenuViewModel = new MainMenuViewModel();

        addFoodItemView = new AddFoodItemView(
                addFoodItemController,
                addFoodItemViewModel,
                mainMenuController,
                mainMenuViewModel);
    }

    @Test
    public void testInitialViewState() {
        Calendar calendar = Calendar.getInstance();
        assertEquals("add food item", addFoodItemView.viewName);
        assertEquals(calendar.get(Calendar.YEAR), addFoodItemView.defaultMaxYearValue);
        assertEquals(calendar.get(Calendar.MONTH) + 1, addFoodItemView.defaultMaxMonthValue);
        assertEquals(calendar.get(Calendar.DAY_OF_MONTH), addFoodItemView.defaultMaxDayValue);
        assertEquals("", addFoodItemView.amountInputField.getText());
        assertEquals("", addFoodItemView.amountInputField.getText());
    }

    @Test
    public void testYearSpinnerChangeListener() {
        addFoodItemView.yearSpinner.setValue(2023);
        assertEquals(2023, addFoodItemView.yearSpinner.getValue());
        AddFoodItemState curr_state = addFoodItemViewModel.getState();
        assertEquals("2023", curr_state.getYear());
    }

    @Test
    public void testMonthSpinnerChangeListener() {
        addFoodItemView.monthSpinner.setValue(12);
        assertEquals(12, addFoodItemView.monthSpinner.getValue());
        AddFoodItemState curr_state = addFoodItemViewModel.getState();
        assertEquals("12", curr_state.getMonth());
    }

    @Test
    public void testDaySpinnerChangeListener() {
        addFoodItemView.daySpinner.setValue(15);
        assertEquals(15, addFoodItemView.daySpinner.getValue());
        AddFoodItemState curr_state = addFoodItemViewModel.getState();
        assertEquals("15", curr_state.getDay());
    }

    @Test
    public void addIngredientActionTestTrue() {
        Calendar calendar = Calendar.getInstance();
        addFoodItemView.daySpinner.setValue(15);
        addFoodItemView.monthSpinner.setValue(12);
        addFoodItemView.yearSpinner.setValue(2023);
        addFoodItemView.foodItemInputField.setText("Banana");
        addFoodItemView.amountInputField.setText("1");
        AddFoodItemState current_state = addFoodItemViewModel.getState();
        assertEquals("2023", current_state.getYear());
        assertEquals("12", current_state.getMonth());
        assertEquals("15", current_state.getDay());
//        assertEquals("1", current_state.getAmount());
//        assertEquals("Banana", current_state.getIngredient());
        addFoodItemView.addIngredient.doClick();
        assertEquals(calendar.get(Calendar.YEAR), addFoodItemView.yearSpinner.getValue());
        assertEquals(calendar.get(Calendar.MONTH) + 1, addFoodItemView.monthSpinner.getValue());
        assertEquals(calendar.get(Calendar.DAY_OF_MONTH), addFoodItemView.daySpinner.getValue());
        assertEquals("", addFoodItemView.foodItemInputField.getText());
        assertEquals("", addFoodItemView.amountInputField.getText());}

    @Test
    public void addIngredientActionTestMonthErrorReset() {
        AddFoodItemState current_state = addFoodItemViewModel.getState();
        current_state.setDateError("Invalid Date!");
        addFoodItemView.daySpinner.setValue(15);
        addFoodItemView.monthSpinner.setValue(0);
        addFoodItemView.yearSpinner.setValue(2023);
        addFoodItemView.foodItemInputField.setText("B");
        addFoodItemView.amountInputField.setText("1");
        addFoodItemView.addIngredient.doClick();
        AddFoodItemState state = addFoodItemViewModel.getState();
        assertEquals(null, state.getDateError());
    }

    @Test
    public void addIngredientActionTestAmountErrorReset() {
        AddFoodItemState current_state = addFoodItemViewModel.getState();
        current_state.setAmountError("Amount is Invalid!");
        addFoodItemView.daySpinner.setValue(15);
        addFoodItemView.monthSpinner.setValue(12);
        addFoodItemView.yearSpinner.setValue(2023);
        addFoodItemView.foodItemInputField.setText("B");
        addFoodItemView.amountInputField.setText("abc");
        current_state.setAmountError("Invalid Amount!");
        addFoodItemView.addIngredient.doClick();
        AddFoodItemState state = addFoodItemViewModel.getState();
        assertEquals(null, state.getAmountError());
    }

    @Test
    public void testBackButtonAction() {
        // Simulate pressing the back button
        addFoodItemView.mainMenu.doClick();
        MainMenuState currentState = mainMenuViewModel.getState();
        assertEquals("main menu", currentState.getView_name());
    }

}
