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

public class DeleteProfile {
    public static Scene display(Stage stage, Read read){
        Delete dA = new Delete("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");
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

        //onclick for profileNamesComboBox
        accountNameComboBox.setOnAction(event -> {
            profileNamesComboBox.getItems().clear();
            profileNamesComboBox.getItems().addAll(read.getProfileNames(accountNameComboBox.getValue()));
        });

        //Feedbacktext
        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 3);

        //Action when pause.play() is called
        pause.setOnFinished(e -> {
            actiontarget.setText(null);
        });

        Button submit = new Button("Submit");
        gridPane.add(submit,1,2);
        submit.setOnAction(event -> {
            String answer = dA.deleteProfile(profileNamesComboBox.getValue(), accountNameComboBox.getValue());
            if("Profile deleted".equals(answer)){
                accountNameComboBox.getItems().clear();
                accountNameComboBox.getItems().addAll(read.getAccountsNames());
                profileNamesComboBox.getItems().clear();
                profileNamesComboBox.getItems().addAll(read.getProfileNames(accountNameComboBox.getValue()));
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Profile deleted");
            }else if("Nothing deleted".equals(answer)){
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Profile not deleted");
            }
            pause.play();
        });

        Scene scene = new Scene(gridPane);
        return scene;
    }
}
