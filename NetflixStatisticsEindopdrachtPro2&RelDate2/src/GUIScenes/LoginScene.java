package GUIScenes;

import database.Read;
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

public class LoginScene extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Read read = new Read("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");

        //Set first page
        stage.setMaximized(true);
        stage.setScene(LoginScene.display(stage, read));
        stage.setTitle("Job Haast - 2151057, Noah Korten - 2153017, Wesley de Jonge - 2144101");
        stage.show();
    }

    public static Scene display(Stage stage, Read read){
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
        gridPaneLogin.add(btn, 1, 4);

        Button skipButton = new Button("Skip");
        gridPaneLogin.add(skipButton, 2, 4);

        //onlcik for skip button
        skipButton.setOnAction(event -> {
            Account loggedPerson = read.getAccount(userTextField.getText());
            try {
                stage.setScene(ProgramOverView.display(stage, read, loggedPerson));
            }catch(Exception e){
                e.getMessage();
            }
        });

        final Text actiontarget = new Text();
        gridPaneLogin.add(actiontarget, 1, 6);

        Scene loginScene = new Scene(gridPaneLogin);

        //Onclick event for submit button in login scene
        btn.setOnAction(event -> {
            String password = read.executeQueryOneValue("SELECT Password FROM Account WHERE AccountName = '"+userTextField.getText()+"';", "Password");
            if(pwBox.getText().equals(password)) {
                try {
                    Account loggedPerson = read.getAccount(userTextField.getText());
                    stage.setScene(ProgramOverView.display(stage, read, loggedPerson));
                }catch(Exception e){
                    e.getMessage();
                }
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Combination is incorrect");
            }
        });
        return loginScene;
    }
}
