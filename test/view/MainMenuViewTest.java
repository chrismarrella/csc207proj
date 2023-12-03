package view;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import use_case.main_menu.MainMenuInputBoundary;
import view.MainMenuView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class for the main menu view.
 */
public class MainMenuViewTest {

    private MainMenuView mainMenuView;
    private MainMenuViewModel mainMenuViewModel;
    private MainMenuController mainMenuController;
    private MainMenuInputBoundary mainMenuInputBoundary;

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
        mainMenuView = new MainMenuView(mainMenuController, mainMenuViewModel);
    }

    /**
     * Tests the initialization of the main menu view.
     */
    @Test
    public void testButtonInitialization() {
        assertNotNull(mainMenuView.GoToGetRecipes);
        assertNotNull(mainMenuView.GoToUpdateRestrictions);
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
}