package use_case.remove_expired;

import java.util.Calendar;

public class RemoveExpiredInputData {
    final private Calendar date;

    /**
     * This constructor creates a new RemoveExpiredInputData object.
     * @param date Current date that is compared to the expiration date of the food items.
     */
    public RemoveExpiredInputData(Calendar date) {
        this.date = date;
    }

    /**
     * This method gets the current date.
     * @return The current date.
     */
    public Calendar getDate() {
        return date;
    }
}
