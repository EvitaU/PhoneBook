import java.util.Locale;
import java.util.Scanner;

public class Menu {


    Scanner scanner = new Scanner(System.in);
    Options options = new Options();

    public static void menu() {
        Menu menu = new Menu();
    }

    void showMenu(){

        String userInput = "";

        do{
            System.out.println("\n Welcome to your phone book.");
            System.out.println("Options: ");
            System.out.println("\n1. Add new contact.");
            System.out.println("2. View all existing contacts.");
            System.out.println("3. Find contact and view saved information.");
            System.out.println("4. Edit contact information. ");
            System.out.println("5. Delete existing contact.");


            System.out.println("Enter Quit to exit the program.");

            System.out.println("Choose a number: ");
            userInput = scanner.nextLine().trim().toLowerCase();

            switch (userInput) {
                case "quit":
                    System.out.println("Exiting phone book!");
                    break;
                case "1":
                    options.addContact();
                    break;
                case "2":
                    options.viewAllContacts();
                    break;
                case "3":
                    options.searchContact();
                    break;
                case "4":
                    options.updateContact();
                    break;
                case "5":
                    options.deleteContact();
                    break;
                default:
                    break;
            }

        }
        while (!userInput.equalsIgnoreCase("quit"));
        return;
    }


}
