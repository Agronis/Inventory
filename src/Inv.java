import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Agronis on 10/12/15.
 */
public class Inv {

    public static void main(String[] args) throws Exception {

        //Code Wide Rules
        Scanner scanner = new Scanner(System.in);
        //HashMap<String, Integer> vault = new HashMap<>();

        // User Authentication
        Time.boot();
        Auth.login();


        while (true) {      // Select direction.
            System.out.println("Welcome to the Vault.");
            System.out.println("What would you like to do today?");
            System.out.println("[1] Inspect Vault [2] Modify Vault [3] Log Out");

            // Inspect vault container.
            String input = scanner.nextLine();
            input = input.toLowerCase();

            // Calls upon "storage" HashMap for the Vault.
            Vault.getVault();

            if (input.equals("1") || input.contains("inspect")) {
                System.out.println(Vault.storage); // Prints items within vault.

                // Modify vault container.
            } else if (input.equals("2") || input.equals("modify")) {
                System.out.println("How would you like to modify your Vault?");
                System.out.println("[1] Add a new item. [2] Update item's quantity. [3] Remove item from the Vault.");
                String input2 = scanner.nextLine();
                input2 = input2.toLowerCase();

                if (input2.equals("1") || input2.contains("add")) {
                    System.out.println("What item are you depositing?");
                    String inputaddItem = scanner.nextLine();
                    inputaddItem = inputaddItem.toUpperCase();
                    System.out.println("How many " + inputaddItem + " are you adding?");
                    String inputqtyItem = scanner.nextLine();
                    int qtyItem = Integer.valueOf(inputqtyItem);
                    System.out.println("Which category does this pertain to?");
                    String inputCat = scanner.nextLine();

                    if (qtyItem >= 0) {
                        Vault.storage.put(inputaddItem, createItem(inputaddItem, qtyItem, inputCat));
                        System.out.println("Added " + qtyItem + " " + inputaddItem + " to your Vault.");
                        Time.menu();

                    } else {  // Fail Safe.

                        System.out.println("Number must be great than zero.");
                    }
                } else if (input2.equals("2") || input2.contains("update") || input2.contains("quantity")) {

                    while (true) {

                        if (Vault.storage.isEmpty()) {   // Fail safe.
                            System.out.println("No items in Vault to modify.");
                            System.out.println("You're clearly confused.");
                            System.out.println("Let's try this again..");
                            Time.menu();

                            break;
                        } else {

                            System.out.println("Which item would you like to update?");
                            System.out.println(Vault.storage);
                            System.out.println("Make a selection based on item's name.");
                            String modVault = scanner.nextLine();
                            modVault = modVault.toUpperCase();
                            // If item is found in vault - process continues.
                            if (Vault.storage.containsKey(modVault)) {
                                System.out.println("How many " + modVault + " would you like to add?");
                                System.out.println("If remainder is less than one unit - item will be removed from Vault.");

                                // If the end result of updating quantity results in <= 0
                                // system offers to delete entry.
                                String qtyVault = scanner.nextLine();
                                int mqtyVault = Integer.valueOf(qtyVault);

                                if ((Vault.storage.get(modVault).quantity + mqtyVault) <= 0) {
                                    System.out.println("Are you sure you want to remove " + modVault + "?");
                                    System.out.println("Yes or No");
                                    String choice = scanner.nextLine();
                                    choice = choice.toLowerCase();

                                    if (choice.equals("yes")) {
                                        Vault.storage.remove(modVault);
                                        System.out.println(modVault + " removed from the Vault.");
                                        Time.menu();
                                    }
                                } else {  // Items added to vault.
                                    InventoryItem item = Vault.storage.get(modVault);
                                    item.quantity += mqtyVault;
                                    Vault.storage.put(modVault, item);
                                    System.out.println("Added " + mqtyVault + " " + modVault + " to your Vault.");
                                    Time.menu();
                                }
                                break;
                            } else {        /// Fail safe.
                                System.out.println("Please select an item already in your Vault.");
                            }
                        }
                    }
                } else if (input2.equals("3") || input2.contains("remove")) {

                    if (Vault.storage.isEmpty()) {
                        System.out.println("How do you plan on removing something that isn't there?");
                        System.out.println("Are you Houdini?");
                        System.out.println("Let's try this again..");
                        Time.menu();

                    } else {
                        // Deleting items from the Vault.
                        System.out.println("Which item do you want to dump from the Vault?");
                        System.out.println(Vault.storage);
                        String delItem = scanner.nextLine();
                        delItem = delItem.toUpperCase();

                        if (delItem.equals(Vault.storage.get(delItem))) {
                            System.out.println("Are you sure you wish to remove " + delItem + " from your Vault?");
                            String confirm = scanner.nextLine();
                            confirm = confirm.toLowerCase();

                            if (confirm.equals("yes")) {
                                Vault.storage.remove(delItem);
                                System.out.println(delItem + " has been removed from your Vault.");
                                Time.menu();

                            } else { // Fail safe.

                                System.out.println("Just testing the waters are we?");
                                Time.menu();
                            }
                        }
                    }
                }
            } else if (input.equals("3") || input.equals("logout") || input.equals("exit") || input.equals("end")) {
                System.out.println("Are you sure you wish to log out of the Vault?");
                String listen = scanner.nextLine();
                listen = listen.toLowerCase();
                if (listen.equals("yes")) {
                    System.out.println("Goodbye.");
                    System.exit(0);
                } else if (!listen.equals("no")) {
                    System.out.println("Not a valid choice.. it was just yes or no.  Enjoy the loop.");
                }
            } else {
                System.out.println("Please make a valid selection.");
                Time.menu();
            }
        }
    }

    public static InventoryItem createItem(String itemName, int quantity, String category) throws Exception {

        if (category.equals("Weapons")) {
            return new Weapons(itemName, quantity);
        }
        else if (category.equals("Armors")) {
            return new Armors(itemName, quantity);
        }
        else if (category.equals("Utilities")) {
            return new Utilities(itemName, quantity);
        }
        else if (category.equals("Currency")) {
            return new Currency(itemName, quantity);
        }
        else if (category.equals("Skills")) {
            return new Skills(itemName, quantity);

        } else {
            throw new Exception("Invalid Category");
        }

    }
}
