package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    @Test
    void testgetTitleWithInputFilmWithTitleTheBigPeachShouldReturnTheBigPeach() {
        //Arrange
        Film testFilm = new Film("TheBigPeach", 120, "American English", "humor", "12");

        //Act
        String result = testFilm.getTitle();

        //Assert
        Assertions.assertEquals("TheBigPeach", result);
    }

    @Test
    void testgetLengthWithInputFilmWithLength120ShouldReturn120() {
        //Arrange
        Film testFilm = new Film("TheBigPeach", 120, "American English", "humor", "12");

        //Act
        int result = testFilm.getLength();

        //Assert
        Assertions.assertEquals(120 , result);
    }

    @Test
    void testgetAgeGroupWithInputFilmWithAgeGroup12ShouldReturn12() {
        //Arrange
        Film testFilm = new Film("TheBigPeach", 120, "American English", "humor", "12");

        //Act
        String result = testFilm.getAgeGroup();

        //Assert
        Assertions.assertEquals("12", result);
    }

    @Test
    void testgetGenreWithInputFilmWithGenreHumorShouldReturnHumor() {
        //Arrange
        Film testFilm = new Film("TheBigPeach", 120, "American English", "humor", "12");

        //Act
        String result = testFilm.getGenre();

        //Assert
        Assertions.assertEquals("humor", result);
    }

    @Test
    void testgetLanguageWithInputFilmWithLanguageAmericanEnglishShouldReturnAmericanEnglish() {
        //Arrange
        Film testFilm = new Film("TheBigPeach", 120, "American English", "humor", "12");

        //Act
        String result = testFilm.getLanguage();

        //Assert
        Assertions.assertEquals("American English", result);
    }
}