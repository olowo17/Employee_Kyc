package KYC.sql;

import KYC.Utility;
import KYC.model.Address;
import KYC.model.Contact;

import java.sql.*;

public class AddressQuery {

    static final String INSERT_QUERY = "INSERT INTO address (street, city, state, country, zip_code, contact_id)" +
            " VALUES (?, ?, ?, ?, ?)";
    static final String DELETE_QUERY = "DELETE FROM address WHERE address_id=?";

    public static void createAddress(Address address) {
        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {

            // Set parameter values for the prepared statement
            stmt.setString(1, address.getState());
            stmt.setString(2, address.getCity());
            stmt.setString(3, address.getCountry());
            stmt.setString(4, address.getZipcode());
            stmt.setInt(5, address.getContact_id());
            stmt.setString(6, address.getStreet());

            // Execute the query
            stmt.executeUpdate();
            System.out.println("contact created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Object getAddressById(int addressId) {
        Address address = null;
        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM contact WHERE contact_id=?")) {

            // Set the addressId as the parameter for the prepared statement
            stmt.setInt(1, addressId);

            // Execute the query
            ResultSet resultSet = stmt.executeQuery();

            // Check if the contact with the given ID exists
            if (resultSet.next()) {
                // Retrieve contact details from the result set
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zipCode = resultSet.getString("zipCode");
                String country = resultSet.getString("country");
                int contactId = Integer.parseInt(resultSet.getString("contactId"));

                // Create a new Contact object
                address = new Address(street, city, state, zipCode, country, contactId);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return  address;
    }
    public static boolean deleteAddressById ( int addressId){
        boolean isDeleted = false;

        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY)) {

            // Set the addressId as the parameter for the prepared statement
            stmt.setInt(1, addressId);

            // Execute the query and check if any rows were affected (i.e., the address was deleted)
            int rowsAffected = stmt.executeUpdate();
            isDeleted = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
        }
    }
