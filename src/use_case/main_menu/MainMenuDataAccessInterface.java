package use_case.main_menu;

import entities.User;

import java.util.List;

/**
 * This interface represents the data access interface for the main menu.
 */
public interface MainMenuDataAccessInterface {
    void save(User user);

    List<User> getAllUsers();
}
