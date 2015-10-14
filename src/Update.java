//import java.util.Scanner;
//
///**
// * Created by Agronis on 10/13/15.
// */
//public class Update extends Inv {
//
//    static Scanner scanner = new Scanner(System.in);
//
//    public static void Update() throws InterruptedException {
//
//        System.out.println("Which item would you like to update?");
//        System.out.println(Vault.storage);
//        System.out.println("Make a selection based on item's name.");
//        String modVault = scanner.nextLine();
//        modVault = modVault.toUpperCase();
//        // If item is found in vault - process continues.
//        if (Vault.storage.containsKey(modVault)) {
//            System.out.println("How many " + modVault + " would you like to add?");
//            System.out.println("If remainder is less than one unit - item will be removed from Vault.");
//
//            // If the end result of updating quantity results in <= 0
//            // system offers to delete entry.
//            String qtyVault = scanner.nextLine();
//            int mqtyVault = Integer.valueOf(qtyVault);
//
//            if ((Vault.storage.get(modVault).quantity + mqtyVault) <= 0) {
//                System.out.println("Are you sure you want to remove " + modVault + "?");
//                System.out.println("Yes or No");
//                String choice = scanner.nextLine();
//                choice = choice.toLowerCase();
//
//                if (choice.equals("yes")) {
//                    Vault.storage.remove(modVault);
//                    System.out.println(modVault + " removed from the Vault.");
//                    Time.menu();
//                }
//            } else {  // Items added to vault.
//                InventoryItem item = Vault.storage.get(modVault);
//                item.quantity += mqtyVault;
//                Vault.storage.put(modVault, item);
//                System.out.println("Added " + mqtyVault + " " + modVault + " to your Vault.");
//                Time.menu();
//            }
//        }
//    }
//}
