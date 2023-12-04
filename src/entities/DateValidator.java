package entities;

/**
 * The interface for the date validator.
 * This interface is used to validate the inputs of the expiry date.
 */
public interface DateValidator {
    public boolean dateIsValid(Integer year, Integer month, Integer day);
}
