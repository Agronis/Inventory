import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Agronis on 10/12/15.
 */
public class Auth {

    public static void login() throws InterruptedException {


        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> auth = new HashMap<>();

        // Placed as loop unlocker.
        HashMap<String, Integer> unlock = new HashMap<>();
        auth.put("iron", "yard");


        int tries = 0;

        do {

            tries++;
            System.out.println("Welcome to the Vault.");
            System.out.println("Please enter proper credentials to login.");
            System.out.println("Warning: You only have five tries before the system locks you out.");
            System.out.println("You have " + (6 - tries) + " left.");
            System.out.println("Username:");
            String user = scanner.nextLine();
            user = user.toLowerCase();

            if (auth.containsKey(user)) {

                System.out.println("Verifying..");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Please enter the password for " + user + ".");
                String pass = scanner.nextLine();
                pass = pass.toLowerCase();

                if (auth.containsValue(pass)) {
                    System.out.println("Authenticating..");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("User Authenticated - Welcome " + user + ".");
                    unlock.put("Unlock", 1);

                } else {

                    System.out.println("Invalid Password. Try Again");
                    
                }

            } else {

                System.out.println("No such Username exists.  Try Again.");
            }

            if (tries > 5) {

                System.out.println("Security Protocols Engaged.");
                System.out.println("Terminal Shutting Down In..");
                Time.fail();

            }

            } while (unlock.isEmpty()) ;
        }
    }


