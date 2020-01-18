package GUIScenes;

import database.Read;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Account;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LoginScene extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Read read = new Read("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");

        //Set first page
        stage.setMaximized(true);
        stage.setScene(LoginScene.display(stage, read));
        stage.setTitle("Job Haast - 2151057, Noah Korten - 2153017, Wesley de Jonge - 2144101");
        stage.setResizable(true);
        stage.show();
    }

    public static Scene display(Stage stage, Read read){
        PauseTransition pause = new PauseTransition(Duration.seconds(3));

        // Scene login
        GridPane gridPaneLogin = new GridPane();
        gridPaneLogin.setAlignment(Pos.CENTER);
        gridPaneLogin.setHgap(10);
        gridPaneLogin.setVgap(10);
        gridPaneLogin.setPadding(new Insets(25, 25, 25, 25));
//        Color backgroundcolor = new Color();
//        gridPaneLogin.backgroundProperty().set(new Background(new BackgroundFill(Color., CornerRadii.EMPTY, Insets.EMPTY)));

        //Set picture and position.
//        try {
//            Image imfNetflix = new Image(new FileInputStream(".\\NetflixStatisticsEindopdrachtPro2&RelDate2\\Photo's\\Netflix.png"));
//            ImageView imageViewLostInSpace = new ImageView(imfNetflix);
//            imageViewLostInSpace.setFitHeight(200);
//            imageViewLostInSpace.setFitWidth(355);
//            imageViewLostInSpace.setPickOnBounds(true);
//            gridPaneLogin.add(imageViewLostInSpace, 0, 0, 7, 1);
//        }catch (Exception e){
//            e.getMessage();
//        }

//        Text sceneTitleLogin = new Text("Welcome");
//        sceneTitleLogin.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//        gridPaneLogin.add(sceneTitleLogin, 0, 2, 2, 1);

        Label userName = new Label("User Name:");
        gridPaneLogin.add(userName, 4, 2);

        TextField userTextField = new TextField();
        gridPaneLogin.add(userTextField, 5, 2);

        Label pw = new Label("Password:");
        gridPaneLogin.add(pw, 4, 3);

        PasswordField pwBox = new PasswordField();
        gridPaneLogin.add(pwBox, 5, 3);

        Button btn = new Button("Sign in");
        gridPaneLogin.add(btn, 5, 4);

        final Text actiontarget = new Text();
        gridPaneLogin.add(actiontarget, 5, 5);

        //Action when pause.play() is called//
        pause.setOnFinished(e -> {
            actiontarget.setText(null);
        });

        Scene loginScene = new Scene(gridPaneLogin);

        //Onclick event for submit button in login scene
        btn.setOnAction(event -> {
            String password = read.executeQueryOneValue("SELECT Password FROM Account WHERE AccountName = '"+userTextField.getText()+"';", "Password");
            if(read.checkAdminPermission(userTextField.getText()) == 1) {
                if (pwBox.getText().equals(password)) {
                    try {
                        Account loggedPerson = read.getAccount(userTextField.getText());
                        stage.setScene(ProgramOverView.display(stage, read, loggedPerson));
                    } catch (Exception e) {
                        e.getMessage();
                    }
                } else {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Combination is incorrect");
                }
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Account isn't an administrator");
            }
            pause.play();
        });
        return loginScene;
    }
}
