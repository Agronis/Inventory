import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Agronis on 10/12/15.
 */
public class Inv {

    public static void main(String[] args) {

        //Code Wide Rules
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> vault = new HashMap<>();

        while (true) {
            // Authenticated.
            System.out.println("Access Granted.");
            System.out.println("Welcome to the Vault.");
            System.out.println("What would you like to do today?");
            System.out.println("[1] Inspect Vault [2] Modify Vault [3] Log Out");

            // Select direction.

            // Inspect vault container.
            String input = scanner.nextLine();
            input = input.toLowerCase();
            if (input.equals("1") || input.contains("inspect")) {
                System.out.println(vault); // Prints items within vault.

                // Modify vault container.
            } else if (input.equals("2") || input.equals("modify")) {
                System.out.println("How would you like to modify your vault?");
                System.out.println("[1] Add a new item. [2] Update item's quantity. [3] Remove item from inventory.");
                String input2 = scanner.nextLine();
                input2 = input2.toLowerCase();
                if (input2.equals("1") || input2.contains("add")) {
                    System.out.println("What item are you depositing?");
                    String inputaddItem = scanner.nextLine();
                    inputaddItem = inputaddItem.toUpperCase();
                    System.out.println("How many " + inputaddItem + " are you adding?");
                    String inputqtyItem = scanner.nextLine();
                    int qtyItem = Integer.valueOf(inputqtyItem);
                    if (qtyItem >= 0) {
                        vault.put(inputaddItem, qtyItem);
                        System.out.println("Added " + qtyItem + "  " + inputaddItem + " to your vault.");
                    } else {
                        System.out.println("Number must be great than zero.");
                    }
                } else if (input2.equals("2") || input2.contains("update") || input2.contains("quantity")) {
                    while (true) {
                        if (vault.isEmpty()) {
                            System.out.println("No items in vault to modify.");
                            break;
                        } else {
                            System.out.println("Which item would you like to update?");
                            System.out.println(vault);
                            System.out.println("Make a selection based on item's name.");
                            String modVault = scanner.nextLine();
                            modVault = modVault.toUpperCase();
                            if (vault.containsKey(modVault)) {
                                System.out.println("How many " + modVault + " would you like to add?");
                                System.out.println("If remainder is less than one unit - item will be removed from vault.");
                                String qtyVault = scanner.nextLine();
                                int mqtyVault = Integer.valueOf(qtyVault);
                                if ((vault.get(modVault) - mqtyVault) >= 0) {
                                    System.out.println("Are you sure you want to remove " + modVault + "?");
                                    System.out.println("Yes or No");
                                    String choice = scanner.nextLine();
                                    choice = choice.toLowerCase();
                                    if (choice.equals("yes")) {
                                        vault.remove(modVault);
                                        System.out.println(modVault + " removed from inventory.");
                                    }
                                } else {
                                    vault.put(modVault, vault.get(modVault) + mqtyVault);
                                    System.out.println("Added " + mqtyVault + " " + modVault + " to your vault.");
                                }
                                break;
                            } else {
                                System.out.println("Please select an item already in your vault.");
                            }
                        }
                    }
                }
            }
        }
    }
}






// Create
// Remove
// Update
// Passlogin