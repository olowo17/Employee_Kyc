package KYC.model;

public class Contact {
    private int id;
    private String firstName;
    private  String lastName;

    private String phoneNumber;
    private String sex;
    private String dob;

    public Contact (String firstName, String lastName, String phoneNumber, String sex, String dob){
        this();
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber =phoneNumber;
        this.sex =sex;
        this.dob =dob;
    }

    public Contact(int id, String firstName, String lastName, String phoneNumber, String sex, String dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.dob = dob;
    }

    public Contact() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sex='" + sex + '\'' +
                ", dob=" + dob +
                '}';
    }
}
