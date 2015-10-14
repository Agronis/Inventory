/**
 * Created by Agronis on 10/13/15.
 */
public class InventoryItem {
    String name;
    int quantity;
    String category;

    @Override
    public String toString() {
        return String.format("You have %d %s(s) from %s within your Vault.", quantity, name, category);
    }
}
