package GUIScenes.CRUDActions;

import GUIScenes.*;
import database.Read;
import database.Update;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Account;

import java.util.ArrayList;

public class UpdateProfile {
    public static Scene display(Stage stage, Read read, Account loggedPerson){
        Update uP = new Update("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");
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

        //Label for profilenames
        Label profileNameLabel = new Label("Profile Name:");
        gridPane.add(profileNameLabel, 0, 1);

        //combobox for profilenames
        ComboBox<String> profileNamesComboBox = new ComboBox<>();
        gridPane.add(profileNamesComboBox, 1, 1);

        //onclick for profileNamesComboBox
        accountNameComboBox.setOnAction(event -> {
            profileNamesComboBox.getItems().clear();
            profileNamesComboBox.getItems().addAll(read.getProfileNames(accountNameComboBox.getValue()));
        });

        //Label for Profilelanguage
        Label profileLanguageLabel = new Label("Profile language:");
        gridPane.add(profileLanguageLabel, 0, 2);

        //combobox for languages
        ComboBox<String> languagesComboBox = new ComboBox<>();
        languagesComboBox.getItems().addAll("Nederlands", "English");
        gridPane.add(languagesComboBox, 1, 2);

        //Label for birthday
        Label birthdayLabel = new Label("Birthday");
        gridPane.add(birthdayLabel, 0, 3);

        //
        TextField birthdayDatePicker = new TextField();
        gridPane.add(birthdayDatePicker, 1, 3);

        //Feedbacktext
        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 5);

        //Action when pause.play() is called
        pause.setOnFinished(e -> {
            actiontarget.setText(null);
        });

        Button submit = new Button("Submit");
        gridPane.add(submit,1,4);
        submit.setOnAction(event -> {
            if("Profile updated".equals(uP.updateProfile(accountNameComboBox.getValue(), profileNamesComboBox.getValue(), languagesComboBox.getValue(), birthdayDatePicker.getText()))){
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Profile updated");
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Profile not updated");
            }
            pause.play();
        });

        //GridPane for different tabs
        GridPane menu = new GridPane();
        menu.setAlignment(Pos.CENTER);
        menu.setHgap(20);
        menu.setVgap(20);
        menu.setPadding(new Insets(25, 25, 25, 25));

        //Button for profileoverview
        Button profileOverView = new Button("Profile");
        menu.add(profileOverView, 0, 0);

        //Button for logOut
        Button logOut = new Button("Log out");
        menu.add(logOut, 1, 0);

        //Button for CRUD scene
        Button cRUD = new Button("CRUD");
        menu.add(cRUD, 2, 0);

        //Button for programoverview
        Button programOverView = new Button("Program overview");
        menu.add(programOverView, 3, 0);

        //Button for longest movie for overviews
        Button overViews = new Button("Overviews");
        menu.add(overViews, 4, 0);

        //Onclick event for overviews
        overViews.setOnAction(event -> {
            stage.setScene(OverViewsDirect.display(stage, read, loggedPerson));
        });

        //Onclick event for logout
        logOut.setOnAction(event -> {
            stage.setScene(LoginScene.display(stage, read));
        });

        //Onclick event for button CRUD
        cRUD.setOnAction(event -> {
                    stage.setScene(CRUD.display(stage, read, loggedPerson));
                }
        );

        //Onclick event for profileoverview
        profileOverView.setOnAction(event -> {
            stage.setScene(ProfileOverView.display(stage, read, loggedPerson));
        });

        //Onclick event for programoverview
        programOverView.setOnAction(event -> {
            try {
                stage.setScene(ProgramOverView.display(stage, read, loggedPerson));
            }catch(Exception e){
                e.getMessage();
            }
        });

        //Borderpane for layout
        BorderPane mainScene = new BorderPane();
        mainScene.setBottom(menu);
        mainScene.setCenter(gridPane);

        Scene scene = new Scene(mainScene);
        return scene;
    }
}
