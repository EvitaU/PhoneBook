import java.io.File;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {

        File myObj = new File("Contacts.txt");

        Menu menu = new Menu();
        menu.showMenu();
    }
}
