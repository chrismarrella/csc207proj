package entities;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * The class for the date validator.
 * This class is used to validate the inputs of the expiry date.
 */
public class DateValidatorService implements DateValidator{

    /**
     * Validates the inputs of the expiry date. Note that the method checks for leap years and handles
     * the months that only have 30 days. It also checks if the expiry date is before the current date.
     * @param year    the year of the expiry date
     * @param month    the month of the expiry date
     * @param day    the day of the expiry date
     * @return true if the expiry date is valid, false otherwise
     */
    @Override
    public boolean dateIsValid(Integer year, Integer month, Integer day) {
        if (year % 4 == 0) {
            if (month == 2) {
                if (day > 29) {
                    return false;
                }
            }
        } else {
            if (month == 2) {
                if (day > 28) {
                    return false;
                }
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11 ) {
                if (day > 30) {
                    return false;
                }
            }

        Calendar itemExpDate = Calendar.getInstance();
        itemExpDate.set(Calendar.YEAR, year);
        itemExpDate.set(Calendar.MONTH, month - 1);
        itemExpDate.set(Calendar.DAY_OF_MONTH, day);

        return (itemExpDate.compareTo(Calendar.getInstance()) >= 0);
    }

}
