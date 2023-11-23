package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.update_restrictions.UpdateRestrictionsViewModel;
import use_case.main_menu.MainMenuInteractor;
import interface_adapter.main_menu.MainMenuViewModel;
import app.MainMenuUseCaseFactory;

import use_case.main_menu.MainMenuInputBoundary;
import view.GetRecipeView;
import view.MainMenuView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("CHEFFI");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int width = 400;
        int height = 400;
        application.setSize(width, height);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        UpdateRestrictionsViewModel updateRestrictionsViewModel = new UpdateRestrictionsViewModel();
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
        GetRecipeViewModel getrecipeViewModel = new GetRecipeViewModel();

        MainMenuView mainMenuView = MainMenuUseCaseFactory.create(viewManagerModel, mainMenuViewModel, getrecipeViewModel);
        views.add(mainMenuView, mainMenuView.viewName);


        GetRecipeView getRecipeView = new GetRecipeView(viewManagerModel, getrecipeViewModel);
        views.add(getRecipeView, getRecipeView.viewName);


        viewManagerModel.setActiveView(mainMenuView.viewName);
        viewManagerModel.firePropertyChange();

        application.pack();
        application.setVisible(true);
    }
}
