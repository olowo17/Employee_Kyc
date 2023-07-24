package KYC;
import java.util.Scanner;

public class Utility {

    static Scanner scanner = new Scanner(System.in);
    public static final String DB_URL
            = "jdbc:sqlserver://;servername=ISW-221130-1108;" +
            "instanceName=SQLEXPRESS;databaseName=EmployeeDb;" +
            "encrypt=false;integratedSecurity=true;";

}
//   insert into address
//public static void insertRecord(String databaseName) {
//    try (Connection connection = DriverManager.getConnection(DB_URL + "databaseName=" + databaseName + ";");
//         Statement statement = connection.createStatement();
//    ) {
//        System.out.println("Enter First name");
//        String firstName = scanner.next();
//        System.out.println("Enter Last name");
//        String lastName = scanner.next();
//        System.out.println("Enter phone number");
//        String phoneNumber = scanner.next();
//        System.out.println("Enter Sex ( M or F)");
//        String sex = scanner.next();
//        System.out.println("Enter date of birth");
//        String dob = scanner.next();
//
//        String contactSql = "INSERT INTO contact (first_name, last_name, phone_number, sex, dob) VALUES " +
//                "('" + firstName + "','" + lastName + "','" + phoneNumber + "','" + sex + "','" + dob + "')";
//
//        statement.executeUpdate(contactSql);
//        System.out.println("Insertion completed...");
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}


