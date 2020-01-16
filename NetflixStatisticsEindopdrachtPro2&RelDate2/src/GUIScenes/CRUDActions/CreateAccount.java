package GUIScenes.CRUDActions;

import GUIScenes.*;
import database.Read;
import database.Create;
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

public class CreateAccount {
    public static Scene display(Stage stage, Read read, Account loggedPerson){
        Create cA = new Create("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");
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

        //textfield for accountname
        TextField accountNameTextField = new TextField();
        gridPane.add(accountNameTextField, 1, 0);

        //Label for email
        Label emailLabel = new Label("Email:");
        gridPane.add(emailLabel, 0, 1);

        //Textfield for email
        TextField emailTextField = new TextField();
        gridPane.add(emailTextField, 1, 1);

        //Label for phonenumber
        Label phonenumberLabel = new Label("Phonenumber:");
        gridPane.add(phonenumberLabel, 0, 2);

        //Textfield for phonenumber
        TextField textFieldPhonenumber = new TextField();
        gridPane.add(textFieldPhonenumber, 1, 2);

        //Label for password
        Label passwordLabel = new Label("Password:");
        gridPane.add(passwordLabel, 0, 3);

        //Passwordfield for password
        PasswordField passwordFieldPassword = new PasswordField();
        gridPane.add(passwordFieldPassword, 1, 3);

        //Label for streetname
        Label labelAddress = new Label("Streetname:");
        gridPane.add(labelAddress, 0, 4);

        //Textfield for streetname
        TextField textFieldStreetName = new TextField();
        gridPane.add(textFieldStreetName, 1, 4);

        //Label for number
        Label labelNumber = new Label("Number:");
        gridPane.add(labelNumber, 0, 5);

        //Textfield for number
        TextField textFieldNumber = new TextField();
        gridPane.add(textFieldNumber, 1, 5);

        //Label for Addition
        Label labelAddition = new Label("Addition:");
        gridPane.add(labelAddition, 0, 6);

        //Textfield for Addition
        TextField textFieldAddition = new TextField();
        gridPane.add(textFieldAddition, 1, 6);

        //Label for City
        Label labelCity = new Label("City:");
        gridPane.add(labelCity, 0, 7);

        //Textfield for City
        TextField textFieldCity = new TextField();
        gridPane.add(textFieldCity, 1, 7);

        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 9);

        Button submit = new Button("Create");
        gridPane.add(submit,1,8);
        submit.setOnAction(event -> {
                int addressId = read.checkIfAddressExists(textFieldStreetName.getText(), Integer.parseInt(textFieldNumber.getText()), textFieldAddition.getText(), textFieldCity.getText());
                if(read.getAccountCheck(accountNameTextField.getText()).size() == 0){
                    if(addressId == 0) {
                        cA.createAddress(textFieldStreetName.getText(), Integer.parseInt(textFieldNumber.getText()), textFieldAddition.getText(), textFieldCity.getText());
                        cA.createAccount(accountNameTextField.getText(), emailTextField.getText(), textFieldPhonenumber.getText(), passwordFieldPassword.getText(), read.getHighestAddressId());
                        actiontarget.setFill(Color.GREEN);
                        actiontarget.setText("Succesfully created the account");
                    }else if(addressId != 0){
                        cA.createAccount(accountNameTextField.getText(), emailTextField.getText(), textFieldPhonenumber.getText(), passwordFieldPassword.getText(), addressId);
                        actiontarget.setFill(Color.GREEN);
                        actiontarget.setText("Succesfully created the account");
                    }else{
                        actiontarget.setFill(Color.FIREBRICK);
                        actiontarget.setText("An error has occurred");
                    }
                }else{
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Account already exists");
                }
            pause.play();
        });

        //Action when pause.play() is called//
        pause.setOnFinished(e -> {
            actiontarget.setText(null);
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
