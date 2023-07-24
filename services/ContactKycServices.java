package KYC.services;

import KYC.Utility;
import KYC.model.Contact;
import KYC.sql.ContactQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactKycServices {

    static final String UPDATE_QUERY = "UPDATE contact SET first_name=?, last_name=?, phone_number=?, sex=?, dob=?" +
            " WHERE contact_id=?";
    public void registerContact(String firstName, String lastName, String phoneNumber, String sex, String dob)
            throws Exception {

        if(firstName.isBlank() || lastName.isBlank() ||sex.isBlank() ||phoneNumber.isBlank() ||dob.isBlank()) {
            throw new Exception("firstName or lastName or phoneNumber or sex or dob must be provided");
        }
        Contact contact = new Contact(firstName, lastName, phoneNumber, sex, dob);
        ContactQuery.createContact(contact);
    }

    public static void updateContact(Contact contact) {
        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {

            // Set parameter values for the prepared statement
            stmt.setString(1, contact.getFirstName());
            stmt.setString(2, contact.getLastName());
            stmt.setString(3, contact.getPhoneNumber());
            stmt.setString(4, contact.getSex());
            stmt.setString(5, contact.getDob());
            stmt.setInt(6, contact.getId()); //

            // Execute the query
            stmt.executeUpdate();
            System.out.println("Contact updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        // Rest of the code...

        public Contact getContactById(int contactId) throws Exception {
            Contact contact = ContactQuery.getContactById(contactId);

            if (contact != null) {
                // Contact with the specified ID exists, do something with it
                System.out.println("Contact found: " + contact.toString());
            } else {
                System.out.println("Contact with ID " + contactId + " does not exist.");
            }
            return contact;
        }

    // Rest of the code...

    public void deleteContact(int contactId) throws Exception {
        boolean isDeleted = ContactQuery.deleteContactById(contactId);

        if (isDeleted) {
            System.out.println("Contact with ID " + contactId + " deleted successfully.");
        } else {
            System.out.println("Contact with ID " + contactId + " does not exist or deletion failed.");
        }
    }

    // Rest of the code...
}


