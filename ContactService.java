import java.util.HashMap;
import java.util.Map;

// This class manages all the Contact objects. Since we're not using a
// database for this assignment, I'm just keeping everything in memory
// using a HashMap. The contact's ID is the key so it's fast to look up.
public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    // Adds a new contact to the map.
    // Throws an error if the contact is null, or if that ID is already used
    // (ids have to be unique, so we can't just overwrite an existing one).
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists: " + contact.getContactId());
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Removes a contact by id. If the id doesn't exist, there's nothing to
    // delete, so I throw an error instead of letting it fail silently.
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found: " + contactId);
        }
        contacts.remove(contactId);
    }

    // Below are the update methods. I made a separate method for each
    // field instead of one big "update anything" method. This way you
    // can't accidentally put a phone number into the address field, and
    // there's no way to update the contactId since I didn't write a method
    // for that at all.

    public void updateFirstName(String contactId, String firstName) {
        getExistingContact(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getExistingContact(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getExistingContact(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getExistingContact(contactId).setAddress(address);
    }

    // Lets you grab a contact by id to check its info (used a lot in testing).
    // Returns null if it's not in the map.
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    // Helper method so I'm not copy-pasting the "does this id exist" check
    // in every single update method above.
    private Contact getExistingContact(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found: " + contactId);
        }
        return contact;
    }
}