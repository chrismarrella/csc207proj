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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddFoodItemViewDateErrorTest {
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
                curr_state.setDateError("Invalid Date!");
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
    public void addIngredientActionTestMonthError() {
        AddFoodItemState current_state = addFoodItemViewModel.getState();
        addFoodItemView.daySpinner.setValue(15);
        addFoodItemView.monthSpinner.setValue(0);
        addFoodItemView.yearSpinner.setValue(2023);
        addFoodItemView.foodItemInputField.setText("B");
        addFoodItemView.amountInputField.setText("1");
        addFoodItemView.addIngredient.doClick();
        AddFoodItemState state = addFoodItemViewModel.getState();
        assertEquals(null, state.getDateError());
    }
}
