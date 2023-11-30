package interface_adapter.removeExpired;

public class RemoveExpiredState {

    private String expiredFoodItems;

    public RemoveExpiredState(RemoveExpiredState copy) {
        expiredFoodItems = copy.expiredFoodItems;
    }

    public RemoveExpiredState() {
    }

    public String getExpiredFoodItems() {
        return expiredFoodItems;
    }

    public void setExpiredFoodItems(String expiredFoodItems) {
        this.expiredFoodItems = expiredFoodItems;
    }
}
