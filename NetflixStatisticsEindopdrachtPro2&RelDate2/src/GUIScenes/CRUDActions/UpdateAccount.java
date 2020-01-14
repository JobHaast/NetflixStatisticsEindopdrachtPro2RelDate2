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

public class UpdateAccount {
    public static Scene display(Stage stage, Read read, Account loggedPerson){
        Update uA = new Update("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        ArrayList<String> namesAccounts = read.getAccountsNames();

        //Gridpane for layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        //Label for AccountName
        Label accountNameLabel = new Label("Account Name: ");
        gridPane.add(accountNameLabel, 0, 0);

        //combobox for accountname
        ComboBox<String> accountNameComboBox = new ComboBox<>();
        accountNameComboBox.getItems().addAll(namesAccounts);
        gridPane.add(accountNameComboBox, 1, 0);

        //Label for email
        Label emailLabel = new Label("New email: ");
        gridPane.add(emailLabel, 0, 1);

        //Textfield for email
        TextField emailTextField = new TextField();
        gridPane.add(emailTextField, 1, 1);

        //Label for phonenumber
        Label phonenumberLabel = new Label("New phonenumber: ");
        gridPane.add(phonenumberLabel, 0, 2);

        //textfield for phonenumber
        TextField phonenumberTextField = new TextField();
        gridPane.add(phonenumberTextField, 1, 2);

        //Password label
        Label passwordLabel = new Label("New password: ");
        gridPane.add(passwordLabel, 0, 3);

        //password passwordfield
        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 3);

        //Button for submit
        Button submit = new Button("Change");
        gridPane.add(submit, 1, 4);

        //Feedbacktext
        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 5);

        //Action when pause.play() is called
        pause.setOnFinished(e -> {
            actiontarget.setText(null);
        });

        submit.setOnAction(event -> {
            if("Account updated".equals(uA.updateAccount(accountNameComboBox.getValue(), emailTextField.getText(), phonenumberTextField.getText(), passwordField.getText()))){
                ArrayList<String> names = read.getAccountsNames();
                accountNameComboBox.getItems().clear();
                accountNameComboBox.getItems().addAll(names);
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Account updated");
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Account not updated");
            }
            pause.play();
        });


        Scene scene = new Scene(gridPane);
        return scene;
    }
}
