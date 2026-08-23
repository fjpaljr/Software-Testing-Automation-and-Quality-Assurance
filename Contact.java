// This class represents one contact in the system.
// It just holds the data for a person (id, name, phone, address) and
// makes sure none of that data breaks the rules from the assignment.
public class Contact {

    // contactId can never change once the contact is created, so I made it final.
    // There is no setter for it anywhere in this class on purpose.
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor - this runs when we make a new Contact.
    // I check all the fields here so it's impossible to create a bad Contact.
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // contactId rules: can't be null, can't be more than 10 characters
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be null and must not exceed 10 characters");
        }
        this.contactId = contactId;

        // reusing the setters below so I don't have to write the same checks twice
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // just a normal getter, no rules to check when reading a value
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    // firstName rules: can't be null, max 10 characters
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null and must not exceed 10 characters");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // lastName rules: can't be null, max 10 characters
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null and must not exceed 10 characters");
        }
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    // phone rules: can't be null, has to be exactly 10 digits (no dashes, spaces, letters, etc)
    // \\d{10} is a regex that means "10 digit characters in a row, nothing else"
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone cannot be null and must be exactly 10 digits");
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    // address rules: can't be null, max 30 characters
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null and must not exceed 30 characters");
        }
        this.address = address;
    }
}
