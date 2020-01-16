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
        boolean testCheck = Checks.checkIfCorrectBirthdayFormat(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }

    @Test
    void testcheckIfCorrectBirthdayFormatWithInput2001_11_13ShouldReturnTrue(){
        //Arrange
        String testString = "2001-11-13";

        //Act
        boolean testCheck = Checks.checkIfCorrectBirthdayFormat(testString);

        //Assert
        Assertions.assertTrue(testCheck);
    }

    @Test
    void testcheckIfCorrectBirthdayFormatWithInput2001_12_29ShouldReturnTrue(){
        //Arrange
        String testString = "2001-12-29";

        //Act
        boolean testCheck = Checks.checkIfCorrectBirthdayFormat(testString);

        //Assert
        Assertions.assertTrue(testCheck);
    }

    @Test
    void testcheckIfCorrectBirthdayFormatWithInput2001_12_31ShouldReturnTrue(){
        //Arrange
        String testString = "2001-12-31";

        //Act
        boolean testCheck = Checks.checkIfCorrectBirthdayFormat(testString);

        //Assert
        Assertions.assertTrue(testCheck);
    }

    @Test
    void testcheckIfCorrectBirthdayFormatWithInput2001_13_30ShouldReturnFalse(){
        //Arrange
        String testString = "2001-13-30";

        //Act
        boolean testCheck = Checks.checkIfCorrectBirthdayFormat(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }

    @Test
    void testcheckIfCorrectBirthdayFormatWithInput2019_12_32ShouldReturnFalse(){
        //Arrange
        String testString = "2019-12-32";

        //Act
        boolean testCheck = Checks.checkIfCorrectBirthdayFormat(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }

    @Test
    void testcheckIfCorrectBirthdayFormatWithInput2019_13_32ShouldReturnFalse(){
        //Arrange
        String testString = "2019-13-32";

        //Act
        boolean testCheck = Checks.checkIfCorrectBirthdayFormat(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }

    @Test
    void testcheckIfCorrectBirthdayFormatWithInput2019slash12slash10ShouldReturnFalse() {
        //Arrange
        String testString = "2019/12/10";

        //Act
        boolean testCheck = Checks.checkIfCorrectBirthdayFormat(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }

    @Test
    void testcheckIfCorrectBirthdayFormatWithInput99_12_10ShouldReturnFalse() {
        //Arrange
        String testString = "99-12-10";

        //Act
        boolean testCheck = Checks.checkIfCorrectBirthdayFormat(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }

    @Test
    void testcheckIfCorrectBirthdayFormatWithInput2019_01_31ShouldReturnTrue(){
        //Arrange
        String testString = "2019-01-31";

        //Act
        boolean testCheck = Checks.checkIfCorrectBirthdayFormat(testString);

        //Assert
        Assertions.assertTrue(testCheck);
    }

    @Test
    void testcheckIfCorrectBirthdayFormatWithInput20019_12_10ShouldReturnFalse() {
        //Arrange
        String testString = "20019-12-10";

        //Act
        boolean testCheck = Checks.checkIfCorrectBirthdayFormat(testString);

        //Assert
        Assertions.assertFalse(testCheck);
    }




}