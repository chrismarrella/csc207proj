package use_case.removeExpired;

import java.util.Calendar;

public class RemoveExpiredInputData {
    final private Calendar date;

    public RemoveExpiredInputData(Calendar date) {
        this.date = date;
    }

    public Calendar getDate() {
        return date;
    }
}
