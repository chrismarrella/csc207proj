package interface_adapter.main_menu;

import use_case.main_menu.MainMenuInputBoundary;
import use_case.main_menu.MainMenuInputData;

public class MainMenuController {
    /**
     * This class represents the controller for the main menu.
     */

    final MainMenuInputBoundary userMainMenuUseCaseInteractor;
    public MainMenuController(MainMenuInputBoundary userMainMenuUseCaseInteractor) {
        /**
         * Constructor for MainMenuController
         * @param userMainMenuUseCaseInteractor the interactor for the main menu
         *
         * @return a MainMenuController object
         */
        this.userMainMenuUseCaseInteractor = userMainMenuUseCaseInteractor;
    }

    public void execute(String view_name) {
        /**
         * Execute the interactor for the main menu
         * @param view_name the view to show
         */
        userMainMenuUseCaseInteractor.execute(view_name);
    }
}
