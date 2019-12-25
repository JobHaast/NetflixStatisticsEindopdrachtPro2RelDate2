package GUIScenes;

import database.Connect;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.Account;
import logic.Address;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Connect connect = new Connect("jdbc:sqlserver://localhost;databaseName=Login;integratedSecurity=true;");

        // Scene login
        GridPane gridPaneLogin = new GridPane();
        gridPaneLogin.setAlignment(Pos.CENTER);
        gridPaneLogin.setHgap(10);
        gridPaneLogin.setVgap(10);
        gridPaneLogin.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitleLogin = new Text("Welcome");
        sceneTitleLogin.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPaneLogin.add(sceneTitleLogin, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        gridPaneLogin.add(userName, 0, 1);

        TextField userTextField = new TextField();
        gridPaneLogin.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        gridPaneLogin.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        gridPaneLogin.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        gridPaneLogin.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        gridPaneLogin.add(actiontarget, 1, 6);

        Scene loginScene = new Scene(gridPaneLogin, 300, 275);

        // Scene profileOverView
        BorderPane borderPaneProfileOverView = new BorderPane();
        Label profileOverViewLabel = new Label("Account");
        profileOverViewLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        HBox gridPaneProfileOverViewTopHBox = new HBox();
        gridPaneProfileOverViewTopHBox.getChildren().add(profileOverViewLabel);
        gridPaneProfileOverViewTopHBox.setAlignment(Pos.CENTER);
        gridPaneProfileOverViewTopHBox.setPadding(new Insets(10, 10, 10 ,10));
        borderPaneProfileOverView.setTop(gridPaneProfileOverViewTopHBox);

        GridPane gridPaneProfileOverView = new GridPane();
        gridPaneProfileOverView.setAlignment(Pos.CENTER);
        gridPaneProfileOverView.setHgap(10);
        gridPaneProfileOverView.setVgap(10);
        gridPaneProfileOverView.setPadding(new Insets(25, 25, 25, 25));

        Label userNameGridPaneProfileOverView = new Label("User Name:");
        gridPaneProfileOverView.add(userNameGridPaneProfileOverView, 0, 1);

        TextField userTextFieldGridPaneProfileOverView = new TextField();
        userTextFieldGridPaneProfileOverView.setDisable(true);
        gridPaneProfileOverView.add(userTextFieldGridPaneProfileOverView, 1, 1);

        Label emailGridPaneProfileOverView = new Label("Email:");
        gridPaneProfileOverView.add(emailGridPaneProfileOverView, 0, 2);

        TextField emailTextFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(emailTextFieldProfileOverView, 1, 2);

        Label phoneNumberGridPaneProfileOverView = new Label("Phonenumber:");
        gridPaneProfileOverView.add(phoneNumberGridPaneProfileOverView, 0, 3);

        TextField phoneNumberFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(phoneNumberFieldProfileOverView, 1, 3);

        Label cityGridPaneProfileOverView = new Label("City:");
        gridPaneProfileOverView.add(cityGridPaneProfileOverView, 0, 4);

        TextField cityNumberFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(cityNumberFieldProfileOverView, 1, 4);

        Label streetNameGridPaneProfileOverView = new Label("Street:");
        gridPaneProfileOverView.add(streetNameGridPaneProfileOverView, 0, 5);

        TextField streetNameNumberFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(streetNameNumberFieldProfileOverView, 1, 5);

        Label numberNameGridPaneProfileOverView = new Label("Number:");
        gridPaneProfileOverView.add(numberNameGridPaneProfileOverView, 0, 6);

        TextField numberNameNumberFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(numberNameNumberFieldProfileOverView, 1, 6);

        Label additionNameGridPaneProfileOverView = new Label("Addition:");
        gridPaneProfileOverView.add(additionNameGridPaneProfileOverView, 0, 7);

        TextField additionNameNumberFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(additionNameNumberFieldProfileOverView, 1, 7);

//Set grindPaneProfileOverView center
        borderPaneProfileOverView.setCenter(gridPaneProfileOverView);
        Scene profileOverView = new Scene(borderPaneProfileOverView, 300, 300);

        //Set first page
        stage.setScene(loginScene);
        stage.setTitle("Netflix Statistics");
        stage.show();

        //Onclick event for submit button in login scene
        btn.setOnAction(event -> {
            String password = connect.executeQueryOneValue("SELECT Password FROM Users WHERE Username = '"+userTextField.getText()+"';", "Password");
            if(pwBox.getText().equals(password)) {
                stage.setScene(profileOverView);
                userTextFieldGridPaneProfileOverView.setText(userTextField.getText());
                emailTextFieldProfileOverView.setText(connect.executeQueryOneValue("SELECT Email FROM Users WHERE Username = '"+userTextField.getText()+"';", "Email"));
                phoneNumberFieldProfileOverView.setText(connect.executeQueryOneValue("SELECT Phonenumber FROM Users WHERE Username = '"+userTextField.getText()+"';", "Phonenumber"));
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Combination is incorrect");
            }
        });
    }
}
