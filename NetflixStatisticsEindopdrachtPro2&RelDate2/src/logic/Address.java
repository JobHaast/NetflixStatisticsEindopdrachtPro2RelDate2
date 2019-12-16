package logic;

public class Address {
    private String adressid;
    private String streetName;
    private int number;
    private String addition;
    private String city;

    public Address(String streetName, int number, String addition, String city){
        this.streetName = streetName;
        this.number = number;
        this.addition = addition;
        this.city = city;
    }

    public Address(String streetName, int number, String city){
        this(streetName, number, "", city);
    }

    public int getNumber() {
        return number;
    }

    public String getAddition() {
        return addition;
    }

    public String getAdressid() {
        return adressid;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return streetName + " " + number+addition + " " + city;
    }
}
