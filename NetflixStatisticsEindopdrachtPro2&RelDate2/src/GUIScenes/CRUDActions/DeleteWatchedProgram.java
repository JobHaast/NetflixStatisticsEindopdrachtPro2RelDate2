package GUIScenes.CRUDActions;

import database.Delete;
import database.Read;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class DeleteWatchedProgram {
        public static Scene display(Stage stage, Read read) {
            ArrayList<String> namesAccounts = read.getAccountsNames();
            Delete dWP = new Delete("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");
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

            //Label for watched programs
            Label program = new Label("Program: ");
            gridPane.add(program, 0, 2);

            //combobox for watched programs
            ComboBox<String> programTitles = new ComboBox<>();
            gridPane.add(programTitles, 1, 2);

            //Button for sumbitting
            Button submit = new Button("Submit");
            gridPane.add(submit, 1, 3);

            //Feedbacktext
            final Text actiontarget = new Text();
            gridPane.add(actiontarget, 1, 4);

            //Action when pause.play() is called
            pause.setOnFinished(e -> {
                actiontarget.setText(null);
                accountNameComboBox.getItems().clear();
                accountNameComboBox.getItems().addAll(namesAccounts);
                profileNamesComboBox.getItems().clear();
                programTitles.getItems().clear();
            });

            //onclick for accountNamesComboBox
            accountNameComboBox.setOnAction(event -> {
                profileNamesComboBox.getItems().clear();
                profileNamesComboBox.getItems().addAll(read.getProfileNames(accountNameComboBox.getValue()));
            });

            //onclick for profileNamescomboBox
            profileNamesComboBox.setOnAction(event -> {
                programTitles.getItems().clear();
                programTitles.getItems().addAll(read.getWatchedPrograms(accountNameComboBox.getValue(), profileNamesComboBox.getValue()));
            });

            //Onclick for submit
            submit.setOnAction(event -> {
                if("Watched program deleted".equals(dWP.deleteWatchedProgram(accountNameComboBox.getValue(), profileNamesComboBox.getValue(), read.getProgramId(programTitles.getValue())))){
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Watched program deleted successfully");
                }else{
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Watched program not deleted");
                }
                pause.play();
            });

            Scene scene = new Scene(gridPane);
            return scene;
        }
}
