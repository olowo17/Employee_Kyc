package KYC;

public class Address {
    private String street;
    private  int addressId;

    private  int contactId;

    private String city;
    private  String state;
    private  String country;

    public Address(String street, int addressId, int contactId, String city, String state, String country, String zipCode) {
        this.street = street;
        this.addressId = addressId;
        this.contactId = contactId;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
    public Address(String street, int contactId, String city, String state, String country, String zipCode) {
        this.street = street;
        this.contactId = contactId;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    private String zipCode;
}
