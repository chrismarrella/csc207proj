package interface_adapter.main_menu;

import use_case.main_menu.MainMenuInputBoundary;
import use_case.main_menu.MainMenuInputData;

public class MainMenuController {

    final MainMenuInputBoundary userMainMenuUseCaseInteractor;
    public MainMenuController(MainMenuInputBoundary userMainMenuUseCaseInteractor) {
        this.userMainMenuUseCaseInteractor = userMainMenuUseCaseInteractor;
    }

    public void execute(String view_name) {

        userMainMenuUseCaseInteractor.execute(view_name);
    }
}
