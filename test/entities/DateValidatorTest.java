package entities;

import org.junit.jupiter.api.Test;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

public class DateValidatorTest implements DateValidator{
    @Override
    public boolean dateIsValid(Integer year, Integer month, Integer day) {
        DateValidatorService dateValidatorService = new DateValidatorService();
        return dateValidatorService.dateIsValid(year, month, day);
    }

    @Test
    public void TestDateIsValid() {
        assertTrue(dateIsValid(2023, 12, 31));
    }

    @Test
    public void TestDateIsInvalidDueToPastYear() {
        assertFalse(dateIsValid(2020, 12, 31));
    }

    @Test
    public void TestDateIsInvalidDueToLeapYear() {
        assertFalse(dateIsValid(2025, 2, 29));
        assertTrue(dateIsValid(2024, 2, 29));
        assertFalse(dateIsValid(2024, 2, 30));
    }

    @Test
    public void TestDateIsInvalidDueToMonthandDay() {
        assertFalse(dateIsValid(2024, 4, 31));
        assertTrue(dateIsValid(2024, 4, 30));
        assertTrue(dateIsValid(22024,3,31));
    }
}
