package interface_adapter.get_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.List;

public class GetRecipeViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Get Recipe";
    public static final String GET_RECIPE_BUTTON_LABEL = "Generate Recipe";
    public static final String MAIN_MENU = "Main Menu";
    private GetRecipeState currState = new GetRecipeState();

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public GetRecipeViewModel() {
        super("Get Recipe");
    }

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
