package use_case.main_menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test class for the MainMenuOutputData.
 */
class MainMenuOutputDataTest {

    /**
     * Tests the constructor for the MainMenuOutputData.
     */
    @Test
    void MainMenuOutputDataConstructorTest() {
        String testviewname = "main menu";

        MainMenuOutputData outputData = new MainMenuOutputData(testviewname);

        assertEquals(testviewname, outputData.view_name());
    }
}
