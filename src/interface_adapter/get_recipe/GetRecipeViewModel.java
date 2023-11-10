package interface_adapter.get_recipe;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.List;

public class GetRecipeViewModel {
    private GetRecipeState currState = new GetRecipeState();

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void setState(GetRecipeState state) {
        this.currState = state;
    }
    public GetRecipeState getState() { return currState; }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void firePropertyChange() {
        pcs.firePropertyChange("state", null, currState);
    }

    public List<String> getRecipes() {
        return currState.getRecipes();
    }
}
