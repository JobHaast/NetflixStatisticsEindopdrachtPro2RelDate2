package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChecksTest {

    @Test
    void testcheckIfNotNullWithInputNullShouldReturnFalse() {
        //Arrange
        String testString = null;

        //Act
        boolean testCheck = Checks.checkIfNotNullOrEmptyString(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }

    @Test
    void testcheckIfNotNullWithInputtestShouldReturnTrue() {
        //Arrange
        String testString = "test";

        //Act
        boolean testCheck = Checks.checkIfNotNullOrEmptyString(testString);

        //Assert
        Assertions.assertTrue(testCheck);
    }

    @Test
    void testcheckIfNotNullWithInputEmptyStringShouldReturnFalse() {
        //Arrange
        String testString = "";

        //Act
        boolean testCheck = Checks.checkIfNotNullOrEmptyString(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }

    @Test
    void testcheckIfLettersOnlyWithInputtestShouldReturnTrue() {
        //Arrange
        String testString = "test";

        //Act
        boolean testCheck = Checks.checkIfLettersOnly(testString);

        //Assert
        Assertions.assertTrue(testCheck);
    }

    @Test
    void testcheckIfLettersOnlyWithInputtestandAllowedSpecialCharactersAndSpacesShouldReturnTrue() {
        //Arrange
        String testString = "test- \'. ";

        //Act
        boolean testCheck = Checks.checkIfLettersOnly(testString);

        //Assert
        Assertions.assertTrue(testCheck);
    }

    @Test
    void testcheckIfLettersOnlyWithInput12345ShouldReturnFalse() {
        //Arrange
        String testString = "12345";

        //Act
        boolean testCheck = Checks.checkIfLettersOnly(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }

    @Test
    void testcheckIfLettersOnlyWithInputEmptyStringShouldReturnTrue() {
        //Arrange
        String testString = "";

        //Act
        boolean testCheck = Checks.checkIfLettersOnly(testString);

        //Assert
        Assertions.assertTrue(testCheck);
    }

    @Test
    void testcheckIfNumbersOnlyWithInput1234ShouldReturnTrue() {
        //Arrange
        String testString = "1234";

        //Act
        boolean testCheck = Checks.checkIfNumbersOnly(testString);

        //Assert
        Assertions.assertTrue(testCheck);
    }

    @Test
    void testcheckIfNumbersOnlyWithInput123_4ShouldReturnTrue() {
        //Arrange
        String testString = "123 4";

        //Act
        boolean testCheck = Checks.checkIfNumbersOnly(testString);

        //Assert
        Assertions.assertTrue(testCheck);
    }

    @Test
    void testcheckIfNumbersOnlyWithInput123_4abcShouldReturnFalse() {
        //Arrange
        String testString = "123 4abc";

        //Act
        boolean testCheck = Checks.checkIfNumbersOnly(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }

    @Test
    void testcheckIfNumbersOnlyWithInputabcShouldReturnFalse() {
        //Arrange
        String testString = "abc";

        //Act
        boolean testCheck = Checks.checkIfNumbersOnly(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }

}