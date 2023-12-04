package interface_adapter.main_menu;

import interface_adapter.main_menu.MainMenuViewModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainMenuViewModelTest {

    @Test
    public void testSetAndGetState() {
        MainMenuViewModel viewModel = new MainMenuViewModel();
        MainMenuState newState = new MainMenuState();

        viewModel.setState(newState);
        assertEquals(newState, viewModel.getState());
    }
}
