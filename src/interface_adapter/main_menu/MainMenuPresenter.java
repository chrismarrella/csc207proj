package interface_adapter.main_menu;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_recipe.GetRecipeViewModel;
import use_case.main_menu.MainMenuOutputBoundary;


public class MainMenuPresenter implements MainMenuOutputBoundary {
    /**
     * This class represents the presenter for the main menu.
     */
    private final MainMenuViewModel mainMenuViewModel;

    private ViewManagerModel viewManagerModel;

    public MainMenuPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        /**
         * Constructor for MainMenuPresenter
         * @param viewManagerModel the view manager model for the main menu
         * @param mainMenuViewModel the view model for the main menu
         *
         * @return a MainMenuPresenter object
         */
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }
    @Override
    public void prepareSwitchView(String view_name) {
        /**
         * Prepare the view for the main menu
         * @param view_name the view to show
         */
        // On success, switch to the view.
        viewManagerModel.setActiveView(view_name);
        viewManagerModel.firePropertyChange();

    }

}
