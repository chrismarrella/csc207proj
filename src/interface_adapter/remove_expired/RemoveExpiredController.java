package interface_adapter.remove_expired;

import use_case.remove_expired.RemoveExpiredInputBoundary;
import use_case.remove_expired.RemoveExpiredInputData;

import java.util.Calendar;

public class RemoveExpiredController {

    final RemoveExpiredInputBoundary removeExpiredInteractor;

    /**
     * This method creates the remove food item controller.
     * @param removeExpiredInteractor The interactor that will be used to remove expired items.
     */
    public RemoveExpiredController(RemoveExpiredInputBoundary removeExpiredInteractor) {
        this.removeExpiredInteractor = removeExpiredInteractor;
    }

    /**
     * This method executes the remove expired food item use case.
     * @param date The date to remove expired items from; current date.
     */
    public void execute(Calendar date) {
        RemoveExpiredInputData removeExpiredInputData = new RemoveExpiredInputData(date);
        removeExpiredInteractor.execute(removeExpiredInputData);
    }
}
