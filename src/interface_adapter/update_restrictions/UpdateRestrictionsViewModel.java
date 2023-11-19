package interface_adapter.update_restrictions;

import interface_adapter.ViewModel;
import org.json.Property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.List;

public class UpdateRestrictionsViewModel extends ViewModel {

    public final String UPDATE_FOODITEM = "Enter Restricted Food";
    public final String UPDATE_MAXPROTEIN = "Enter Max Serving Protein Value";
    public final String UPDATE_MAXCARBS = "Enter Max Serving Carbs Value";
    public final String UPDATE_MAXFATS = "Enter Max Serving Fat Value";
    public final String UPDATE_MAXCals = "Enter Daily Calorie Maximum";
    public final String UPDATE_MINPROTEIN = "Enter Min Serving Protein Value";
    public final String UPDATE_MINCARBS = "Enter Min Serving Carbs Value";
    public final String UPDATE_MINFATS = "Enter Min Serving Fat Value";
    public final String UPDATE_MINCals = "Enter Daily Calorie Minimum";
    public final String KETO = "Keto Diet";
    public final String VEGAN = "Vegan Diet";
    public final String VEGETARIAN = "Vegetarian Diet";

    public static final String BACK = "Back";

    public static final String SAVE = "Save";
    private UpdateRestrictionsState currState = new UpdateRestrictionsState();

    public UpdateRestrictionsViewModel() {super("Update Dietary Restrictions");}
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void setState(UpdateRestrictionsState state) {this.currState = state;}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void firePropertyChange() {pcs.firePropertyChange("state", null, this.currState);}

    public UpdateRestrictionsState getCurrState() { return currState;}
}
