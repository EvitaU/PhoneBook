import java.util.*;

public class Options {

    Scanner scanner = new Scanner(System.in);
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public String addContact(Contact contact) {
        this.contacts.add(contact);
        return contact.name + " saved successfully";
    }

    void addContact() {
        System.out.println("Add new contact to phonebook: ");

        Contact contact = new Contact();
        System.out.println("\nEnter name: ");
        contact.name = scanner.next();

        System.out.println("Enter phone number: ");
        contact.number = scanner.nextInt();

        System.out.println("Enter email: ");
        contact.email = scanner.next();

        contact.id = UUID.randomUUID();

        String message = addContact(contact);
        System.out.println(message);
    }

    public ArrayList<Contact> getAllContacts() {
        Collections.sort(Collections.EMPTY_LIST);
        return contacts;
    }

    void viewAllContacts() {
        ArrayList<Contact> allContacts = getAllContacts();
        Collections.sort(contacts, Comparator.comparing(contact -> contact.name));
        System.out.println("All saved contacts: ");

        int counter = 0;

        for (Contact contact : allContacts) {
            System.out.println("\n");
            System.out.println(counter);
            System.out.println("Contact name: " + contact.name);
            System.out.println("Contact number: " + contact.number);
            System.out.println("Contact email: " + contact.email);
            counter++;

        }
    }

    public String removeContact(int contactId) {
        try {
            contacts.remove(contactId);
        } catch (Exception ex) {
            return "Unable to remove contact";
        }
        return "Contact removed successfully";
    }

    void deleteContact() {
        System.out.println("Delete contact \n");
        System.out.println("Enter Contacts Id");

        int contactId = scanner.nextInt();
        String message = removeContact(contactId);

        System.out.println(message);
    }

    public String updateContact(int contactIndex, Contact newContact) {
        if (this.contacts.get(contactIndex) != null) {
            Contact oldContact = this.contacts.get(contactIndex);
            oldContact.name = newContact.name;
            oldContact.number = newContact.number;
            oldContact.email = newContact.email;
            return "Contact info updated";
        }
        return "Contact not found";
    }

    void updateContact() {
        Contact contact = new Contact();
        this.viewAllContacts();

        System.out.println("Update contact info");
        System.out.println("\nEnter contacts id: ");
        int contactId = scanner.nextInt();

        System.out.println("Enter name: ");
        contact.name = scanner.next();

        System.out.println("Enter number: ");
        contact.number = scanner.nextInt();

        System.out.println("Enter email: ");
        contact.email = scanner.next();

        String response = updateContact(contactId, contact);
        System.out.println(response);
    }

    public String findContact(Contact contact) {
        return "Search results: " + "\n Name:" + contact.name + "\n Number: " + contact.number + "\nEmail: " + contact.email;
    }

    void searchContact() {
        System.out.println("Find contact \n");
        System.out.println("What are you looking for? ");
        int number = 0;
        String findContact = scanner.next();
        for (Contact contact : contacts) {
            if (findContact.contains(contact.name))
                System.out.println("Search results: " + "\n name: " + contact.name + "\n number: " + contact.number + "\nemail: " + contact.email);
            else {
                System.out.println("No results to show for " + findContact);
            }
            System.out.println("Enter any key to continue");
            scanner.next();
        }
    }
}

