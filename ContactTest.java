import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tests for the Contact class. Each method checks one rule from the
// assignment (either that a valid contact gets created correctly, or
// that an invalid one throws an exception like it's supposed to).
class ContactTest {

    // just making sure a normal, valid contact actually stores everything right
    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // contactId can't be null
    @Test
    void testContactIdNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }

    // contactId can't be more than 10 characters (this one is 11 characters)
    @Test
    void testContactIdTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    // firstName can't be null
    @Test
    void testFirstNameNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", null, "Doe", "1234567890", "123 Main St"));
    }

    // firstName can't be more than 10 characters
    @Test
    void testFirstNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "JohnJohnJohn", "Doe", "1234567890", "123 Main St"));
    }

    // lastName can't be null
    @Test
    void testLastNameNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", null, "1234567890", "123 Main St"));
    }

    // lastName can't be more than 10 characters
    @Test
    void testLastNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St"));
    }

    // phone can't be null
    @Test
    void testPhoneNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "Doe", null, "123 Main St"));
    }

    // phone has to be exactly 10 digits, this one is too short
    @Test
    void testPhoneNotTenDigitsThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "Doe", "12345", "123 Main St"));
    }

    // phone with letters mixed in should fail too, since it's not all digits
    @Test
    void testPhoneNonNumericThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "Doe", "123abc7890", "123 Main St"));
    }

    // address can't be null
    @Test
    void testAddressNullThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "Doe", "1234567890", null));
    }

    // address can't be more than 30 characters
    @Test
    void testAddressTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "Doe", "1234567890",
                        "This address is definitely way too long"));
    }

    // checking the setters actually update the fields, this covers the
    // "updatable fields" part of the requirements
    @Test
    void testSettersUpdateFieldsCorrectly() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("9876543210");
        contact.setAddress("456 Oak Ave");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    // proving contactId never changes, even after updating other fields
    // (there's no setContactId method at all, so this should always pass)
    @Test
    void testContactIdIsNotUpdatable() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("1", contact.getContactId());
    }
}
