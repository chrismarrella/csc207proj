package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipePresenter;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuViewModel;
import use_case.get_recipe.GetRecipeDataAccessInterface;
import use_case.get_recipe.GetRecipeInputBoundary;
import use_case.get_recipe.GetRecipeInteractor;
import use_case.get_recipe.GetRecipeOutputBoundary;
import view.GetRecipeView;

import use_case.get_shopping_list.*;
import interface_adapter.get_shopping_list.GetShoppingListController;
import interface_adapter.get_shopping_list.GetShoppingListPresenter;
import interface_adapter.get_shopping_list.GetShoppingListViewModel;
import use_case.get_shopping_list.GetShoppingListDataAccessInterface;


import javax.swing.*;
import java.io.IOException;

public class GetRecipeUseCaseFactory {

    private GetRecipeUseCaseFactory() {}

    public static GetRecipeView create(ViewManagerModel viewManagerModel,
                                       GetRecipeViewModel getRecipeViewModel,
                                       GetRecipeDataAccessInterface getRecipeDataAccessInterface,
                                       GetShoppingListViewModel getShoppingListViewModel,
                                       GetShoppingListDataAccessInterface getShoppingListDataAccessInterface,
                                       MainMenuController mainMenuController,
                                       MainMenuViewModel mainMenuViewModel) {
        try {
            GetRecipeController getRecipeController = createGetRecipeUseCase(getRecipeViewModel, getRecipeDataAccessInterface);
            GetShoppingListController getShoppingListController = createGetShoppingListUseCase(getShoppingListViewModel, getShoppingListDataAccessInterface);
            return new GetRecipeView(viewManagerModel, getRecipeViewModel, getRecipeController, getShoppingListViewModel, getShoppingListController, mainMenuViewModel, mainMenuController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not create recipes.");
        }

        return null;
    }

    private static GetRecipeController createGetRecipeUseCase(GetRecipeViewModel getRecipeViewModel,
                                                              GetRecipeDataAccessInterface getRecipeDataAccessInterface) throws IOException {
        GetRecipeOutputBoundary getRecipeOutputBoundary = new GetRecipePresenter(getRecipeViewModel);

        GetRecipeInputBoundary getRecipeInteractor = new GetRecipeInteractor(getRecipeDataAccessInterface, getRecipeOutputBoundary);

        return new GetRecipeController(getRecipeInteractor);

    }

    private static GetShoppingListController createGetShoppingListUseCase(GetShoppingListViewModel getShoppingListViewModel,
                                                                          GetShoppingListDataAccessInterface getShoppingListDataAccessInterface) throws IOException {
        GetShoppingListOutputBoundary getShoppingListPresenter = new GetShoppingListPresenter(getShoppingListViewModel);

        GetShoppingListInputBoundary getShoppingListInteractor = new GetShoppingListInteractor(getShoppingListPresenter, getShoppingListDataAccessInterface);

        return new GetShoppingListController(getShoppingListInteractor);
    }

}
