package Model;

public class Person {
    private String nationalRegisterNum, phoneNum, lastName, firstName, eMail, street, postalCode, city, houseNum;

    public Person(String nationalRegisterNum, String phoneNum, String lastName, String firstName, String eMail, String street, String postalCode, String city, String houseNum) {
        this.nationalRegisterNum = nationalRegisterNum;
        this.phoneNum = phoneNum;
        this.lastName = lastName;
        this.firstName = firstName;
        this.eMail = eMail;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.houseNum = houseNum;
    }
    public Person() {}

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getStreet() {
        return street;
    }

    public String getNationalRegisterNum() {
        return nationalRegisterNum;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationalRegisterNum(String nationalRegisterNum) {
        this.nationalRegisterNum = nationalRegisterNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNum() {
        return houseNum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nationalRegisterNum='" + nationalRegisterNum + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", houseNum=" + houseNum +
                '}';
    }
}
