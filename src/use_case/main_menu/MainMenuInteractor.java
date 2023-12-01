package use_case.main_menu;

import entities.User;
import entities.UserFactory;

import java.util.HashMap;

public class MainMenuInteractor implements MainMenuInputBoundary {
    final MainMenuOutputBoundary mainMenuPresenter;

    final MainMenuDataAccessInterface userDataAccessObject;

    final UserFactory userFactory;

    public MainMenuInteractor(MainMenuOutputBoundary mainMenuPresenter,
                              MainMenuDataAccessInterface userDataAccessObject,
                              UserFactory userFactory) {
        this.mainMenuPresenter = mainMenuPresenter;
        this.userDataAccessObject = userDataAccessObject;
        this.userFactory = userFactory;

    }
    @Override
    public void execute(String view_name) {
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