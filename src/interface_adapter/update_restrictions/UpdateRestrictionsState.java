package interface_adapter.update_restrictions;

import java.util.ArrayList;
import java.util.List;

public class UpdateRestrictionsState {
    private String restriction = null;
    private Float value = null;
    private String error = null;
    private String success = null;
    private String view_name = null;


    public UpdateRestrictionsState(UpdateRestrictionsState copy) {
        restriction = copy.restriction;
        value = copy.value;
        error = copy.error;
        success = copy.success;
        view_name = copy.view_name;
    }

    public UpdateRestrictionsState() {

    }
    public String getRestriction() {return restriction;}
    public void setRestriction(String restriction) {this.restriction = restriction;}

    public Float getValue() {return value;}
    public void setValue (Float value)  {this.value = value;}

    public String getError() {return error;}

    public void setError(String error) {this.error = error;}

    public String getSuccess() { return success; }

    public void setSuccess(String success) { this.success = success; }

    public void setView_name(String getRecipe) { this.view_name = view_name; }
    public String getView_name() { return view_name;}
}
