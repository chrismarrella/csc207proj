package interface_adapter.main_menu;

import use_case.main_menu.MainMenuInputBoundary;
import use_case.main_menu.MainMenuInputData;

/**
 * This class represents the controller for the main menu.
 */
public class MainMenuController {

    final MainMenuInputBoundary userMainMenuUseCaseInteractor;

    /**
     * Constructor for MainMenuController
     * @param userMainMenuUseCaseInteractor the interactor for the main menu
     *
     */
    public MainMenuController(MainMenuInputBoundary userMainMenuUseCaseInteractor) {
        this.userMainMenuUseCaseInteractor = userMainMenuUseCaseInteractor;
    }

    /**
     * Execute the interactor for the main menu
     * @param view_name the view to show
     */
    public void execute(String view_name) {
        userMainMenuUseCaseInteractor.execute(view_name);
    }
}
