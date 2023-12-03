package interface_adapter.removeExpired;

public class RemoveExpiredState {

    private String expiredFoodItems;
    private String noExpired = null;

    public RemoveExpiredState(RemoveExpiredState copy) {
        expiredFoodItems = copy.expiredFoodItems;
    }

    public RemoveExpiredState() {
    }

    public String getExpiredFoodItems() {
        return expiredFoodItems + "\nare expired.";
    }

    public void setExpiredFoodItems(String expiredFoodItems) {
        this.expiredFoodItems = expiredFoodItems;
    }

    public String getNoExpired() {
        return noExpired;
    }

    public void setNoExpired(String noExpired) {
        this.noExpired = noExpired;
    }
}
