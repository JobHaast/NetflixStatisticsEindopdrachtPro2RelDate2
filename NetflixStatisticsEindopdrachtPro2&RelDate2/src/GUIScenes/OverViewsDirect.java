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
import javafx.scene.layout.BorderPane;
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
            stage.setScene(LongestMovieUnder16.display(stage, read, loggedPerson));
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
            stage.setScene(AvgWatchtimeSerie.display(stage, read, loggedPerson));
        });

        //Button for accounts with one profile
        Button oneProfile = new Button("Accounts with one profile");
        gridPane.add(oneProfile, 0, 1);
        oneProfile.setOnAction(event -> {
            stage.setScene(AllAccountsWithOneProfile.display(stage, read, loggedPerson));
        });

//GridPane for different tabs
        GridPane menu = new GridPane();
        menu.setAlignment(Pos.CENTER);
        menu.setHgap(20);
        menu.setVgap(20);
        menu.setPadding(new Insets(25, 25, 25, 25));

        //Button for profileoverview
        Button profileOverView = new Button("Profile");
        menu.add(profileOverView, 0, 0);

        //Button for logOut
        Button logOut = new Button("Log out");
        menu.add(logOut, 1, 0);

        //Button for CRUD scene
        Button cRUD = new Button("CRUD");
        menu.add(cRUD, 2, 0);

        //Button for programoverview
        Button programOverView = new Button("Program overview");
        menu.add(programOverView, 3, 0);

        //Button for longest movie for overviews
        Button overViews = new Button("Overviews");
        menu.add(overViews, 4, 0);

        //Onclick event for overviews
        overViews.setOnAction(event -> {
            stage.setScene(OverViewsDirect.display(stage, read, loggedPerson));
        });

        //Onclick event for logout
        logOut.setOnAction(event -> {
            stage.setScene(LoginScene.display(stage, read));
        });

        //Onclick event for button CRUD
        cRUD.setOnAction(event -> {
                    stage.setScene(CRUD.display(stage, read, loggedPerson));
                }
        );

        //Onclick event for profileoverview
        profileOverView.setOnAction(event -> {
            stage.setScene(ProfileOverView.display(stage, read, loggedPerson));
        });

        //Onclick event for programoverview
        programOverView.setOnAction(event -> {
            try {
                stage.setScene(ProgramOverView.display(stage, read, loggedPerson));
            }catch(Exception e){
                e.getMessage();
            }
        });

        //Borderpane for layout
        BorderPane mainScene = new BorderPane();
        mainScene.setBottom(menu);
        mainScene.setCenter(gridPane);

        Scene scene = new Scene(mainScene);
        return scene;
    }
}
