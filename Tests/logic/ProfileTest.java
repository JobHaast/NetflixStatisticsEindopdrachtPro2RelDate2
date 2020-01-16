package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    @Test
    void testgetAgeWithInputProfileWithAge20ShouldReturn20() {
        //Arrange
        Profile testProfile = new Profile("Mario", "Nederlands", 20);

        //Act
        int result = testProfile.getAge();

        //Assert
        Assertions.assertEquals(20 , result);
    }

    @Test
    void testggetProfileLanguageWithInputProfileWithProfileLanguageNederlandsShouldReturnNederlands() {
        //Arrange
        Profile testProfile = new Profile("Mario", "Nederlands", 20);

        //Act
        String result = testProfile.getProfileLanguage();

        //Assert
        Assertions.assertEquals("Nederlands" , result);
    }

    @Test
    void testggetProfileNameWithInputProfileWithProfileNameMarioShouldReturnPeach() {
        //Arrange
        Profile testProfile = new Profile("Mario", "Nederlands", 20);

        //Act
        String result = testProfile.getProfileName();

        //Assert
        Assertions.assertEquals("Mario" , result);
    }

    @Test
    void testtoStringWithInputProfileShouldReturn() {
        //Arrange
        Profile testProfile = new Profile("Mario", "Nederlands", 20);

        //Act
        String result = testProfile.toString();

        //Assert
        Assertions.assertEquals("Profilename: Mario\nProfilelanguage: Nederlands\nAge: 20", result);
    }
}