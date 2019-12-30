package GUIScenes.CRUDActions;

import database.Read;
import database.Create;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CreateProfile {
    public static Scene display(Stage stage, Read read){
        Create cA = new Create("jdbc:sqlserver://localhost;databaseName=Login;integratedSecurity=true;");
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

        //Label for profile language
        Label profileLanguageLabel = new Label("Profile language:");
        gridPane.add(profileLanguageLabel, 0, 2);

        //Textfield for profile language
        TextField profileLanguageTextField = new TextField();
        gridPane.add(profileLanguageTextField, 1, 2);

        //Label for birthday
        Label birthdayLabel = new Label("Birthday:");
        gridPane.add(birthdayLabel, 0, 3);

        //Passwordfield for birthday
        TextField birthdayTextField = new TextField();
        gridPane.add(birthdayTextField, 1, 3);

        //Feedbacktext
        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 9);

        Button submit = new Button("Submit");
        gridPane.add(submit,0,8);
        submit.setOnAction(event -> {

        });

        Scene scene = new Scene(gridPane);
        return scene;
    }
}
