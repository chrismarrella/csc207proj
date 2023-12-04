package interface_adapter.main_menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuStateTest {

    @Test
    public void testDefaultConstructor() {
        MainMenuState state = new MainMenuState();
        assertNull(state.getView_name());
        assertNull(state.getError());
    }

    @Test
    public void testCopyConstructor() {
        MainMenuState originalState = new MainMenuState();
        originalState.setView_name("Get Recipe");

        MainMenuState copyState = new MainMenuState(originalState);

        assertEquals(originalState.getView_name(), copyState.getView_name());
        assertEquals(originalState.getError(), copyState.getError());

    }
}