package use_case.main_menu;

import entities.User;

import java.util.List;

public interface MainMenuDataAccessInterface {
    /**
     * This interface represents the data access interface for the main menu.
     */
    void save(User user);

    List<User> getAllUsers();
}
