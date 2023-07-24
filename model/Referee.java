package KYC.model;

public class Referee {
    private int refereeId;
    private String name;
    private String profession;
    private String phoneNumber;
    private int addressId;

    public Referee(int refereeId, String name, String profession, String phoneNumber, int addressId) {
        this.refereeId = refereeId;
        this.name = name;
        this.profession = profession;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
    }

    public Referee(String name, String profession, String phoneNumber, int addressId) {
        this();
        this.name = name;
        this.profession = profession;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
    }

    public Referee() {

    }

    public int getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(int refereeId) {
        this.refereeId = refereeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = Integer.parseInt(addressId);
    }

}