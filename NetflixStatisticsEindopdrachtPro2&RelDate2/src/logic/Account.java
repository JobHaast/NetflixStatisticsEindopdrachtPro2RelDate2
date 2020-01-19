package logic;

public class Account {
    private String accountName;
    private String email;
    private String phoneNumber;
    private String password;
    private int addressId;

    public Account(String accountName, String email, String phoneNumber, String password, int address) {
        this.accountName = accountName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.addressId = address;
    }


    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAddress() {
        return addressId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }
}
