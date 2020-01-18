package GUIScenes.OverViews;

import GUIScenes.*;
import database.Read;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import logic.Account;
import logic.StringForTableView;

import java.util.ArrayList;

public class AllAccountsWithOneProfile {
    public static Scene display(Stage stage, Read read, Account loggedPerson) {
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        //Backgroundcolor for gridpane
        Color backgroundColor = Color.web("rgb(100, 97, 97)");
        gridPane.backgroundProperty().set(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));

        // Scene Tableview
        final Label label = new Label("Accounts with one profile:");
        label.setFont(new Font("Arial", 20));
        gridPane.add(label, 0, 0);

        TableView<StringForTableView> table = new TableView<>();
        table.setMaxWidth(500);

        TableColumn movieTitle = new TableColumn("Account name");
        movieTitle.setMinWidth(500);

        movieTitle.setCellValueFactory(new PropertyValueFactory<>("string"));
        table.getColumns().add(movieTitle);
        table.setEditable(false);
        gridPane.add(table, 0, 1, 8, 1);

        ArrayList<StringForTableView> films = read.getAccountsWithOneProfile();
        ObservableList<StringForTableView> data = FXCollections.observableArrayList(films);
        table.setItems(data);

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
