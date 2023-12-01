package use_case.main_menu;

import entities.User;

import java.util.List;

public interface MainMenuDataAccessInterface {
    void save(User user);

    List<User> getAllUsers();
}
