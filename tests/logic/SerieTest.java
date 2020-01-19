package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerieTest {

    @Test
    void testgetLanguageWithInputSerieWithLanguageEnglishShouldReturnEnglish() {
        //Arrange
        Serie testSerie = new Serie("Breaking Bad", "English", "Thriller", "Sherlock");

        //Act
        String result = testSerie.getLanguage();

        //Assert
        Assertions.assertEquals("English", result);
    }

    @Test
    void testgetGenreWithInputSerieWithGenreThrillerShouldReturnThriller() {
        //Arrange
        Serie testSerie = new Serie("Breaking Bad", "English", "Thriller", "Sherlock");

        //Act
        String result = testSerie.getGenre();

        //Assert
        Assertions.assertEquals("Thriller", result);
    }

    @Test
    void testgetTitleWithInputSerieWithTitleBreakingBadShouldReturnBreakingBad() {
        //Arrange
        Serie testSerie = new Serie("Breaking Bad", "English", "Thriller", "Sherlock");

        //Act
        String result = testSerie.getTitle();

        //Assert
        Assertions.assertEquals("Breaking Bad", result);
    }

    @Test
    void testgetRecommandationWithInputSerieWithRecommandationSherlockShouldReturnSherlock() {
        //Arrange
        Serie testSerie = new Serie("Breaking Bad", "English", "Thriller", "Sherlock");

        //Act
        String result = testSerie.getRecommendation();

        //Assert
        Assertions.assertEquals("Sherlock", result);
    }
}