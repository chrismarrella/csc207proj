package interface_adapter.main_menu;

/**
 * This class represents the state for the main menu.
 */
public class MainMenuState {
    private String success = null;
    private String view_name = null;
    private String error = null;

    /**
     * Constructor for MainMenuState
     * @param copy the state to copy
     *
     */
    public MainMenuState(MainMenuState copy) {
        success = copy.success;
        view_name = copy.view_name;
        error = copy.error;
    }

    /**
     * Constructor for MainMenuState
     *
     */
    public MainMenuState() {
    }

    /**
     * Get the view name for the main menu
     * @return the view name for the main menu
     */
    public String getView_name() {
        return view_name;
    }

    /**
     * Set the view name for the main menu
     * @param view_name the view name for the main menu
     */
    public void setView_name(String view_name) {
        this.view_name = view_name;
    }

    /**
     * Get the error for the main menu
     * @return the error for the main menu
     */
    public String getError() {
        return error;
    }
}
