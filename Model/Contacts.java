package Model;

public class Contacts 
{
    private String firstName;
    private	String lastnames;
    private	String address;
    private	String city;
    private	String state;
    private	int zip;
    private	long phoneNumber;
    private	String email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastnames() {
        return lastnames;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    /////////////////////////sett/////////////////////////

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "firstName='" + firstName + '\'' +
                ", lastnames='" + lastnames + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}