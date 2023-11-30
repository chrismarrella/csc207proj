package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeController;
import interface_adapter.get_recipe.GetRecipePresenter;
import interface_adapter.get_recipe.GetRecipeViewModel;
import interface_adapter.main_menu.MainMenuController;
import use_case.get_recipe.GetRecipeDataAccessInterface;
import use_case.get_recipe.GetRecipeInputBoundary;
import use_case.get_recipe.GetRecipeInteractor;
import use_case.get_recipe.GetRecipeOutputBoundary;
import view.GetRecipeView;

import javax.swing.*;
import java.io.IOException;

public class GetRecipeUseCaseFactory {

    private GetRecipeUseCaseFactory() {}

    public static GetRecipeView create(ViewManagerModel viewManagerModel,
                                       GetRecipeViewModel getRecipeViewModel,
                                       GetRecipeDataAccessInterface getRecipeDataAccessInterface) {
        try {
            GetRecipeController getRecipeController = createGetRecipeUseCase(getRecipeViewModel, getRecipeDataAccessInterface);
            return new GetRecipeView(viewManagerModel, getRecipeViewModel, getRecipeController);
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

}
