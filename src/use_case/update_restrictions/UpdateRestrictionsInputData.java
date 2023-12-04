package use_case.update_restrictions;

/**
 * The UpdateRestrictionsInputBoundary interface allows the UpdateRestrictionsController to execute the update
 * restrictions use case.
 */
public class UpdateRestrictionsInputData {
    final private String restriction;
    final private Float value;

    /**
     * Constructor for UpdateRestrictionsInputData.
     * @param restriction The dietary restriction.
     * @param value The amount of that restriction in a float or 1.0 for true or 0.0 for false.
     */
    public UpdateRestrictionsInputData(String restriction, Float value) {
        this.restriction = restriction;
        this.value = value;
    }
    /**
     * Gets the restriction.
     * @return The restriction.
     */
    public String getRestriction() {
        return restriction;
    }
    /**
     * Gets the value.
     * @return The value.
     */
    public Float getValue() {
        return value;
    }

}