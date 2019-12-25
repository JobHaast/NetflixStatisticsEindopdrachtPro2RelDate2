package logic;

public class Account {
    private String accountName;
    private String email;
    private String phoneNumber;
    private Address address;

    public Account(String accountName, String email, String phoneNumber, Address address){
        this.accountName = accountName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public String getAccountName() {
        return accountName;
    }
}
