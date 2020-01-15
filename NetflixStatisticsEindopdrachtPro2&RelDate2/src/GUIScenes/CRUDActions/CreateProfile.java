package GUIScenes.CRUDActions;

import database.Read;
import database.Create;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CreateProfile {
    public static Scene display(Stage stage, Read read){
        Create cP = new Create("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");
        ArrayList<String> namesAccounts = read.getAccountsNames();

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

        //Label for profilename
        Label profileNameLabel = new Label("Profile name:");
        gridPane.add(profileNameLabel, 0, 1);

        //Textfield for profilename
        TextField profileNameTextField = new TextField();
        gridPane.add(profileNameTextField, 1, 1);

        //Lable for langue
        Label languageLabel = new Label("Language:");
        gridPane.add(languageLabel, 0, 2);

        //combobox for languages
        ComboBox<String> languagesComboBox = new ComboBox<>();
        languagesComboBox.getItems().addAll("Nederlands", "English");
        gridPane.add(languagesComboBox, 1, 2);

        //Label for birthday
        Label birthdayLabel = new Label("Birthday");
        gridPane.add(birthdayLabel, 0, 3);

        //datepicker for birthday
        DatePicker birthdayDatePicker = new DatePicker();
        gridPane.add(birthdayDatePicker, 1, 3);

        //Feedbacktext
        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 5);

        Button submit = new Button("Submit");
        gridPane.add(submit,1,4);
        submit.setOnAction(event -> {
            if("Profile created".equals(cP.createProfile(accountNameComboBox.getValue(), profileNameTextField.getText(), languagesComboBox.getValue(), birthdayDatePicker.getValue().toString()))){
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Profile created successfully");
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Profile not created");
            }

        });

        Scene scene = new Scene(gridPane);
        return scene;
    }
}
