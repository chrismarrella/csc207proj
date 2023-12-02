package interface_adapter.update_restrictions;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class UpdateRestrictionsViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Update Your Dietary Restrictions";
    public static final String UPDATE_MAXPROTEIN = "Enter Max Serving Protein Value";
    public static final String UPDATE_MAXCARBS = "Enter Max Serving Carbs Value";
    public static final String UPDATE_MAXFATS = "Enter Max Serving Fat Value";
    public static final String UPDATE_MAXCals = "Enter Daily Calorie Maximum";
    public static final String UPDATE_MINPROTEIN = "Enter Min Serving Protein Value";
    public static final String UPDATE_MINCARBS = "Enter Min Serving Carbs Value";
    public static final String UPDATE_MINFATS = "Enter Min Serving Fat Value";
    public static final String UPDATE_MINCals = "Enter Daily Calorie Minimum";
    public static final String KETO = "Keto Diet";
    public static final String VEGAN = "Vegan Diet";
    public static final String VEGETARIAN = "Vegetarian Diet";
    public static final String MAINMENU = "Save All and return to Main Menu";
    public static final String SAVE = "Save Restricted Food Item";
    public static final String SET = "Set";
    public static final Float TRUE = 1.0f;
    public static final Float FALSE = 0.0f;
    private UpdateRestrictionsState currState = new UpdateRestrictionsState();

    public UpdateRestrictionsViewModel() {super("Update Dietary Restrictions");}
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void setState(UpdateRestrictionsState state) {this.currState = state;}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void firePropertyChange() {pcs.firePropertyChange("state", null, this.currState);}

    public UpdateRestrictionsState getCurrState() {
        return currState;}
}
