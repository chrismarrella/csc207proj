package use_case.main_menu;

/**
 * This class represents the output data for the main menu.
 */
public class MainMenuOutputData {
    private String view_name;

    /**
     * This constructor instantiates a new main menu output data.
     * @param view_name The view name.
     */
    public MainMenuOutputData(String view_name) {
        this.view_name = view_name;
    }

    /**
     * This method returns the view name.
     */
    public String view_name() {
        return view_name;
    }
}


