package KYC.sql;

import KYC.Utility;
import KYC.model.Contact;
import KYC.model.Referee;

import java.sql.*;

public class RefereeQuery {
    static final String INSERT_QUERY = "INSERT INTO referee (name, profession, phone_number, address_id)" +
            " VALUES (?, ?, ?, ?)";

    static final String DELETE_QUERY= "DELETE FROM referee WHERE referee_id=?";

    public static void createReferee(Referee referee) {
        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {

            // Set parameter values for the prepared statement
            stmt.setString(1, referee.getName());
            stmt.setInt(2, referee.getAddressId());
            stmt.setString(3, referee.getPhoneNumber());
            stmt.setString(4, referee.getProfession());

            // Execute the query
            stmt.executeUpdate();
            System.out.println("referee created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Referee getRefereeById(int refereeId) {
        Referee referee = null;

        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM contact WHERE referee_id=?")) {

            // Set the contactId as the parameter for the prepared statement
            stmt.setInt(1, refereeId);

            // Execute the query
            ResultSet resultSet = stmt.executeQuery();

            // Check if the contact with the given ID exists
            if (resultSet.next()) {
                // Retrieve contact details from the result set
                String refereeName = resultSet.getString("name");
                String profession = resultSet.getString("profession");
                String phone_number = resultSet.getString("phone_number");
                int address_id = resultSet.getInt("address_id");


                // Create a new Contact object
                referee = new Referee(refereeName,profession,phone_number,address_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return referee;
    }
    public static boolean deleteRefereeById(int refereeId) {
        boolean isDeleted = false;

        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY)) {

            // Set the refereeId as the parameter for the prepared statement
            stmt.setInt(1, refereeId);

            // Execute the query and check if any rows were affected (i.e., the contact was deleted)
            int rowsAffected = stmt.executeUpdate();
            isDeleted = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }
}
