package GUIScenes;

import database.Read;
import database.Update;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.Account;
import logic.Address;

public class ProfileOverView {

    public static Scene display(Stage stage, Read read, Account loggedPerson){
        Address addressLoggedPerson = read.addressInfo(loggedPerson.getAddress());
        Update update = new Update("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");

        // Scene profileOverView
        GridPane gridPaneProfileOverView = new GridPane();
        gridPaneProfileOverView.setAlignment(Pos.CENTER);
        gridPaneProfileOverView.setHgap(10);
        gridPaneProfileOverView.setVgap(10);
        gridPaneProfileOverView.setPadding(new Insets(25, 25, 25, 25));

        Label userNameGridPaneProfileOverView = new Label("User Name:");
        gridPaneProfileOverView.add(userNameGridPaneProfileOverView, 0, 1);

        TextField userTextFieldGridPaneProfileOverView = new TextField(loggedPerson.getAccountName());
        userTextFieldGridPaneProfileOverView.setDisable(true);
        gridPaneProfileOverView.add(userTextFieldGridPaneProfileOverView, 1, 1);

        Label emailGridPaneProfileOverView = new Label("Email:");
        gridPaneProfileOverView.add(emailGridPaneProfileOverView, 0, 2);

        TextField emailTextFieldProfileOverView = new TextField(loggedPerson.getEmail());
        gridPaneProfileOverView.add(emailTextFieldProfileOverView, 1, 2);

        Label phoneNumberGridPaneProfileOverView = new Label("Phonenumber:");
        gridPaneProfileOverView.add(phoneNumberGridPaneProfileOverView, 0, 3);

        TextField phoneNumberFieldProfileOverView = new TextField(loggedPerson.getPhoneNumber());
        gridPaneProfileOverView.add(phoneNumberFieldProfileOverView, 1, 3);

        Label passwordLabel = new Label("Password");
        gridPaneProfileOverView.add(passwordLabel, 0, 4);

        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setText(loggedPerson.getPassword());
        gridPaneProfileOverView.add(passwordTextField, 1, 4);

        Label cityGridPaneProfileOverView = new Label("City:");
        gridPaneProfileOverView.add(cityGridPaneProfileOverView, 0, 5);

        TextField cityNumberFieldProfileOverView = new TextField(addressLoggedPerson.getCity());
        gridPaneProfileOverView.add(cityNumberFieldProfileOverView, 1, 5);

        Label streetNameGridPaneProfileOverView = new Label("Street:");
        gridPaneProfileOverView.add(streetNameGridPaneProfileOverView, 0, 6);

        TextField streetNameNumberFieldProfileOverView = new TextField(addressLoggedPerson.getStreetName());
        gridPaneProfileOverView.add(streetNameNumberFieldProfileOverView, 1, 6);

        Label numberNameGridPaneProfileOverView = new Label("Number:");
        gridPaneProfileOverView.add(numberNameGridPaneProfileOverView, 0, 7);

        TextField numberNameNumberFieldProfileOverView = new TextField(Integer.toString(addressLoggedPerson.getNumber()));
        gridPaneProfileOverView.add(numberNameNumberFieldProfileOverView, 1, 7);

        Label additionNameGridPaneProfileOverView = new Label("Addition:");
        gridPaneProfileOverView.add(additionNameGridPaneProfileOverView, 0, 8);

        TextField additionNameNumberFieldProfileOverView = new TextField(addressLoggedPerson.getAddition());
        gridPaneProfileOverView.add(additionNameNumberFieldProfileOverView, 1, 8);

        Button submitChanges = new Button("Change");
        gridPaneProfileOverView.add(submitChanges, 1, 9);

        submitChanges.setOnAction(event -> {
//            update.updateAccount();
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
        mainScene.setCenter(gridPaneProfileOverView);

        Scene scene = new Scene(mainScene);

        return scene;
    }
}
