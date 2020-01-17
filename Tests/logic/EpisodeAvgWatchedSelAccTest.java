package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpisodeAvgWatchedSelAccTest {

    @Test
    void testgetEpisodeNumberWithInputEpisodeAvgWatchedSelAccTestWithEpisodeNumberOneShouldReturnOne() {
        //Arrange
        EpisodeAvgWatchedSelAcc test = new EpisodeAvgWatchedSelAcc(1, 1, "NameEpisode", 65);

        //Act
        int result = test.getEpisodeNumber();

        //Assert
        Assertions.assertEquals(1, result);
    }

    @Test
    void testgetSeasonNumberWithInputEpisodeAvgWatchedSelAccTestWithSeasonNumberOneShouldReturnOne() {
        //Arrange
        EpisodeAvgWatchedSelAcc test = new EpisodeAvgWatchedSelAcc(1, 1, "NameEpisode", 65);

        //Act
        int result = test.getSeasonNumber();

        //Assert
        Assertions.assertEquals(1, result);
    }

    @Test
    void testgetNameEpisodeWithInputEpisodeAvgWatchedSelAccTestWithEpisodeNameShouldReturnEpisodeName() {
        //Arrange
        EpisodeAvgWatchedSelAcc test = new EpisodeAvgWatchedSelAcc(1, 1, "NameEpisode", 65);

        //Act
        String result = test.getNameEpisode();

        //Assert
        Assertions.assertEquals("NameEpisode", result);
    }

    @Test
    void testgetAvgWatchedPercentageWithInputEpisodeAvgWatchedSelAccTestWithPercentage65ShouldReturn65() {
        //Arrange
        EpisodeAvgWatchedSelAcc test = new EpisodeAvgWatchedSelAcc(1, 1, "NameEpisode", 65);

        //Act
        int result = test.getAvgWatchedPercentage();

        //Assert
        Assertions.assertEquals(65, result);
    }

    @Test
    void testsetEpisodeNumberWithInputEpisodeAvgWatchedSelAccTestWithEpisodeNumberOneShouldReturnOne() {
        //Arrange
        EpisodeAvgWatchedSelAcc test = new EpisodeAvgWatchedSelAcc(1, 1, "NameEpisode", 65);
        test.setEpisodeNumber(2);

        //Act
        int result = test.getEpisodeNumber();

        //Assert
        Assertions.assertEquals(2, result);
    }

    @Test
    void testsetNameEpisodeWithInputEpisodeAvgWatchedSelAccTestWithEpisodeNameShouldReturnEpisodeName() {
        //Arrange
        EpisodeAvgWatchedSelAcc test = new EpisodeAvgWatchedSelAcc(1, 1, "NameEpisode", 65);
        test.setNameEpisode("NewName");
        //Act
        String result = test.getNameEpisode();

        //Assert
        Assertions.assertEquals("NewName", result);
    }

    @Test
    void testsetSeasonNumberWithInputEpisodeAvgWatchedSelAccTestWithSeasonNumberOneShouldReturnOne() {
        //Arrange
        EpisodeAvgWatchedSelAcc test = new EpisodeAvgWatchedSelAcc(1, 1, "NameEpisode", 65);
        test.setSeasonNumber(2);
        //Act
        int result = test.getSeasonNumber();

        //Assert
        Assertions.assertEquals(2, result);
    }

    @Test
    void testsetAvgWatchedPercentageWithInputEpisodeAvgWatchedSelAccTestWithPercentage65ShouldReturn65() {
        //Arrange
        EpisodeAvgWatchedSelAcc test = new EpisodeAvgWatchedSelAcc(1, 1, "NameEpisode", 65);
        test.setAvgWatchedPercentage(90);
        //Act
        int result = test.getAvgWatchedPercentage();

        //Assert
        Assertions.assertEquals(90, result);
    }
}