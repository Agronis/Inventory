import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Agronis on 10/13/15.
 */
public class Vault {

    public static HashMap<String, InventoryItem> storage = new HashMap<>();

    public static HashMap<String, InventoryItem> getVault() {
        return storage;
    }

//    ArrayList<String> classInv = new ArrayList<String>() {
//        String Weapons;
//        String Armors;
//        String Utilities;
//        String Currency;
//        String Skills;
//    };
//    HashMap<String, Integer> mapInv = new HashMap<>();

//    quantity = Integer.valueOf(quantity);
//    System.out.println("What item would you like to create?");
//    String listenName = scanner.nextLine();
//    System.out.printf("How many %d are you adding?", quantity);
//    String listenQty = scanner.nextLine();
//    System.out.println("Which category would you like to place %s in?", listenName);

}
