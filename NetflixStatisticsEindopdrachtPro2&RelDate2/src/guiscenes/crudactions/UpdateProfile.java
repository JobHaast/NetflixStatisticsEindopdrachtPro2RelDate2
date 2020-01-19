package guiscenes.crudactions;

import guiscenes.*;
import database.Read;
import database.Update;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Account;
import logic.Checks;

import java.util.ArrayList;

public class UpdateProfile {
    public static Scene display(Stage stage, Read read, Account loggedPerson) {
        Update uP = new Update("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");
        ArrayList<String> namesAccounts = read.getAccountsNames();
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        //CRUD Scene
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        //Backgroundcolor for gridpane
        Color backgroundColor = Color.web("rgb(100, 97, 97)");
        gridPane.backgroundProperty().set(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));

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

        //TextField for birthday
        TextField birthdayDatePicker = new TextField();
        gridPane.add(birthdayDatePicker, 1, 3);

        //Text for feedback birthday
        final Text feedbackTextBirthday = new Text();
        feedbackTextBirthday.setFill(Color.FIREBRICK);
        gridPane.add(feedbackTextBirthday, 2, 3);

        //Feedbacktext
        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 5);

        //Action when pause.play() is called
        pause.setOnFinished(e -> {
            actiontarget.setText(null);
            feedbackTextBirthday.setText(null);
        });

        Button submit = new Button("Submit");
        gridPane.add(submit, 1, 4);
        submit.setOnAction(event -> {
            if (Checks.checkIfNotNullOrEmptyString(accountNameComboBox.getValue()) && Checks.checkIfNotNullOrEmptyString(profileNamesComboBox.getValue()) &&
                    Checks.checkIfNotNullOrEmptyString(languagesComboBox.getValue()) && Checks.checkIfNotNullOrEmptyString(birthdayDatePicker.getText())) {
                if (Checks.checkIfCorrectBirthdayFormat(birthdayDatePicker.getText())) {
                    if ("Profile updated".equals(uP.updateProfile(accountNameComboBox.getValue(), profileNamesComboBox.getValue(), languagesComboBox.getValue(), birthdayDatePicker.getText()))) {
                        actiontarget.setFill(Color.GREEN);
                        actiontarget.setText("Profile updated");
                    } else {
                        actiontarget.setFill(Color.FIREBRICK);
                        actiontarget.setText("Profile not updated");
                    }
                } else {
                    feedbackTextBirthday.setText("Please use the correct birthday format: YYYY-MM-DD");
                }
            } else {
                actiontarget.setText("Please fill in all the fields");
                actiontarget.setFill(Color.FIREBRICK);
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
            } catch (Exception e) {
                e.getMessage();
            }
        });

        //Borderpane for layout
        BorderPane mainScene = new BorderPane();
        mainScene.setBottom(menu);
        mainScene.setCenter(gridPane);

        //Set background color
        Color backgroundColorUnder = Color.web("rgb(77, 73, 73)");
        mainScene.backgroundProperty().set(new Background(new BackgroundFill(backgroundColorUnder, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(mainScene, screenSize.getWidth(), screenSize.getHeight() * 0.978);
        return scene;
    }
}
