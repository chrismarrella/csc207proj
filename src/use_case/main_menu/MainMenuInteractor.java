package use_case.main_menu;

public class MainMenuInteractor implements MainMenuInputBoundary {
    final MainMenuOutputBoundary mainMenuPresenter;

    public MainMenuInteractor(MainMenuOutputBoundary mainMenuPresenter) {
        this.mainMenuPresenter = mainMenuPresenter;

    }

    @Override
    public void execute(String view_name) {
        mainMenuPresenter.prepareSwitchView(view_name);
    }
}