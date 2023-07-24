package KYC.model;

public class Address {
    private String city;
    private  String state;
    private String zipcode;
    private  String country;
    private int address_id;

    private int contact_id;

    private String street;


    public Address(String city, String state, String zipcode, String country, int address_id, int contact_id, String street) {
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.address_id = address_id;
        this.contact_id = contact_id;
        this.street = street;
    }

    public Address(String city, String state, String zipcode, String country, int contact_id,String street) {
        this();
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.contact_id = contact_id;
        this.street = street;
    }

    public Address() {

    }

    public Address(String street, String city, String state, String zipCode, String country, int contactId) {
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
