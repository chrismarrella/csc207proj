package use_case.update_restrictions;


public class UpdateRestrictionsInputData {
    final private String restriction;
    final private Float value;

    public UpdateRestrictionsInputData(String restriction, Float value) {
        this.restriction = restriction;
        this.value = value;
    }

    public String getRestriction() {
        return restriction;
    }

    public Float getValue() {
        return value;
    }

}