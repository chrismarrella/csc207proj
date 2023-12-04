package app;

import data_access.FileUserDataAccessObject;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.delete_fooditem.DeleteFoodItemViewModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.get_shopping_list.GetShoppingListViewModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.add_fooditem.AddFoodItemViewModel;
import interface_adapter.update_restrictions.UpdateRestrictionsViewModel;
import interface_adapter.remove_expired.RemoveExpiredViewModel;
import interface_adapter.main_menu.MainMenuViewModel;

import view.DeleteFoodItemView;
import view.GetRecipeView;
import view.MainMenuView;
import view.UpdateRestrictionsView;
import view.AddFoodItemView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    /**
     * Main method that runs the application.
     * @param args String[] args is the array of strings representing command-line arguments.
     * @throws IOException FileUserDataAccessObject may involve file operations that can result in an IOException
     */
    public static void main(String[] args) throws IOException {

        JFrame application = new JFrame("CHEFFI");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int width = 1920;
        int height = 400;
        application.setSize(width, height);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        UpdateRestrictionsViewModel updateRestrictionsViewModel = new UpdateRestrictionsViewModel();
        GetRecipeViewModel getrecipeViewModel = new GetRecipeViewModel();
        GetShoppingListViewModel getShoppingListViewModel = new GetShoppingListViewModel();
        AddFoodItemViewModel addFoodItemViewModel = new AddFoodItemViewModel();
        DeleteFoodItemViewModel deleteFoodItemViewModel = new DeleteFoodItemViewModel();
        RemoveExpiredViewModel removeExpiredViewModel = new RemoveExpiredViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new UserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MainMenuController mainMenuController = MainMenuUseCaseFactory.createMainMenuUseCase(viewManagerModel, mainMenuViewModel, userDataAccessObject, new UserFactory());
        MainMenuView mainMenuView = MainMenuUseCaseFactory.create(viewManagerModel,
                mainMenuViewModel, userDataAccessObject, new UserFactory(), removeExpiredViewModel);
        views.add(mainMenuView, mainMenuView.viewName);

        UpdateRestrictionsView updateRestrictionsView = UpdateRestrictionsUseCaseFactory.create(viewManagerModel, updateRestrictionsViewModel, userDataAccessObject, mainMenuController, mainMenuViewModel);
        views.add(updateRestrictionsView, updateRestrictionsView.viewName);

        GetRecipeView getRecipeView = GetRecipeUseCaseFactory.create(viewManagerModel, getrecipeViewModel, userDataAccessObject, getShoppingListViewModel, userDataAccessObject, mainMenuController, mainMenuViewModel);
        views.add(getRecipeView, getRecipeView.viewName);

        DeleteFoodItemView deleteFoodItemView = DeleteFoodItemUseCaseFactory.create(viewManagerModel,
                deleteFoodItemViewModel, mainMenuViewModel, mainMenuController, userDataAccessObject);
        views.add(deleteFoodItemView, deleteFoodItemView.viewName);

        AddFoodItemView addFoodItemView = AddFoodItemUseCaseFactory.create(viewManagerModel, addFoodItemViewModel, mainMenuViewModel, mainMenuController, userDataAccessObject);
        views.add(addFoodItemView, addFoodItemView.viewName);

        viewManagerModel.setActiveView(mainMenuView.viewName);
        viewManagerModel.firePropertyChange();

        application.setVisible(true);
    }
}
