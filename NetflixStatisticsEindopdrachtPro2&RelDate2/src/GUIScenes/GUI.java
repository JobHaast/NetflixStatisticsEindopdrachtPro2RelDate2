package GUIScenes;

import database.Connect;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Scene userChange
        BorderPane all1 = new BorderPane();
        HBox HBox1all1 = new HBox(new Label("Netflix Statistics"));
        HBox1all1.setAlignment(Pos.CENTER);
        all1.setTop(HBox1all1);

        HBox HBox2all1 = new HBox();
        VBox vBox1All1 = new VBox();
        VBox vBox2All1 = new VBox();
        VBox vBox3All1 = new VBox();

        Button toevoegen = new Button("Toevoegen");
        Button wijzigen = new Button("Wijzigen");
        toevoegen.setOnAction(event -> {
            System.out.println("Toegevoegd");
        });
        wijzigen.setOnAction(event -> {
            System.out.println("Gewijzigd");
        });

        vBox1All1.getChildren().add(toevoegen);
        vBox2All1.getChildren().add(new Label(" "));
        vBox3All1.getChildren().add(wijzigen);
        vBox1All1.setPadding(new Insets(10));
        vBox2All1.setPadding(new Insets(10));
        vBox3All1.setPadding(new Insets(10));

        HBox2all1.getChildren().addAll(vBox1All1, vBox2All1, vBox3All1);
        all1.setCenter(HBox2all1);
        Scene sceneuserChange = new Scene(all1);

        // Scene login
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
        Scene loginScene = new Scene(main);

        //Homepage scene
        Label label = new Label("Logged in");
        Scene homepage = new Scene(label);

        //Set first page
        stage.setScene(loginScene);
        stage.show();

        //Onclick event for submit button in login scene
        submit.setOnAction(event -> {
            Connect connect = new Connect("jdbc:sqlserver://localhost;databaseName=Login;integratedSecurity=true;");
            String password = connect.executeQueryPassword("SELECT Password FROM Users WHERE Username = '"+textFieldUsername.getText()+"';");
            if(textFieldPassword.getText().equals(password)){
                stage.setScene(homepage);
            }else{
                System.out.println("Wrong");
            }
        });
    }
}
