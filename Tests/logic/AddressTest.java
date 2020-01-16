package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void testgetNumberWithInputAccountWithNumber12ShouldReturn12() {
        //Arrange
        Address testAddress = new Address("bomenlaan", 12, "a", "CityOfPalms");

        //Act
        int result = testAddress.getNumber();

        //Assert
        Assertions.assertEquals(12, result);
    }

    @Test
    void getAddition() {
    }

    @Test
    void getStreetName() {
    }

    @Test
    void getCity() {
    }
}