package interface_adapter.remove_expired;

public class RemoveExpiredState {

    private String expiredFoodItems;
    private String noExpired = null;

    /**
     * Copy constructor
     * This method creates the remove expired state.
     * @param copy The copy of the remove expired state.
     */
    public RemoveExpiredState(RemoveExpiredState copy) {
        expiredFoodItems = copy.expiredFoodItems;
    }

    /**
     * This is the default constructor.
     */
    public RemoveExpiredState() {
    }

    /**
     * This method gets the string message with expired food items.
     * @return The string message with the names of expired food items.
     */
    public String getExpiredFoodItems() {
        return expiredFoodItems + "\nare expired.";
    }

    /**
     * This method sets the string message of expired food items.
     * @param expiredFoodItems The string message with the names of expired food items.
     */
    public void setExpiredFoodItems(String expiredFoodItems) {
        this.expiredFoodItems = expiredFoodItems;
    }

    /**
     * This method gets the string message when there are no expired food items.
     * @return The string message that says that there are no expired food items.
     */
    public String getNoExpired() {
        return noExpired;
    }

    /**
     * This method sets the string message when there are no expired food items.
     * @param noExpired The string message that says that there are no expired food items.
     */
    public void setNoExpired(String noExpired) {
        this.noExpired = noExpired;
    }
}
