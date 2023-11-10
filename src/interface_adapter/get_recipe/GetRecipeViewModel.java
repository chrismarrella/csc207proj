package interface_adapter.get_recipe;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.List;

public class GetRecipeViewModel {
    private GetRecipeState curr_state = new GetRecipeState();

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void setState(GetRecipeState state) {
        this.curr_state = state;
    }
    public GetRecipeState getState() { return curr_state; }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void firePropertyChange() {
        pcs.firePropertyChange("GetRecipeState", null, curr_state);
    }

    public List<String> getRecipes() {
        return curr_state.getRecipes();
    }
}
