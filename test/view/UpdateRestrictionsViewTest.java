package view;

import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.update_restrictions.UpdateRestrictionsController;
import interface_adapter.update_restrictions.UpdateRestrictionsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import interface_adapter.update_restrictions.UpdateRestrictionsState;
import use_case.main_menu.MainMenuInputBoundary;
import use_case.update_restrictions.UpdateRestrictionsInputBoundary;
import use_case.update_restrictions.UpdateRestrictionsInputData;
import interface_adapter.main_menu.MainMenuState;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the UpdateRestrictionsView class.
 */
public class UpdateRestrictionsViewTest {

    private UpdateRestrictionsView updateRestrictionsView;
    private UpdateRestrictionsViewModel updateRestrictionsViewModel;
    private UpdateRestrictionsInputBoundary updateRestrictionsInputBoundary;
    private UpdateRestrictionsController updateRestrictionController;
    private MainMenuController mainMenuController;
    private MainMenuViewModel mainMenuViewModel;
    private MainMenuInputBoundary mainMenuInputBoundary;
    private MainMenuState mainMenuState;
    /**
     * Sets up the test fixture.
     */
    @BeforeEach
    public void setUp() {
        updateRestrictionsViewModel = new UpdateRestrictionsViewModel();
        updateRestrictionsInputBoundary = new UpdateRestrictionsInputBoundary() {
            @Override
            public void execute(UpdateRestrictionsInputData updateRestrictionsInputData) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                currentState.setError("Test Error");
                updateRestrictionsViewModel.firePropertyChange();
            }
        };
        updateRestrictionController = new UpdateRestrictionsController(updateRestrictionsInputBoundary);
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

        updateRestrictionsView = new UpdateRestrictionsView(
                updateRestrictionController,
                updateRestrictionsViewModel,
                mainMenuController,
                mainMenuViewModel
        );
    }

    /**
     * Tests the initialization of the update restrictions view.
     */
    @Test
    public void testInitialViewState() {
        assertEquals("update restriction", updateRestrictionsView.viewName);
        assertNotNull(updateRestrictionsView.savemaxcals);
        assertNotNull(updateRestrictionsView.savemincals);
    }

    /**
     * Tests the change of the MaxCalsSpinner value.
     */
    @Test
    public void testMaxCalsSpinnerChangeListener() {
        // Simulate a change in the maxcalspinner value
        updateRestrictionsView.maxcalspinner.setValue(50.0);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(50.0f, currentState.getMaxcals());
    }

    /**
     * Tests the action of the save max calories button.
     */
    @Test
    public void testSaveMaxCalsButtonAction() {
        // Simulate pressing the save max calories button
        updateRestrictionsView.maxcalspinner.setValue(800f);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(800.0f, currentState.getMaxcals());
        updateRestrictionsView.savemaxcals.doClick();
        assertEquals(0.0f, updateRestrictionsView.maxcalspinner.getValue());
    }

    /**
     * Tests the change of the MinCalsSpinner value.
     */
    @Test
    public void testMinCalsSpinnerChangeListener() {
        // Simulate a change in the mincalspinner value
        updateRestrictionsView.mincalspinner.setValue(10.0);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMincals());
    }

    /**
     * Tests the action of the save min calories button.
     */
    @Test
    public void testSaveMinCalsButtonAction() {
        // Simulate pressing the save min calories button
        updateRestrictionsView.mincalspinner.setValue(10f);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMincals());
        updateRestrictionsView.savemincals.doClick();
        assertEquals(0.0f, updateRestrictionsView.mincalspinner.getValue());
    }

    /**
     * Tests the value change of the save max protein spinner.
     */
    @Test
    public void testMaxCarbsSpinnerChangeListener() {
        // Simulate a change in the max carbs value
        updateRestrictionsView.maxcarbspinner.setValue(10.0);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMaxcarbs());
    }

    /**
     * Tests the action of the save max carbs button.
     */
    @Test
    public void testSaveMaxCarbsButtonAction() {
        // Simulate pressing the save max carbs button
        updateRestrictionsView.maxcarbspinner.setValue(10f);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMaxcarbs());
        updateRestrictionsView.savemaxcarbs.doClick();
        assertEquals(0.0f, updateRestrictionsView.maxcarbspinner.getValue());
    }

    /**
     * Tests the value change of the save min carbs spinner.
     */
    @Test
    public void testMinCarbsSpinnerChangeListener() {
        // Simulate a change in the mincarbs value
        updateRestrictionsView.mincarbspinner.setValue(10.0);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMincarbs());
    }
    /**
     * Tests the action of the save min carbs button.
     */

    @Test
    public void testSaveMinCarbsButtonAction() {
        // Simulate pressing the save min carbs button
        updateRestrictionsView.mincarbspinner.setValue(10f);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMincarbs());
        updateRestrictionsView.savemincarbs.doClick();
        assertEquals(0.0f, updateRestrictionsView.mincarbspinner.getValue());
    }

    /**
     * Tests the value change of the save max protein spinner.
     */
    @Test
    public void testMaxProteinSpinnerChangeListener() {
        // Simulate a change in the max protein value
        updateRestrictionsView.maxproteinspinner.setValue(10.0);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMaxprotein());
    }
    /**
     * Tests the action of the save max protein button.
     */
    @Test
    public void testSaveMaxProteinButtonAction() {
        // Simulate pressing the save max protein button
        updateRestrictionsView.maxproteinspinner.setValue(10f);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMaxprotein());
        updateRestrictionsView.savemaxprotein.doClick();
        assertEquals(0.0f, updateRestrictionsView.maxproteinspinner.getValue());
    }

    /**
     * Tests the value change of the save min protein spinner.
     */
    @Test
    public void testMinProteinSpinnerChangeListener() {
        // Simulate a change in the min protein value
        updateRestrictionsView.minproteinspinner.setValue(10.0);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMinprotein());
    }

    /**
     * Tests the action of the save min protein button.
     */
    @Test
    public void testSaveMinProteinButtonAction() {
        // Simulate pressing the save min protein button
        updateRestrictionsView.minproteinspinner.setValue(10f);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMinprotein());
        updateRestrictionsView.saveminprotein.doClick();
        assertEquals(0.0f, updateRestrictionsView.minproteinspinner.getValue());
    }
    /**
     * Tests the value change of the save max fat spinner.
     */
    @Test
    public void testMaxFatSpinnerChangeListener() {
        // Simulate a change in the max fat value
        updateRestrictionsView.maxfatspinner.setValue(10.0);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMaxfat());
    }
    /**
     * Tests the action of the save max fat button.
     */
    @Test
    public void testsaveMaxFatButtonAction() {
        // Simulate pressing the save max fat button
        updateRestrictionsView.maxfatspinner.setValue(10f);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMaxfat());
        updateRestrictionsView.savemaxfats.doClick();
        assertEquals(0.0f, updateRestrictionsView.maxfatspinner.getValue());
    }
    /**
     * Tests the value change of the save min fat spinner.
     */
    @Test
    public void testMinFatSpinnerChangeListener() {
        // Simulate a change in the min fat value
        updateRestrictionsView.minfatspinner.setValue(10.0);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMinfat());
    }
    /**
     * Tests the action of the save min fat button.
     */
    @Test
    public void testSaveMinFatButtonAction() {
        // Simulate pressing the save min fat button
        updateRestrictionsView.minfatspinner.setValue(10f);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(10f, currentState.getMinfat());
        updateRestrictionsView.saveminfats.doClick();
        assertEquals(0.0f, updateRestrictionsView.minfatspinner.getValue());
    }

    /**
     * Tests the action of the keto diet checkbox.
     */
    @Test
    public void testKetogenicCheckBoxChangeListener() {
        // Simulate a change in the ketogenic checkbox value
        updateRestrictionsView.enableKeto.setSelected(true);
        updateRestrictionsView.enableKeto.setSelected(false);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(0.0f, currentState.getKeto());
    }

    /**
     * Tests the action of the vegan diet checkbox.
     */
    @Test
    public void testVeganCheckBoxChangeListener() {
        // Simulate a change in the vegan checkbox value
        updateRestrictionsView.enableVegan.setSelected(true);
        updateRestrictionsView.enableVegan.setSelected(false);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(0.0f, currentState.getVegan());
    }

    /**
     * Tests the action of the vegetarian diet checkbox.
     */
    @Test
    public void testVegetarianCheckBoxChangeListener() {
        // Simulate a change in the vegetarian checkbox value
        updateRestrictionsView.enableVegetarian.setSelected(true);
        updateRestrictionsView.enableVegetarian.setSelected(false);

        UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
        assertEquals(0.0f, currentState.getVegetarian());
    }

    /**
     * Tests the action of the return to mainmenu button.
     */
    @Test
    public void testBackButtonAction() {
        // Simulate pressing the back button
        updateRestrictionsView.main_menu.doClick();
        MainMenuState currentState = mainMenuViewModel.getState();
        assertEquals("main menu", currentState.getView_name());
    }

}
