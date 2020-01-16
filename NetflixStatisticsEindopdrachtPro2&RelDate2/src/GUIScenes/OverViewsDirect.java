package GUIScenes;

import GUIScenes.OverViews.AllAccountsWithOneProfile;
import GUIScenes.OverViews.AvgWatchtimeSerie;
import GUIScenes.OverViews.FilmsWatched;
import GUIScenes.OverViews.LongestMovieUnder16;
import database.Read;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.Account;

public class OverViewsDirect {
    public static Scene display(Stage stage, Read read, Account loggedPerson) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        //Button for longest movie under 16
        Button longestMovieUnder16 = new Button("Longest movie under 16");
        gridPane.add(longestMovieUnder16, 0, 0);
        longestMovieUnder16.setOnAction(event -> {
            stage.setScene(LongestMovieUnder16.display(stage, read));
        });

        //Button for FilmsWatched
        Button filmsWatched = new Button("Films watched");
        gridPane.add(filmsWatched, 1, 0);
        filmsWatched.setOnAction(event -> {
            stage.setScene(FilmsWatched.display(stage, read, loggedPerson));
        });

        //Button for avgwatchedtimeSerie
        Button avgWatchedTimeSerie = new Button("Average watched time series");
        gridPane.add(avgWatchedTimeSerie, 2, 0);
        avgWatchedTimeSerie.setOnAction(event -> {
            stage.setScene(AvgWatchtimeSerie.display(stage, read));
        });

        //Button for accounts with one profile
        Button oneProfile = new Button("Accounts with one profile");
        gridPane.add(oneProfile, 0, 1);
        oneProfile.setOnAction(event -> {
            stage.setScene(AllAccountsWithOneProfile.display(stage, read));
        });


        Scene scene = new Scene(gridPane);
        return scene;
    }
}
