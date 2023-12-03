package use_case.removeExpired;

import use_case.delete_foodItem.DeleteFoodItemInputData;

import java.util.Calendar;

public interface RemoveExpiredInputBoundary {
    void execute(RemoveExpiredInputData removeExpiredInputData);
}
