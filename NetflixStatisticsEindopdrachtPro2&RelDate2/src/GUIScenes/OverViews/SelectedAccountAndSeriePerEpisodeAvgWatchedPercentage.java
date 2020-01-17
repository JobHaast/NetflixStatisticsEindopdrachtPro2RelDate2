package GUIScenes.OverViews;

import GUIScenes.*;
import database.Read;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.Account;
import logic.EpisodeAvgWatchedSelAcc;

import java.util.ArrayList;

public class SelectedAccountAndSeriePerEpisodeAvgWatchedPercentage {
    public static Scene display(Stage stage, Read read, Account loggedPerson) {
        ArrayList<String> accountNames = read.getAccountsNames();
        ArrayList<String> serieNames = read.getSerieNames();

        //Gridpane for center
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        //Account select label
        Label accountNameLabel = new Label("AccountName:");
        gridPane.add(accountNameLabel, 0, 0);

        //Account select combobox
        ComboBox<String> accountNameComboBox = new ComboBox<>();
        accountNameComboBox.getItems().addAll(accountNames);
        gridPane.add(accountNameComboBox, 1, 0);

        //Serie select label
        Label serieLabel = new Label("Series:");
        gridPane.add(serieLabel, 0, 1);

        //Serie select combobox
        ComboBox<String> serieCombobox = new ComboBox<>();
        serieCombobox.getItems().addAll(serieNames);
        gridPane.add(serieCombobox, 1, 1);

        //Tabelview for episodes
        TableView<EpisodeAvgWatchedSelAcc> table = new TableView<>();
        table.setMaxWidth(800);

        TableColumn episodesName = new TableColumn("Episodes:");
        episodesName.setMinWidth(200);

        TableColumn avgWatchedPercentage = new TableColumn("Avg percentage watched:");
        avgWatchedPercentage.setMinWidth(200);

        TableColumn episodeNumber = new TableColumn("Episode number:");
        episodeNumber.setMinWidth(200);

        TableColumn seasonNumber = new TableColumn("Season number:");
        seasonNumber.setMinWidth(200);

        episodesName.setCellValueFactory(new PropertyValueFactory<>("nameEpisode"));
        avgWatchedPercentage.setCellValueFactory(new PropertyValueFactory<>("avgWatchedPercentage"));
        episodeNumber.setCellValueFactory(new PropertyValueFactory<>("episodeNumber"));
        seasonNumber.setCellValueFactory(new PropertyValueFactory<>("seasonNumber"));
        table.getColumns().addAll(seasonNumber, episodeNumber, episodesName, avgWatchedPercentage);
        table.setEditable(false);
        gridPane.add(table, 0, 2, 8, 1);

        serieCombobox.setOnAction(event -> {
            table.getItems().clear();
            ArrayList<EpisodeAvgWatchedSelAcc> episodes = read.getEpisodeAvgWatchedSelAcc(accountNameComboBox.getValue(), serieCombobox.getValue());
            ObservableList<EpisodeAvgWatchedSelAcc> data = FXCollections.observableArrayList(episodes);
            table.setItems(data);
        });

        accountNameComboBox.setOnAction(event -> {
            table.getItems().clear();
            ArrayList<EpisodeAvgWatchedSelAcc> episodes = read.getEpisodeAvgWatchedSelAcc(accountNameComboBox.getValue(), serieCombobox.getValue());
            ObservableList<EpisodeAvgWatchedSelAcc> data = FXCollections.observableArrayList(episodes);
            table.setItems(data);
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
