package interface_adapter.get_recipe;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetRecipeViewModel {
    private GetRecipeState curr_state = new GetRecipeState();

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void setCurr_state(GetRecipeState state) {
        curr_state = state;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }
}
