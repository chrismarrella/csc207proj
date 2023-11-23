package interface_adapter.main_menu;

public class MainMenuState {
    private String success = null;
    private String view_name = null;
    private String error = null;

    public MainMenuState(MainMenuState copy) {
        success = copy.success;
        view_name = copy.view_name;
        error = copy.error;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public MainMenuState() {}
    public String getView_name() {return view_name;}
    public void setView_name(String view_name) {this.view_name = view_name; }
    public String getError() { return error;}
}
