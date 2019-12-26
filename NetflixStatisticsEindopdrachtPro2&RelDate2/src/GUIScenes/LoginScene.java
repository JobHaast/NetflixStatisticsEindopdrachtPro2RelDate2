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
import logic.Profile;

public class LoginScene extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Connect connect = new Connect("jdbc:sqlserver://localhost;databaseName=Login;integratedSecurity=true;");
        Profile user;

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

        Scene loginScene = new Scene(gridPaneLogin);

        //Set first page
        stage.setMaximized(true);
        stage.setScene(loginScene);
        stage.setTitle("Netflix Statistics");
        stage.show();

        //Onclick event for submit button in login scene
        btn.setOnAction(event -> {
            String password = connect.executeQueryOneValue("SELECT Password FROM Users WHERE Username = '"+userTextField.getText()+"';", "Password");
            if(pwBox.getText().equals(password)) {
                try {
                    stage.setScene(ProgramOverView.display(stage));
                }catch(Exception e){
                    e.getMessage();
                }
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Combination is incorrect");
            }
        });
    }
}
