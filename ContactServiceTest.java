import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tests for the ContactService class. @BeforeEach gives each test a fresh
// ContactService so tests don't accidentally affect each other.
class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    // basic add - make a contact, add it, make sure we can get it back out
    @Test
    void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1"));
    }

    // adding two contacts with the same id should not be allowed
    @Test
    void testAddContactWithDuplicateIdThrows() {
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Smith", "9876543210", "456 Oak Ave");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    // can't add a null contact, nothing to store
    @Test
    void testAddNullContactThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    // add a contact then delete it, it should be gone afterwards
    @Test
    void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    // trying to delete an id that was never added should throw
    @Test
    void testDeleteNonExistentContactThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("nonexistent"));
    }

    // the next 4 tests just check each update method actually changes the value

    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("1", "Jane");
        assertEquals("Jane", service.getContact("1").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateLastName("1", "Smith");
        assertEquals("Smith", service.getContact("1").getLastName());
    }

    @Test
    void testUpdatePhone() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updatePhone("1", "9876543210");
        assertEquals("9876543210", service.getContact("1").getPhone());
    }

    @Test
    void testUpdateAddress() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateAddress("1", "456 Oak Ave");
        assertEquals("456 Oak Ave", service.getContact("1").getAddress());
    }

    // trying to update a contact that doesn't exist should throw
    @Test
    void testUpdateNonExistentContactThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("nonexistent", "Jane"));
    }

    // trying to update with bad data (like a short phone number) should
    // still throw the same way it would in the Contact constructor
    @Test
    void testUpdateWithInvalidDataThrows() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "123"));
    }
}