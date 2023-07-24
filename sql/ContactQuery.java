package KYC.sql;

import KYC.Utility;
import KYC.model.Contact;

import java.sql.*;

public class ContactQuery {
    static final String INSERT_QUERY = "INSERT INTO contact (first_name, last_name, phone_number, sex, dob)" +
            " VALUES (?, ?, ?, ?, ?)";
    static final String DELETE_QUERY= "DELETE FROM contact WHERE contact_id=?";
    public static void createContact(Contact contact) {
        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {

            // Set parameter values for the prepared statement
            stmt.setString(1, contact.getFirstName());
            stmt.setString(2, contact.getLastName());
            stmt.setString(3, contact.getPhoneNumber());
            stmt.setString(4, contact.getSex());
            stmt.setString(5, contact.getDob());

            // Execute the query
            stmt.executeUpdate();
            System.out.println("contact created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Contact getContactById(int contactId) {
        Contact contact = null;

        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM contact WHERE contact_id=?")) {

            // Set the contactId as the parameter for the prepared statement
            stmt.setInt(1, contactId);

            // Execute the query
            ResultSet resultSet = stmt.executeQuery();

            // Check if the contact with the given ID exists
            if (resultSet.next()) {
                // Retrieve contact details from the result set
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String phoneNumber = resultSet.getString("phone_number");
                String sex = resultSet.getString("sex");
                String dob = resultSet.getString("dob");

                // Create a new Contact object
                contact = new Contact(contactId, firstName, lastName, phoneNumber, sex, dob);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contact;
    }


    public static boolean deleteContactById(int contactId) {
        boolean isDeleted = false;

        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY)) {

                // Set the contactId as the parameter for the prepared statement
            stmt.setInt(1, contactId);

                // Execute the query and check if any rows were affected (i.e., the contact was deleted)
            int rowsAffected = stmt.executeUpdate();
            isDeleted = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

            return isDeleted;
        }


}
