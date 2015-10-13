import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Agronis on 10/12/15.
 */
public class Inv {

    public static void main(String[] args) throws InterruptedException {

        //Code Wide Rules
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> vault = new HashMap<>();

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

            if (input.equals("1") || input.contains("inspect")) {
                System.out.println(vault); // Prints items within vault.

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

                    if (qtyItem >= 0) {
                        vault.put(inputaddItem, qtyItem);
                        System.out.println("Added " + qtyItem + " " + inputaddItem + " to your Vault.");
                        System.out.println("Returning to the main menu.");
                        Time.menu();

                    } else {  // Fail Safe.

                        System.out.println("Number must be great than zero.");
                    }
                } else if (input2.equals("2") || input2.contains("update") || input2.contains("quantity")) {

                    while (true) {

                        if (vault.isEmpty()) {   // Fail safe.
                            System.out.println("No items in Vault to modify.");
                            System.out.println("You're clearly confused.");
                            System.out.println("Let's try this again..");
                            Time.menu();

                            break;
                        } else {

                            System.out.println("Which item would you like to update?");
                            System.out.println(vault);
                            System.out.println("Make a selection based on item's name.");
                            String modVault = scanner.nextLine();
                            modVault = modVault.toUpperCase();
                            // If item is found in vault - process continues.
                            if (vault.containsKey(modVault)) {
                                System.out.println("How many " + modVault + " would you like to add?");
                                System.out.println("If remainder is less than one unit - item will be removed from Vault.");

                                // If the end result of updating quantity results in <= 0
                                // system offers to delete entry.
                                String qtyVault = scanner.nextLine();
                                int mqtyVault = Integer.valueOf(qtyVault);

                                if ((vault.get(modVault) + mqtyVault) <= 0) {
                                    System.out.println("Are you sure you want to remove " + modVault + "?");
                                    System.out.println("Yes or No");
                                    String choice = scanner.nextLine();
                                    choice = choice.toLowerCase();

                                    if (choice.equals("yes")) {
                                        vault.remove(modVault);
                                        System.out.println(modVault + " removed from the Vault.");
                                        Time.menu();
                                    }
                                } else {  // Items added to vault.

                                    vault.put(modVault, vault.get(modVault) + mqtyVault);
                                    System.out.println("Added " + mqtyVault + " " + modVault + " to your Vault.");
                                    Time.menu();
                                }
                                break;
                            } else {        /// Fail safe.
                                System.out.println("Please select an item already in your Vault.");
                            }
                        }
                    }       // Fail safe.
                } else if (input2.equals("3") || input2.contains("remove")) {

                    if (vault.isEmpty()) {
                        System.out.println("How do you plan on removing something that isn't there?");
                        System.out.println("Are you Houdini?");
                        System.out.println("Let's try this again..");
                        Time.menu();

                    } else {
                        // Deleting items from the Vault.
                        System.out.println("Which item do you want to dump from the Vault?");
                        System.out.println(vault);
                        String delItem = scanner.nextLine();
                        delItem = delItem.toUpperCase();

                        if (delItem.equals(vault.get(delItem))) {
                            System.out.println("Are you sure you wish to remove " + delItem + " from your Vault?");
                            String confirm = scanner.nextLine();
                            confirm = confirm.toLowerCase();

                            if (confirm.equals("yes")) {
                                vault.remove(delItem);
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
}
