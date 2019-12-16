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
}
