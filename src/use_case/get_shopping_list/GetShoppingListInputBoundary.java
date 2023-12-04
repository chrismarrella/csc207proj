package use_case.get_shopping_list;

/**
 * Interface for GetShoppingList's InputBoundary
 */
public interface GetShoppingListInputBoundary {
    /**
     * Executes the use case given the input data
     * @param getShoppingListInputData Input data for the use case (the ingredients required for the recipe)
     */
    void execute(GetShoppingListInputData getShoppingListInputData);
}
