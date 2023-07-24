package KYC;

import KYC.model.Contact;
import KYC.services.AddressKycServices;
import KYC.services.ContactKycServices;
import KYC.services.RefereeKycServices;

import java.util.Scanner;

public class MainKyc {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ContactKycServices contactKycServices = new ContactKycServices();
        RefereeKycServices refereeKycServices = new RefereeKycServices();
        AddressKycServices addressKycServices = new AddressKycServices();

        System.out.println("Welcome!");

        while (true) {
            System.out.println("Enter \n1 to register a new customer,\n2 to view a contact \n3 to update a customer," +
                    "\n 4 to delete a contact\n9 to exit:");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 0:
                    System.out.println("Enter Name");
                    String refereeName = scanner.next();
                    System.out.println("Enter phone number");
                    String phone_number = scanner.next();
                    System.out.println("Enter Address");
                    int address_id = scanner.nextInt();
                    System.out.println("Address Id");
                    System.out.println("Enter profession");
                    String profession = scanner.next();
                    System.out.println("Enter street");
                    String street = scanner.next();
                    refereeKycServices.registerReferee(refereeName,profession,profession,phone_number,address_id,street);
                    break;
                case 1:
                    System.out.println("Enter First name");
                    String firstName = scanner.next();
                    System.out.println("Enter Last name");
                    String lastName = scanner.next();
                    System.out.println("Enter phone number");
                    String phoneNumber = scanner.next();
                    System.out.println("Enter Sex (M or F)");
                    String sex = scanner.next();
                    System.out.println("Enter date of birth (yyyy-MM-dd)");
                    String dob = scanner.next();

                    contactKycServices.registerContact(firstName, lastName, phoneNumber, sex, dob);
                    break;
                case 2:
                    System.out.println("Enter the ID of the customer to update:");
                    int contact_Id = scanner.nextInt();

                    // Retrieve the contact data based on the provided ID
                    contactKycServices.getContactById(contact_Id);
                    break;
                case 3:
                    System.out.println("Enter the ID of the customer to update:");
                    int contactId = scanner.nextInt();

                    // Retrieve the contact data based on the provided ID
                    Contact existingContact = contactKycServices.getContactById(contactId);
                    if (existingContact != null) {
                        // Update only if the contact with the given ID exists
                        System.out.println("Enter new First name");
                        String newFirstName = scanner.next();
                        System.out.println("Enter new Last name");
                        String newLastName = scanner.next();
                        System.out.println("Enter new phone number");
                        String newPhoneNumber = scanner.next();
                        System.out.println("Enter new Sex (M or F)");
                        String newSex = scanner.next();
                        System.out.println("Enter new date of birth (yyyy-MM-dd)");
                        String newDob = scanner.next();

                        Contact updatedContact = new Contact(contactId, newFirstName, newLastName, newPhoneNumber, newSex, newDob);
                        ContactKycServices.updateContact(updatedContact);
                    } else {
                        System.out.println("Contact with ID " + contactId + " does not exist.");
                    }
                    break;
                case 4:
                    System.out.println("Enter the ID of the customer to delete:");
                    int contactIdToDelete = scanner.nextInt();
                    contactKycServices.deleteContact(contactIdToDelete);

                case 9:
                    System.out.println("Exiting the application. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
