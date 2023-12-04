package interface_adapter.update_restrictions;

import interface_adapter.update_restrictions.UpdateRestrictionsViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateRestrictionsPresenterTest {
    private ViewManagerModel viewManagerModel;
    private UpdateRestrictionsPresenter updateRestrictionsPresenter;
    private UpdateRestrictionsViewModel updateRestrictionsViewModel;
    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel();
        updateRestrictionsViewModel = new UpdateRestrictionsViewModel();
        updateRestrictionsPresenter = new UpdateRestrictionsPresenter(updateRestrictionsViewModel, viewManagerModel);
    }

    @Test
    void TestPrepareUpdatedView() {
        updateRestrictionsPresenter.prepareUpdatedView("Successfully Updated restriction: " + "MaxCalories");
        assertNull(updateRestrictionsViewModel.getCurrState().getError());
    }

    @Test
    void TestPrepareFailView() {
        updateRestrictionsPresenter.prepareFailView("Error");
        assertEquals("Error", updateRestrictionsViewModel.getCurrState().getError());
    }

    @Test
    void TestPrepareCheckedView() {
        updateRestrictionsPresenter.prepareCheckedView("Successfully Updated restriction: " + "MaxCalories");
        assertNull(updateRestrictionsViewModel.getCurrState().getError());
    }
}