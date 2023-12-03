package use_case.main_menu;

public class MainMenuInputData {
    /**
     * This class represents the input data for the main menu.
     */
    final private String view_name;

    public MainMenuInputData(String view_name) {
        this.view_name = view_name;
    }

    public String getViewName() {
        return view_name;
    }
}
