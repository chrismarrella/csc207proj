package interface_adapter.add_fooditem;

import interface_adapter.add_fooditem.AddFoodItemViewModel;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddFoodItemPresenterTest {
    private AddFoodItemViewModel addFoodItemViewModel;
    private AddFoodItemPresenter addFoodItemPresenter;
    @BeforeEach
    void setUp() {
        addFoodItemViewModel = new AddFoodItemViewModel();
        addFoodItemPresenter = new AddFoodItemPresenter(addFoodItemViewModel);
    }

    @Test
    public void TestSuccessView() {
        addFoodItemPresenter.prepareSuccessView();
        assertNull(addFoodItemViewModel.getState().getIngredientError());
        assertNull(addFoodItemViewModel.getState().getAmountError());
        assertNull(addFoodItemViewModel.getState().getDateError());
    }

    @Test
    public void TestFailView() {
        addFoodItemPresenter.prepareFailView("Ingredient is invalid!");
        assertEquals("Ingredient is invalid!", addFoodItemViewModel.getState().getIngredientError());
        addFoodItemPresenter.prepareFailView("Invalid Date!");
        assertEquals("Invalid Date!", addFoodItemViewModel.getState().getDateError());
        addFoodItemPresenter.prepareFailView("Invalid Amount!");
        assertEquals("Invalid Amount!", addFoodItemViewModel.getState().getAmountError());
    }
}
