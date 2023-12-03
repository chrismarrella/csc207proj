package use_case.main_menu;

import entities.User;
import entities.UserFactory;

import java.util.HashMap;

public class MainMenuInteractor implements MainMenuInputBoundary {
    /**
     * This class represents the interactor for the main menu.
     */
    final MainMenuOutputBoundary mainMenuPresenter;

    final MainMenuDataAccessInterface userDataAccessObject;

    final UserFactory userFactory;

    public MainMenuInteractor(MainMenuOutputBoundary mainMenuPresenter,
                              MainMenuDataAccessInterface userDataAccessObject,
                              UserFactory userFactory) {
        /**
         * This constructor instantiates a new MainMenuInteractor object.
         * @param mainMenuPresenter The presenter for the main menu.
         * @param userDataAccessObject The data access object for the main menu.
         * @param userFactory The factory for the user.
         */
        this.mainMenuPresenter = mainMenuPresenter;
        this.userDataAccessObject = userDataAccessObject;
        this.userFactory = userFactory;

    }
    @Override
    public void execute(String view_name) {
        /**
         * This method executes the interactor for the main menu.
         * @param view_name The name of the view.
         */
        if (userDataAccessObject.getAllUsers().isEmpty()) {
            User user = userFactory.create(new HashMap<>());
            user.addRestriction("minCarbs", 10F);
            user.addRestriction("maxCarbs", 100F);
            user.addRestriction("minProtein", 10F);
            user.addRestriction("maxProtein", 100F);
            user.addRestriction("minCalories", 50F);
            user.addRestriction("maxCalories", 800F);
            user.addRestriction("minSaturatedFat", 0F);
            user.addRestriction("maxSaturatedFat", 100F);

            userDataAccessObject.save(user);
        }

        mainMenuPresenter.prepareSwitchView(view_name);
    }
}