package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import view.GetRecipeView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("CHEFFI");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int width = 800;
        int height = 600;
        application.setSize(width, height);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        GetRecipeViewModel getrecipeViewModel = new GetRecipeViewModel();

        GetRecipeView getRecipeView = new GetRecipeView(getrecipeViewModel);
        views.add(getRecipeView, getRecipeView.viewName);

        viewManagerModel.setActiveView(getRecipeView.viewName);
        viewManagerModel.firePropertyChange();

        application.setVisible(true);
    }
}