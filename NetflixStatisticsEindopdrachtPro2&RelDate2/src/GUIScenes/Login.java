package GUIScenes;

import database.Connect;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Login extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane main = new BorderPane();
        Label topText = new Label("Login");
        main.setTop(topText);

        BorderPane login = new BorderPane();
        HBox hBoxUsername = new HBox();
        Label labelUsername = new Label("Username");
        TextField textFieldUsername = new TextField();
        hBoxUsername.getChildren().addAll(labelUsername, textFieldUsername);

        HBox hBoxPassword = new HBox();
        Label labelPassword = new Label("Password");
        TextField textFieldPassword = new TextField();
        hBoxPassword.getChildren().addAll(labelPassword, textFieldPassword);

        HBox hBoxSubmit = new HBox();
        Button submit = new Button("Submit");

        hBoxSubmit.getChildren().addAll(submit);

        login.setTop(hBoxUsername);
        login.setCenter(hBoxPassword);
        main.setCenter(login);
        login.setBottom(hBoxSubmit);

        //Scene homepage
        Label label = new Label("Logged in");
        Scene homepage = new Scene(label);

        Scene loginScene = new Scene(main);

        //Onclick event for button submit in login
        submit.setOnAction(event -> {
            Connect connect = new Connect("jdbc:sqlserver://localhost;databaseName=Users;integratedSecurity=true;");
            String password = connect.executeQueryPassword("SELECT Password FROM Users WHERE Username = "+textFieldUsername.getText()+";");
            if(textFieldPassword.equals(password)){
                stage.setScene(homepage);
            }else{
                System.out.println("Wrong");
            }
        });
    }
}
