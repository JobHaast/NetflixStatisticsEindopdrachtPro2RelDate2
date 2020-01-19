package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringForTableViewTest {

    @Test
    void testgetStringWithInputStringForTableViewTestShouldReturnStringForTableView() {
        //Arrange
        StringForTableView stringForTableView = new StringForTableView("StringForTableView");

        //Act
        String result = stringForTableView.getString();

        //Assert
        Assertions.assertEquals("StringForTableView", result);
    }

    @Test
    void setString() {
        //Arrange
        StringForTableView stringForTableView = new StringForTableView("OldString");
        stringForTableView.setString("StringForTableView");

        //Act
        String result = stringForTableView.getString();

        //Assert
        Assertions.assertEquals("StringForTableView", result);
    }
}