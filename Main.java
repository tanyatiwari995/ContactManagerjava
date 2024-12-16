package contact;


import java.util.ArrayList;
import java.util.List;

class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + ": " + phone;
    }
}

class ContactManager {
    private List<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phone) {
        contacts.add(new Contact(name, phone));
        System.out.println("Added contact: " + name);
    }

    public void deleteContact(String name) {
        boolean deleted = contacts.removeIf(contact -> contact.getName().equals(name));
        if (deleted) {
            System.out.println("Deleted contact: " + name);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    public void displayContacts() {
        System.out.println("Contacts:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    public void addMultipleContacts(Contact... newContacts) {
        for (Contact contact : newContacts) {
            addContact(contact.getName(), contact.getPhone());
        }
    }

    public Contact findContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public void updateContact(String name, String newPhone) {
        boolean updated = false;
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                contact.setPhone(newPhone);
                updated = true;
                break;
            }
        }
        if (updated) {
            System.out.println("Updated " + name + "'s phone to " + newPhone);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    public int countContacts() {
        return contacts.size();
    }
}

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();

        // Example usage
        contactManager.addContact("Alice", "123-456-7890");
        contactManager.addContact("Bob", "987-654-3210");
        contactManager.displayContacts();
        contactManager.deleteContact("Alice");
        contactManager.displayContacts();
        contactManager.addMultipleContacts(
            new Contact("Charlie", "111-222-3333"),
            new Contact("David", "444-555-6666")
        );
        contactManager.displayContacts();
        Contact foundContact = contactManager.findContact("Bob");
        System.out.println("Found contact: " + foundContact);
        contactManager.updateContact("Charlie", "999-888-7777");
        contactManager.displayContacts();
        System.out.println("Total contacts: " + contactManager.countContacts());
    }
}
