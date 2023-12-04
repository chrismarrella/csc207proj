package view;

import interface_adapter.delete_fooditem.DeleteFoodItemController;
import interface_adapter.delete_fooditem.DeleteFoodItemState;
import interface_adapter.delete_fooditem.DeleteFoodItemViewModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.delete_fooditem.DeleteFoodItemInputBoundary;
import use_case.delete_fooditem.DeleteFoodItemInputData;
import use_case.main_menu.MainMenuInputBoundary;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteFoodItemViewTest {

    private DeleteFoodItemView view;
    private DeleteFoodItemViewModel viewModel;
    private DeleteFoodItemController controller;
    private DeleteFoodItemInputBoundary inputBoundary;
    private MainMenuController mainMenuController;
    private MainMenuViewModel mainMenuViewModel;
    private MainMenuInputBoundary mainMenuInputBoundary;
    private MainMenuState mainMenuState;

    /**
     * Sets up the view and its components.
     */
    @BeforeEach
    public void setUp() {
        viewModel = new DeleteFoodItemViewModel();
        viewModel.getState().setFoodItem("apple");
        viewModel.getState().setAmount("5");
        inputBoundary = new DeleteFoodItemInputBoundary() {
            @Override
            public void execute(DeleteFoodItemInputData deleteFoodItemInputData) {
                DeleteFoodItemState currentState = viewModel.getState();
                currentState.setFoodItem(deleteFoodItemInputData.getFoodItem());
                currentState.setAmount(deleteFoodItemInputData.getAmount());
                viewModel.firePropertyChange();
            }
        };
        controller = new DeleteFoodItemController(inputBoundary);

        mainMenuViewModel = new MainMenuViewModel();
        mainMenuInputBoundary = new MainMenuInputBoundary() {
            @Override
            public void execute(String view_name) {
                MainMenuState currentState = mainMenuViewModel.getState();
                currentState.setView_name(view_name);
                mainMenuViewModel.firePropertyChange();
            }
        };
        mainMenuController = new MainMenuController(mainMenuInputBoundary);

        view = new DeleteFoodItemView(viewModel, controller,
                mainMenuViewModel, mainMenuController);
    }

    /**
     * Tests the initial state of the view.
     */
    @Test
    public void testInitialViewState() {
        assertEquals("delete food item", view.viewName);
        assertNotNull(view.enter);
        assertNotNull(view.cancel);
    }

    /**
     * Tests the action of the return to main menu button.
     */
    @Test
    public void testBackButtonAction() {
        // Simulate pressing the back button
        view.cancel.doClick();
        MainMenuState currentState = mainMenuViewModel.getState();
        assertEquals("main menu", currentState.getView_name());
    }

    /**
     * Tests the action of the enter button.
     */
    @Test
    public void testEnterButtonAction() {
        // Simulate pressing the enter button
        view.enter.doClick();
        assertEquals("Remove", view.enter.getText());
    }

    /**
     * Tests the action of the enter button when it fails because the input food item is not in the user inventory.
     */
    @Test
    public void testEnterButtonActionFail1() {
        // Simulate pressing the enter button
        DeleteFoodItemState state = viewModel.getState();
        state.setFoodItemError("No such food item.");
        assertEquals("No such food item.", viewModel.getState().getFoodItemError());
        view.enter.doClick();
        assertNull(viewModel.getState().getFoodItemError());
    }

    /**
     * Tests the action of the enter button when it fails because the input amount is too large.
     */
    @Test
    public void testEnterButtonActionFail2() {
        // Simulate pressing the enter button
        DeleteFoodItemState state = viewModel.getState();
        state.setAmountError("Too large amount.");
        assertEquals("Too large amount.", viewModel.getState().getAmountError());
        view.enter.doClick();
        assertNull(viewModel.getState().getAmountError());
    }

    /**
     * Tests the action of the enter button when it fails because the input amount is not a vaild number.
     */
    @Test
    public void testEnterButtonActionFail3() {
        // Simulate pressing the enter button
        DeleteFoodItemState state = viewModel.getState();
        state.setAmountDataTypeError("Input amount is not a valid number.");
        assertEquals("Input amount is not a valid number.", viewModel.getState().getAmountDataTypeError());
        view.enter.doClick();
        assertNull(viewModel.getState().getAmountDataTypeError());
    }

    /**
     * Tests the action of the set fields method.
     */
    @Test
    public void testSetFields(){
        DeleteFoodItemState state = viewModel.getState();
        state.setFoodItem("onions");
        view.setFields(state);
        view.enter.doClick();
        assertEquals("onions", state.getFoodItem());
    }
}