package GUIScenes;

import GUIScenes.Programs.CRUDActions.CreateAccount;
import database.Connect;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CRUD {
    public static Scene display(Stage stage, Connect connect){
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
            stage.setScene(CreateAccount.display(stage, connect));
        });

        //Button for profile creation
        Button createProfile = new Button("Create Profile");
        cRUDGridPane.add(createProfile, 0, 1);

        //Button for creating watched program
        Button createWatchedProgram = new Button("Create Watched Program");
        cRUDGridPane.add(createWatchedProgram, 0, 2);

        //Button for account deletion
        Button deleteAccount = new Button("Delete Account");
        cRUDGridPane.add(deleteAccount, 1, 0);

        //Button for profile creation
        Button deleteProfile = new Button("Delete Profile");
        cRUDGridPane.add(deleteProfile, 1, 1);

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

        Scene cRUD = new Scene(cRUDGridPane);
        return cRUD;
    }
}
