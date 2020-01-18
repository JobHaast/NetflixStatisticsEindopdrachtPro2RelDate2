package GUIScenes.CRUDActions;

import GUIScenes.*;
import database.Read;
import database.Update;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Account;
import logic.Checks;

import java.util.ArrayList;

public class UpdateWatchedProgram {
    public static Scene display(Stage stage, Read read, Account loggedPerson){
        Update uWP = new Update("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");
        ArrayList<String> namesAccounts = read.getAccountsNames();
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        //CRUD Scene
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        //Backgroundcolor for gridpane
        Color backgroundColor = Color.web("rgb(100, 97, 97)");
        gridPane.backgroundProperty().set(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));

        //Label for AccountName
        Label accountNameLabel = new Label("Account Name:");
        gridPane.add(accountNameLabel, 0, 0);

        //combobox for accountname
        ComboBox<String> accountNameComboBox = new ComboBox<>();
        accountNameComboBox.getItems().addAll(namesAccounts);
        gridPane.add(accountNameComboBox, 1, 0);

        //Label for profilenames
        Label profileNameLabel = new Label("Profile Name:");
        gridPane.add(profileNameLabel, 0, 1);

        //combobox for profilenames
        ComboBox<String> profileNamesComboBox = new ComboBox<>();
        gridPane.add(profileNamesComboBox, 1, 1);

        //onclick for accountnamecombobox
        accountNameComboBox.setOnAction(event -> {
            profileNamesComboBox.getItems().clear();
            profileNamesComboBox.getItems().addAll(read.getProfileNames(accountNameComboBox.getValue()));
        });

        //Label for program
        Label program = new Label("Program:");
        gridPane.add(program, 0, 2);

        //combobox for watched programs
        ComboBox<String> watchedProgramsComboBox = new ComboBox<>();
        gridPane.add(watchedProgramsComboBox, 1, 2);

        //onclick for profilenamescombobox
        profileNamesComboBox.setOnAction(event -> {
            watchedProgramsComboBox.getItems().addAll(read.getWatchedPrograms(accountNameComboBox.getValue(), profileNamesComboBox.getValue()));
        });

        //label for percentage watched
        Label percentageWatchedLabel = new Label("Percentage watched");
        gridPane.add(percentageWatchedLabel, 0, 3);

        //Textfield for percentage watched
        TextField percentageWatchedTextField = new TextField();
        gridPane.add(percentageWatchedTextField, 1, 3);

        //Text for feedback percentage watched
        final Text feedbackTextPercentageWatched = new Text();
        gridPane.add(feedbackTextPercentageWatched, 2, 3);

        //Feedbacktext
        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 5);

        //Action when pause.play() is called
        pause.setOnFinished(e -> {
            actiontarget.setText(null);
            feedbackTextPercentageWatched.setText(null);
        });

        Button submit = new Button("Submit");
        gridPane.add(submit,1,4);
        submit.setOnAction(event -> {
            if (Checks.checkIfNotNullOrEmptyString(accountNameComboBox.getValue()) && Checks.checkIfNotNullOrEmptyString(profileNamesComboBox.getValue()) &&
                    Checks.checkIfNotNullOrEmptyString(watchedProgramsComboBox.getValue()) && Checks.checkIfNotNullOrEmptyString(percentageWatchedTextField.getText())) {
                if (Checks.checkIfNumbersOnly(percentageWatchedTextField.getText())) {
                    if (Checks.checkIfNumberWithin1and100(percentageWatchedTextField.getText())) {
                        if ("Watched program updated".equals(uWP.updateWatchedProgram(accountNameComboBox.getValue(), profileNamesComboBox.getValue(), read.getProgramId(watchedProgramsComboBox.getValue()), Integer.parseInt(percentageWatchedTextField.getText())))) {
                            actiontarget.setFill(Color.GREEN);
                            actiontarget.setText("Profile updated");
                        } else {
                            actiontarget.setFill(Color.FIREBRICK);
                            actiontarget.setText("Profile not updated");
                        }
                    } else {
                        feedbackTextPercentageWatched.setFill(Color.FIREBRICK);
                        feedbackTextPercentageWatched.setText("Please fill in a number between 0 and 100");
                    }
                } else {
                    feedbackTextPercentageWatched.setFill(Color.FIREBRICK);
                    feedbackTextPercentageWatched.setText("Please fill in numbers only");
                }
            } else {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Please fill in all the fields");
            }
            pause.play();
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
