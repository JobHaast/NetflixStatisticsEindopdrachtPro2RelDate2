package GUIScenes;

import GUIScenes.OverViews.*;
import database.Read;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import logic.Account;

public class OverViewsDirect {
    public static Scene display(Stage stage, Read read, Account loggedPerson) {
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        //Set background color
        Color backgroundColor = Color.web("rgb(100, 97, 97)");
        gridPane.backgroundProperty().set(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));

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

        //Button for class amount of times watched movie 100 percent
        Button amount100Percent = new Button("Amount of times movie fully watched");
        gridPane.add(amount100Percent, 1, 1);
        amount100Percent.setOnAction(event -> {
            stage.setScene(AmountOfTimesWatchedMovie100Percent.display(stage, read, loggedPerson));
        });

        //Button for class selectedAccountAndSeriePerEpisodeAvgWatchedPercentage
        Button selectedAccountAndSeriePerEpisodeAvgWatchedPercentage = new Button("Watched percentage of episode with an account selected");
        gridPane.add(selectedAccountAndSeriePerEpisodeAvgWatchedPercentage, 2, 1);
        selectedAccountAndSeriePerEpisodeAvgWatchedPercentage.setOnAction(event -> {
            stage.setScene(SelectedAccountAndSeriePerEpisodeAvgWatchedPercentage.display(stage, read, loggedPerson));
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

        //Set background color
        Color backgroundColorUnder = Color.web("rgb(77, 73, 73)");
        mainScene.backgroundProperty().set(new Background(new BackgroundFill(backgroundColorUnder, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(mainScene, screenSize.getWidth(), screenSize.getHeight()*0.978);
        return scene;
    }
}
