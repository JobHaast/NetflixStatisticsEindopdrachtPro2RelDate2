package GUIScenes.CRUDActions;

import database.Read;
import database.Update;
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
import logic.Account;

import java.util.ArrayList;

public class UpdateWatchedProgram {
    public static Scene display(Stage stage, Read read, Account loggedPerson){
        Update uWP = new Update("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");
        ArrayList<String> namesAccounts = read.getAccountsNames();
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

        //Feedbacktext
        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 5);

        //Action when pause.play() is called
        pause.setOnFinished(e -> {
            actiontarget.setText(null);
        });

        Button submit = new Button("Submit");
        gridPane.add(submit,1,4);
        submit.setOnAction(event -> {
            if("Watched program updated".equals(uWP.updateWatchedProgram(accountNameComboBox.getValue(), profileNamesComboBox.getValue(), read.getProgramId(watchedProgramsComboBox.getValue()), Integer.parseInt(percentageWatchedTextField.getText())))){
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Profile updated");
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Profile not updated");
            }
            pause.play();
        });

        Scene scene = new Scene(gridPane);
        return scene;
    }
}
