package interface_adapter.removeExpired;

import use_case.removeExpired.RemoveExpiredInputBoundary;
import use_case.removeExpired.RemoveExpiredInputData;

import java.util.Calendar;

public class RemoveExpiredController {

    final RemoveExpiredInputBoundary removeExpiredInteractor;

    public RemoveExpiredController(RemoveExpiredInputBoundary removeExpiredInteractor) {
        this.removeExpiredInteractor = removeExpiredInteractor;
    }

    public void execute(Calendar date) {
        RemoveExpiredInputData removeExpiredInputData = new RemoveExpiredInputData(date);
        removeExpiredInteractor.execute(removeExpiredInputData);
    }
}
