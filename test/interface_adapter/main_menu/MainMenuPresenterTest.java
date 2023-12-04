package interface_adapter.main_menu;

import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainMenuPresenterTest {

    private ViewManagerModel viewManagerModel;
    private MainMenuPresenter mainMenuPresenter;
    private MainMenuViewModel mainMenuViewModel;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel();
        mainMenuViewModel = new MainMenuViewModel();
        mainMenuPresenter = new MainMenuPresenter(viewManagerModel, mainMenuViewModel);
    }

    @Test
    void TestPrepareSwitchView() {
        mainMenuPresenter.prepareSwitchView("GetRecipe");
        assertEquals("GetRecipe", viewManagerModel.getActiveView());
    }

}