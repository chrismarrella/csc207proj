package use_case.main_menu;

public class MainMenuOutputData {
    /**
     * This class represents the output data for the main menu.
     */
    private String view_name;

    public MainMenuOutputData(String view_name) {
        /**
         * This constructor instantiates a new main menu output data.
         * @param view_name The view name.
         */
        this.view_name = view_name;
    }

    public String view_name() {
        /**
         * This method returns the view name.
         */
        return view_name;
    }
}


