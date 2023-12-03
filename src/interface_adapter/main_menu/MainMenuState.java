package interface_adapter.main_menu;

public class MainMenuState {
    /**
     * This class represents the state for the main menu.
     */
    private String success = null;
    private String view_name = null;
    private String error = null;

    public MainMenuState(MainMenuState copy) {
        /**
         * Constructor for MainMenuState
         * @param copy the state to copy
         *
         * @return a MainMenuState object
         */
        success = copy.success;
        view_name = copy.view_name;
        error = copy.error;
    }

    public MainMenuState() {
        /**
         * Constructor for MainMenuState
         *
         * @return a MainMenuState object
         */
    }
    public String getView_name() {
        /**
         * Get the view name for the main menu
         * @return the view name for the main menu
         */
        return view_name;
    }
    public void setView_name(String view_name) {
        /**
         * Set the view name for the main menu
         * @param view_name the view name for the main menu
         */
        this.view_name = view_name;
    }
    public String getError() {
        /**
         * Get the error for the main menu
         * @return the error for the main menu
         */
        return error;
    }
}
