package interface_adapter.main_menu;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.main_menu.MainMenuOutputBoundary;


/**
 * This class represents the presenter for the main menu.
 */
public class MainMenuPresenter implements MainMenuOutputBoundary {
    private final MainMenuViewModel mainMenuViewModel;

    private ViewManagerModel viewManagerModel;

    /**
     * Constructor for MainMenuPresenter
     * @param viewManagerModel the view manager model for the main menu
     * @param mainMenuViewModel the view model for the main menu
     *
     * @return a MainMenuPresenter object
     */
    public MainMenuPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }

    /**
     * Prepare the view for the main menu
     * @param view_name the view to show
     */
    @Override
    public void prepareSwitchView(String view_name) {
        // On success, switch to the view.
        viewManagerModel.setActiveView(view_name);
        viewManagerModel.firePropertyChange();

    }

}
