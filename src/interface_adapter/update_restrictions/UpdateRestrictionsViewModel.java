package interface_adapter.update_restrictions;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class UpdateRestrictionsViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Update Your Dietary Restrictions";
    public static final String UPDATE_MAXPROTEIN = "Enter Max Serving Protein Value";
    public static final String UPDATE_MAXCARBS = "Enter Max Serving Carbs Value";
    public static final String UPDATE_MAXFATS = "Enter Max Serving Fat Value";
    public static final String UPDATE_MAXCals = "Enter Calorie Maximum";
    public static final String UPDATE_MINPROTEIN = "Enter Min Serving Protein Value";
    public static final String UPDATE_MINCARBS = "Enter Min Serving Carbs Value";
    public static final String UPDATE_MINFATS = "Enter Min Serving Fat Value";
    public static final String UPDATE_MINCals = "Enter Calorie Minimum";
    public static final String KETO = "Keto Diet";
    public static final String VEGAN = "Vegan Diet";
    public static final String VEGETARIAN = "Vegetarian Diet";
    public static final String MAINMENU = "Save All and return to Main Menu";
    public static final String SAVE = "Save Restricted Food Item";
    public static final String SET = "Set";
    public static final Float TRUE = 1.0f;
    public static final Float FALSE = 0.0f;
    private UpdateRestrictionsState currState = new UpdateRestrictionsState();

    /**
     * Initializes the Constructor for UpdateRestrictionsViewModel.
     */
    public UpdateRestrictionsViewModel() {super("Update Dietary Restrictions");}
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * Sets the state.
     * @param state The UpdateRestrictionsState instance.
     */
    public void setState(UpdateRestrictionsState state) {this.currState = state;}

    /**
     * Adds a property change listener.
     * @param listener The PropertyChangeListener instance.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    /**
     * Fires a property change.
     */
    public void firePropertyChange() {pcs.firePropertyChange("state", null, this.currState);}

    /**
     * Gets the current state.
     * @return The current state.
     */
    public UpdateRestrictionsState getCurrState() {
        return currState;}
}
