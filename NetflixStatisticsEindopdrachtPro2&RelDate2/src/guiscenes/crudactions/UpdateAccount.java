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

public class UpdateAccount {
    public static Scene display(Stage stage, Read read, Account loggedPerson){
        Update uA = new Update("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        ArrayList<String> namesAccounts = read.getAccountsNames();
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        //Gridpane for layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        //Backgroundcolor for gridpane
        Color backgroundColor = Color.web("rgb(100, 97, 97)");
        gridPane.backgroundProperty().set(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));

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

        //Text for feedback Number
        final Text feedbackTextNumber = new Text();
        feedbackTextNumber.setFill(Color.FIREBRICK);
        gridPane.add(feedbackTextNumber, 2, 2);

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
            feedbackTextNumber.setText(null);
        });

        submit.setOnAction(event -> {
            if (Checks.checkIfNotNullOrEmptyString(accountNameComboBox.getValue()) && Checks.checkIfNotNullOrEmptyString(emailTextField.getText()) &&
                    Checks.checkIfNotNullOrEmptyString(phonenumberTextField.getText()) && Checks.checkIfNotNullOrEmptyString(passwordField.getText())) {
                if (Checks.checkIfNumbersOnly(phonenumberTextField.getText())) {
                    if ("Account updated".equals(uA.updateAccount(accountNameComboBox.getValue(), emailTextField.getText(), phonenumberTextField.getText(), passwordField.getText()))) {
                        ArrayList<String> names = read.getAccountsNames();
                        accountNameComboBox.getItems().clear();
                        accountNameComboBox.getItems().addAll(names);
                        emailTextField.setText(null);
                        phonenumberTextField.setText(null);
                        passwordField.setText(null);
                        actiontarget.setFill(Color.GREEN);
                        actiontarget.setText("Account updated");
                    } else {
                        actiontarget.setFill(Color.FIREBRICK);
                        actiontarget.setText("Account not updated");
                    }
                } else {
                    feedbackTextNumber.setText("Please use numbers only");
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
            }catch(Exception e){
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

        Scene scene = new Scene(mainScene, screenSize.getWidth(), screenSize.getHeight()*0.978);
        return scene;
    }
}
