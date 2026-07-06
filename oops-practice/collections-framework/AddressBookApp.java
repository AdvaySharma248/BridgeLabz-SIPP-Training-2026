import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class AddressBookApp {
    private List<Contact> contactList;
    private Map<String, Contact> contactMap;
    private Set<String> phoneSet;

    public AddressBookApp() {
        contactList = new ArrayList<>();
        contactMap = new HashMap<>();
        phoneSet = new HashSet<>();
    }

    public void addContact(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Phone number already exists!");
            return;
        }
        Contact contact = new Contact(name, phone, email);
        contactList.add(contact);
        contactMap.put(name, contact);
        phoneSet.add(phone);
        System.out.println("Contact added successfully!");
    }

    public Contact searchContact(String name) {
        return contactMap.get(name);
    }

    public void deleteContact(String name) {
        Contact contact = contactMap.remove(name);
        if (contact != null) {
            contactList.remove(contact);
            phoneSet.remove(contact.phone);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }

    public void displaySortedContacts() {
        List<Contact> sortedList = new ArrayList<>(contactList);
        Collections.sort(sortedList, new Comparator<Contact>() {
            public int compare(Contact c1, Contact c2) {
                return c1.name.compareTo(c2.name);
            }
        });
        System.out.println("Contacts sorted by name:");
        for (Contact contact : sortedList) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        AddressBookApp addressBook = new AddressBookApp();
        addressBook.addContact("Alice", "1234567890", "alice@example.com");
        addressBook.addContact("Bob", "0987654321", "bob@example.com");
        addressBook.addContact("Charlie", "5555555555", "charlie@example.com");
        addressBook.displaySortedContacts();
        Contact found = addressBook.searchContact("Bob");
        if (found != null) {
            System.out.println("Found contact: " + found);
        }
        addressBook.deleteContact("Alice");
        addressBook.displaySortedContacts();
    }
}
