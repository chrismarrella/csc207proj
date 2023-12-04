package view;

import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.remove_expired.RemoveExpiredController;
import interface_adapter.remove_expired.RemoveExpiredState;
import interface_adapter.remove_expired.RemoveExpiredViewModel;
import use_case.main_menu.MainMenuInputBoundary;
import view.MainMenuView;
import use_case.remove_expired.RemoveExpiredInputBoundary;
import use_case.remove_expired.RemoveExpiredInputData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the main menu view.
 */
public class MainMenuViewTest {

    private MainMenuView mainMenuView;
    private MainMenuViewModel mainMenuViewModel;
    private MainMenuController mainMenuController;
    private MainMenuInputBoundary mainMenuInputBoundary;
    private RemoveExpiredViewModel removeExpiredViewModel;
    private RemoveExpiredController removeExpiredController;
    private RemoveExpiredInputBoundary removeExpiredInputBoundary;

    /**
     * Sets up the test fixture.
     */
    @BeforeEach
    public void setUp() {
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
        mainMenuViewModel = new MainMenuViewModel();

        removeExpiredViewModel = new RemoveExpiredViewModel();
        removeExpiredInputBoundary = new RemoveExpiredInputBoundary() {
            @Override
            public void execute(RemoveExpiredInputData removeExpiredInputData) {
                RemoveExpiredState currentState = removeExpiredViewModel.getState();
                currentState.setNoExpired("No expired food item today!");
                removeExpiredViewModel.firePropertyChange();
            }
        };
        removeExpiredController = new RemoveExpiredController(removeExpiredInputBoundary);

        mainMenuView = new MainMenuView(
                mainMenuController, mainMenuViewModel, removeExpiredController, removeExpiredViewModel);
    }

    /**
     * Tests the initialization of the main menu view.
     */
    @Test
    public void testButtonInitialization() {
        assertNotNull(mainMenuView.GoToGetRecipes);
        assertNotNull(mainMenuView.GoToUpdateRestrictions);
        assertNotNull(mainMenuView.GoToDeleteFoodItem);
    }

    /**
     * Tests the action of the go to get recipes button.
     */
    @Test
    public void testGoToGetRecipesButtonAction() {
        mainMenuView.GoToGetRecipes.doClick();

        MainMenuState currentState = mainMenuViewModel.getState();
        assertEquals("get recipe", currentState.getView_name());
    }

    /**
     * Tests the action of the go to update restrictions button.
     */
    @Test
    public void testGoToUpdateRestrictionsButtonAction() {
        mainMenuView.GoToUpdateRestrictions.doClick();

        MainMenuState currentState = mainMenuViewModel.getState();
        assertEquals("update restriction", currentState.getView_name());
    }

    /**
     * Tests the action of the go to get recipes button.
     */
    @Test
    public void testGoToDeleteFoodItemButtonAction() {
        mainMenuView.GoToDeleteFoodItem.doClick();

        MainMenuState currentState = mainMenuViewModel.getState();
        assertEquals("delete food item", currentState.getView_name());
    }

    /**
     * Tests the action of the remove expired food items use case.
     * This use case is triggered when the program starts.
     */
    @Test
    public void testRemoveExpiredAction() {
        mainMenuView.removeExpired(this.removeExpiredController, this.removeExpiredViewModel);
        RemoveExpiredState currentState = removeExpiredViewModel.getState();
        assertEquals("No expired food item today!", currentState.getNoExpired());
        assertEquals("null\nare expired.", currentState.getExpiredFoodItems());
    }
}