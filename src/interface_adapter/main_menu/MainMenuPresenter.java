package interface_adapter.main_menu;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.main_menu.MainMenuOutputBoundary;


public class MainMenuPresenter implements MainMenuOutputBoundary {
    private final MainMenuViewModel mainMenuViewModel;

    private ViewManagerModel viewManagerModel;

    public MainMenuPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }
    @Override
    public void prepareSwitchView(String view_name) {
        // On success, switch to the view.
        viewManagerModel.setActiveView(view_name);
        viewManagerModel.firePropertyChange();

    }

}
