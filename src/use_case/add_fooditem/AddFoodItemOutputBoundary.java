package use_case.add_fooditem;

public interface AddFoodItemOutputBoundary {
    void prepareSuccessView();
    void prepareFailView(String error);
}
