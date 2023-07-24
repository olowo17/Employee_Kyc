package KYC.services;

import KYC.Utility;
import KYC.model.Address;
import KYC.sql.AddressQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressKycServices {

    static final String UPDATE_QUERY = "UPDATE address SET street=?, city=?, state=?, country=?, zip_code=? " +
            "WHERE address_id=?";

    public void registerAddress(String street, String city, String state, String country, String zip_code, int contact_id)
            throws Exception {

        if (street.isBlank() || city.isBlank() || state.isBlank() || country.isBlank() || zip_code.isBlank()) {
            throw new Exception("All inputs must be provided");
        }

        Address address = new Address(street, city, state, country, zip_code, contact_id);
        AddressQuery.createAddress(address);
    }

    public static void updateAddress(Address address) {
        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {

            // Set parameter values for the prepared statement
            stmt.setString(1, address.getStreet());
            stmt.setString(2, address.getCity());
            stmt.setString(3, address.getState());
            stmt.setString(4, address.getCountry());
            stmt.setString(5, address.getZipcode());
            stmt.setInt(6, address.getAddress_id());

            // Execute the query
            stmt.executeUpdate();
            System.out.println("Address updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Rest of the code...

    public Address getAddressById(int addressId) throws Exception {
        Address address = (Address) AddressQuery.getAddressById(addressId);

        if (address != null) {
            // Address with the specified ID exists, do something with it
            System.out.println("Address found: " + address.toString());
        } else {
            System.out.println("Address with ID " + addressId + " does not exist.");
        }
        return address;
    }

    // Rest of the code...

    public void deleteAddress(int addressId) throws Exception {
        boolean isDeleted = AddressQuery.deleteAddressById(addressId);

        if (isDeleted) {
            System.out.println("Address with ID " + addressId + " deleted successfully.");
        } else {
            System.out.println("Address with ID " + addressId + " does not exist or deletion failed.");
        }
    }

    // Rest of the code...
}
