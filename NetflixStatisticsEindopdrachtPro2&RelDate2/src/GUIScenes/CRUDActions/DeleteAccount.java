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

public class DeleteAccount {
    public static Scene display(Stage stage, Read read){
        Delete dA = new Delete("jdbc:sqlserver://localhost;databaseName=Login;integratedSecurity=true;");
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
            if("Account deleted".equals(dA.deleteAccount(accountNameComboBox.getValue()))){
                ArrayList<String> names = read.getAccountsNames();
                accountNameComboBox.getItems().clear();
                accountNameComboBox.getItems().addAll(names);
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Account deleted");
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Account not deleted");
            }
            pause.play();
        });

        Scene scene = new Scene(gridPane);
        return scene;
    }
}
