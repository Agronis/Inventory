import java.util.concurrent.TimeUnit;

/**
 * Created by Agronis on 10/12/15.
 */
public class Time {

    public static void menu() throws InterruptedException {

        System.out.println("Returning to the main menu.");
        TimeUnit.MILLISECONDS.sleep(80);
        System.out.println(".");
        TimeUnit.MILLISECONDS.sleep(80);
        System.out.println("..");
        TimeUnit.MILLISECONDS.sleep(80);
        System.out.println("...");
        TimeUnit.MILLISECONDS.sleep(80);
        System.out.println("....");
        TimeUnit.MILLISECONDS.sleep(80);
        System.out.println(".....");
        TimeUnit.MILLISECONDS.sleep(80);
        System.out.println("......");
        TimeUnit.MILLISECONDS.sleep(80);
        System.out.println(".......");
        TimeUnit.MILLISECONDS.sleep(80);
        System.out.println("........");

    }

    public static void boot() throws InterruptedException {

        System.out.println("System booting.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("..");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("....");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(".....");

    }

    public static void fail() throws InterruptedException {

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Four");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Three");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Two");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("One");
        System.out.println("Goodbye.");
        System.exit(0);

    }
}
