package interface_adapter.update_restrictions;

import interface_adapter.get_recipe.ViewModel;
import org.json.Property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.List;

public class UpdateRestrictionsViewModel extends ViewModel {

    public final String UPDATE_FOODITEM = "Enter Restricted Food";
    public final String UPDATE_PROTEIN = "Enter Protein Value";
    public final String UPDATE_CARBS = "Enter Carbs Value";
    public final String UPDATE_FATS = "Enter Fat Value";
    public final String UPDATE_Cals = "Enter Daily Calorie Restriction";

    public static final String SAVE = "Save";
    private UpdateRestrictionsState currState = new UpdateRestrictionsState();

    public UpdateRestrictionsViewModel() {super("update dietary restrictions");}
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void setState(UpdateRestrictionsState state) {this.currState = state;}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void firePropertyChange() {pcs.firePropertyChange("state", null, this.currState);}

    public UpdateRestrictionsState getCurrState() { return currState;}
}
