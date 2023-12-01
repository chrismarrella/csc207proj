package entities;

import java.util.ArrayList;

public class DateValidatorService implements DateValidator{
    @Override
    public boolean dateIsValid(Integer year, Integer month, Integer day) {
        ArrayList<Integer> leapYear = new ArrayList<>();
        leapYear.add(2024);
        leapYear.add(2028);
        leapYear.add(2032);
        leapYear.add(2036);
        leapYear.add(2040);
        leapYear.add(2044);
        leapYear.add(2048);
        if (leapYear.contains(year)) {
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
        if (month == 4 || month == 6 || month == 9 || month == 11 ) {
                if (day > 30) {
                    return false;
                }
            }
        }
        return true;
    }
}
