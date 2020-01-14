package GUIScenes.CRUDActions;

import database.Create;
import database.Read;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class CreateWatchedProgram {
    public static Scene display(Stage stage, Read read) {
        ArrayList<String> namesAccounts = read.getAccountsNames();
        ArrayList<String> titlesPrograms = read.getTitlePrograms();
        Create cWP = new Create("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");
        PauseTransition pause = new PauseTransition(Duration.seconds(3));

        //CRUD Scene
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

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

        //Label for programnames
        Label program = new Label("Program: ");
        gridPane.add(program, 0, 2);

        //combobox for programnames
        ComboBox<String> programTitles = new ComboBox<>();
        programTitles.getItems().addAll(titlesPrograms);
        gridPane.add(programTitles, 1, 2);

        //Label for percentage watched
        Label percentageWatchedLabel = new Label("Percentage watched: ");
        gridPane.add(percentageWatchedLabel, 0, 3);

        //Textfield for percentage watched
        TextField textFieldPercentageWatched = new TextField();
        gridPane.add(textFieldPercentageWatched, 1, 3);

        //Button for sumbitting
        Button submit = new Button("Submit");
        gridPane.add(submit, 1, 4);

        //Feedbacktext
        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 5);

        //Action when pause.play() is called
        pause.setOnFinished(e -> {
            actiontarget.setText(null);
            programTitles.getItems().clear();
            programTitles.getItems().addAll(titlesPrograms);
            textFieldPercentageWatched.setText(null);
        });

        //onclick for profileNamesComboBox
        accountNameComboBox.setOnAction(event -> {
            profileNamesComboBox.getItems().clear();
            profileNamesComboBox.getItems().addAll(read.getProfileNames(accountNameComboBox.getValue()));
        });

        //Onclick for submit
        submit.setOnAction(event -> {
            if("Watched program created".equals(cWP.createWatchedProgram(accountNameComboBox.getValue(), profileNamesComboBox.getValue(), programTitles.getValue(), Integer.parseInt(textFieldPercentageWatched.getText()) ,read))){
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Succesfully added");
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Error");
            }
            pause.play();
        });

        Scene scene = new Scene(gridPane);
        return scene;
    }
}
