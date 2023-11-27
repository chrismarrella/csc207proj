package app;

import data_access.FileUserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.update_restrictions.UpdateRestrictionsViewModel;
import use_case.main_menu.MainMenuInteractor;
import interface_adapter.main_menu.MainMenuViewModel;
import app.MainMenuUseCaseFactory;
import entities.*;

import use_case.main_menu.MainMenuInputBoundary;
import view.GetRecipeView;
import view.MainMenuView;
import view.UpdateRestrictionsView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("CHEFFI");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int width = 1920;
        int height = 500;
        application.setSize(width, height);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new UserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UpdateRestrictionsViewModel updateRestrictionsViewModel = new UpdateRestrictionsViewModel();
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
        GetRecipeViewModel getrecipeViewModel = new GetRecipeViewModel();

        MainMenuView mainMenuView = MainMenuUseCaseFactory.create(viewManagerModel, mainMenuViewModel, getrecipeViewModel);
        views.add(mainMenuView, mainMenuView.viewName);

        UpdateRestrictionsView updateRestrictionsView = UpdateRestrictionsUseCaseFactory.create(viewManagerModel, updateRestrictionsViewModel, userDataAccessObject);
        views.add(updateRestrictionsView, updateRestrictionsView.viewName);


        GetRecipeView getRecipeView = new GetRecipeView(viewManagerModel, getrecipeViewModel);
        views.add(getRecipeView, getRecipeView.viewName);


        viewManagerModel.setActiveView(mainMenuView.viewName);
        viewManagerModel.firePropertyChange();

        application.setVisible(true);
    }
}
