package KYC.services;

import KYC.Utility;
import KYC.model.Referee;
import KYC.sql.RefereeQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RefereeKycServices {

    static final String UPDATE_QUERY = "UPDATE referee SET name=?, profession=?, phone_number=?, address_id=?" +
            " WHERE referee_id=?";

    public void registerReferee(String refereeName, String profession, String phone_number, String phoneNumber, int address_id, String street)
            throws Exception {

        if (refereeName.isBlank() || profession.isBlank() || phone_number.isBlank()) {
            throw new Exception("refereeName, profession, and phone_number must be provided");
        }

        Referee referee = new Referee(refereeName, profession, phone_number, address_id);
        RefereeQuery.createReferee(referee);
    }

    public static void updateReferee(Referee referee) {
        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {

            // Set parameter values for the prepared statement
            stmt.setString(1, referee.getName());
            stmt.setString(2, referee.getProfession());
            stmt.setString(3, referee.getPhoneNumber());
            stmt.setInt(4, referee.getAddressId());
            stmt.setInt(5, referee.getRefereeId());

            // Execute the query
            stmt.executeUpdate();
            System.out.println("Referee updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Rest of the code...

    public Referee getRefereeById(int refereeId) throws Exception {
        Referee referee = RefereeQuery.getRefereeById(refereeId);

        if (referee != null) {
            // Referee with the specified ID exists, do something with it
            System.out.println("Referee found: " + referee.toString());
        } else {
            System.out.println("Referee with ID " + refereeId + " does not exist.");
        }
        return referee;
    }

    // Rest of the code...

    public void deleteReferee(int refereeId) throws Exception {
        boolean isDeleted = RefereeQuery.deleteRefereeById(refereeId);

        if (isDeleted) {
            System.out.println("Referee with ID " + refereeId + " deleted successfully.");
        } else {
            System.out.println("Referee with ID " + refereeId + " does not exist or deletion failed.");
        }
    }

    // Rest of the code...
}
