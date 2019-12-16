package logic;

public class Account {
    private String accountName;
    private String email;
    private String phoneNumber;
    private String password;
    private Address address;

    public Account(String accountName, String email, String phoneNumber, String password, Address address){
        this.accountName = accountName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
