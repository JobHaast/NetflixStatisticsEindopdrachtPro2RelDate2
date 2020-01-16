package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void testgetEmailWithInputAccountWithEmailShouldReturnEmail() {
        //Arrange
        Account accountTest = new Account("accountName", "email@adres.com", "0612321437", "password", 12);

        //Act
        String result = accountTest.getEmail();

        //Assert
        Assertions.assertEquals("email@adres.com", result);
    }

    @Test
    void testgetPhoneNumberWithInputAccountWith0612321437ShouldReturn0612321437() {
        //Arrange
        Account accountTest = new Account("accountName", "email@adres.com", "0612321437", "password", 12);

        //Act
        String result = accountTest.getPhoneNumber();

        //Assert
        Assertions.assertEquals("0612321437", result);
    }

    @Test
    void testgetAddressWithInputAccountWithAdressShouldReturnAdress() {
        //Arrange
        Account accountTest = new Account("accountName", "email@adres.com", "0612321437", "password", 12);

        //Act
        int result = accountTest.getAddress();

        //Assert
        Assertions.assertEquals(12, result);
    }

    @Test
    void testgetAccountNameWithInputAccountWithAccountNameShouldReturnAccountName() {
        //Arrange
        Account accountTest = new Account("accountName", "email@adres.com", "0612321437", "password", 12);

        //Act
        String result = accountTest.getAccountName();

        //Assert
        Assertions.assertEquals("accountName", result);
    }

    @Test
    void testgetPasswordWithInputAccountWithPasswordpasswordShouldReturnpassword() {
        //Arrange
        Account accountTest = new Account("accountName", "email@adres.com", "0612321437", "password", 12);

        //Act
        String result = accountTest.getPassword();

        //Assert
        Assertions.assertEquals("password", result);
    }
}