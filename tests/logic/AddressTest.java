package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void testgetNumberWithInputAddressWithNumber12ShouldReturn12() {
        //Arrange
        Address testAddress = new Address("bomenlaan", 12, "a", "CityOfPalms");

        //Act
        int result = testAddress.getNumber();

        //Assert
        Assertions.assertEquals(12, result);
    }

    @Test
    void testgetAdditionWithInputAddressWithAdditionaShouldReturna() {
        //Arrange
        Address testAddress = new Address("bomenlaan", 12, "a", "CityOfPalms");

        //Act
        String result = testAddress.getAddition();

        //Assert
        Assertions.assertEquals("a", result);
    }

    @Test
    void testgetStreetNameWithInputAddressWithStreetNamebomenlaanShouldReturnbomenlaan() {
        //Arrange
        Address testAddress = new Address("bomenlaan", 12, "a", "CityOfPalms");

        //Act
        String result = testAddress.getStreetName();

        //Assert
        Assertions.assertEquals("bomenlaan", result);
    }

    @Test
    void testgetCityWithInputAddressWithCityOfPalmsShouldReturnCityOfPalms() {
        //Arrange
        Address testAddress = new Address("bomenlaan", 12, "a", "CityOfPalms");

        //Act
        String result = testAddress.getCity();

        //Assert
        Assertions.assertEquals("CityOfPalms", result);
    }

    @Test
    void testToStringWithInputAddressShouldReturnstreetNamenumberadditioncity(){
        //Arrange
        Address testAddress = new Address("bomenlaan", 12, "a", "CityOfPalms");

        //Act
        String result = testAddress.toString();

        //Assert
        Assertions.assertEquals("bomenlaan 12a CityOfPalms", result);
    }
}