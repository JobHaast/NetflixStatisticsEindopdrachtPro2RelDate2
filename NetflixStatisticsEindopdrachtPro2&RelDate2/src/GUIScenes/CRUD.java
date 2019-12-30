package GUIScenes;

import GUIScenes.CRUDActions.CreateAccount;
import GUIScenes.CRUDActions.CreateProfile;
import GUIScenes.CRUDActions.DeleteAccount;
import GUIScenes.CRUDActions.DeleteProfile;
import database.Read;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CRUD {
    public static Scene display(Stage stage, Read read){
        //CRUD Scene
        GridPane cRUDGridPane = new GridPane();
        cRUDGridPane.setAlignment(Pos.CENTER);
        cRUDGridPane.setHgap(20);
        cRUDGridPane.setVgap(20);
        cRUDGridPane.setPadding(new Insets(25, 25, 25, 25));

        //Button for account creation
        Button createAccount = new Button("Create Account");
        cRUDGridPane.add(createAccount, 0, 0);

        //Onclick event for the button Create Account
        createAccount.setOnAction(event -> {
            stage.setScene(CreateAccount.display(stage, read));
        });

        //Button for profile creation
        Button createProfile = new Button("Create Profile");
        cRUDGridPane.add(createProfile, 0, 1);

        //Onclick event for the button Create profile
        createProfile.setOnAction(event -> {
            stage.setScene(CreateProfile.display(stage, read));
        });

        //Button for creating watched program
        Button createWatchedProgram = new Button("Create Watched Program");
        cRUDGridPane.add(createWatchedProgram, 0, 2);

        //Button for account deletion
        Button deleteAccount = new Button("Delete Account");
        cRUDGridPane.add(deleteAccount, 1, 0);

        //Onclick event for the button delete account
        deleteAccount.setOnAction(event -> {
            stage.setScene(DeleteAccount.display(stage, read));
        });

        //Button for deleting profile
        Button deleteProfile = new Button("Delete Profile");
        cRUDGridPane.add(deleteProfile, 1, 1);

        //onclick for button deleteProfile
        deleteProfile.setOnAction(event -> {
            stage.setScene(DeleteProfile.display(stage, read));
        });

        //Button for creating watched program
        Button deleteWatchedProgram = new Button("Delete Watched Program");
        cRUDGridPane.add(deleteWatchedProgram, 1, 2);

        //Button for updating account
        Button updateAccount = new Button("Update Account");
        cRUDGridPane.add(updateAccount, 2, 0);

        //Button for profile creation
        Button updateProfile = new Button("Update Profile");
        cRUDGridPane.add(updateProfile, 2, 1);

        //Button for creating watched program
        Button updateWatchedProgram = new Button("Update Watched Program");
        cRUDGridPane.add(updateWatchedProgram, 2, 2);


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
                    stage.setScene(CRUD.display(stage, read));
                }
        );

        //Onclick event for profileoverview
        profileOverView.setOnAction(event -> {
            stage.setScene(ProfileOverView.display(stage, read));
        });

        //Onclick event for programoverview
        programOverView.setOnAction(event -> {
            try {
                stage.setScene(ProgramOverView.display(stage, read));
            }catch(Exception e){
                e.getMessage();
            }
        });

        //Borderpane for layout
        BorderPane mainScene = new BorderPane();
        mainScene.setBottom(menu);
        mainScene.setCenter(cRUDGridPane);

        Scene scene = new Scene(mainScene);
        return scene;
    }
}
