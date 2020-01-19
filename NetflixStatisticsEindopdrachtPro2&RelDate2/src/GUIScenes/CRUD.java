package GUIScenes;

import GUIScenes.crudactions.*;
import database.Read;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import logic.Account;

public class CRUD {
    public static Scene display(Stage stage, Read read, Account loggedPerson){
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        //CRUD Scene
        GridPane cRUDGridPane = new GridPane();
        cRUDGridPane.setAlignment(Pos.CENTER);
        cRUDGridPane.setHgap(20);
        cRUDGridPane.setVgap(20);
        cRUDGridPane.setPadding(new Insets(25, 25, 25, 25));

        //Set background color
        Color backgroundColor = Color.web("rgb(100, 97, 97)");
        cRUDGridPane.backgroundProperty().set(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));

        //Button for account creation
        Button createAccount = new Button("Create Account");
        cRUDGridPane.add(createAccount, 0, 0);

        //Onclick event for the button Create Account
        createAccount.setOnAction(event -> {
            stage.setScene(CreateAccount.display(stage, read, loggedPerson));
        });

        //Button for profile creation
        Button createProfile = new Button("Create Profile");
        cRUDGridPane.add(createProfile, 0, 1);

        //Onclick event for the button Create profile
        createProfile.setOnAction(event -> {
            stage.setScene(CreateProfile.display(stage, read, loggedPerson));
        });

        //Button for creating watched program
        Button createWatchedProgram = new Button("Create Watched Program");
        cRUDGridPane.add(createWatchedProgram, 0, 2);

        createWatchedProgram.setOnAction(event -> {
            stage.setScene(CreateWatchedProgram.display(stage, read, loggedPerson));
        });

        //Button for account deletion
        Button deleteAccount = new Button("Delete Account");
        cRUDGridPane.add(deleteAccount, 1, 0);

        //Onclick event for the button delete account
        deleteAccount.setOnAction(event -> {
            stage.setScene(DeleteAccount.display(stage, read, loggedPerson));
        });

        //Button for deleting profile
        Button deleteProfile = new Button("Delete Profile");
        cRUDGridPane.add(deleteProfile, 1, 1);

        //onclick for button deleteProfile
        deleteProfile.setOnAction(event -> {
            stage.setScene(DeleteProfile.display(stage, read, loggedPerson));
        });

        //Button for Deleting watched program
        Button deleteWatchedProgram = new Button("Delete Watched Program");
        cRUDGridPane.add(deleteWatchedProgram, 1, 2);

        //onclick for deleting watched program
        deleteWatchedProgram.setOnAction(event -> {
            stage.setScene(DeleteWatchedProgram.display(stage, read, loggedPerson));
        });

        //Button for updating account
        Button updateAccount = new Button("Update Account");
        cRUDGridPane.add(updateAccount, 2, 0);

        //onclick for button updating account
        updateAccount.setOnAction(event -> {
            stage.setScene(UpdateAccount.display(stage, read, loggedPerson));
        });

        //Button for profile update
        Button updateProfile = new Button("Update Profile");
        cRUDGridPane.add(updateProfile, 2, 1);

        //onclick for button updating profile
        updateProfile.setOnAction(event -> {
            stage.setScene(UpdateProfile.display(stage, read, loggedPerson));
        });

        //Button for updating watched program
        Button updateWatchedProgram = new Button("Update Watched Program");
        cRUDGridPane.add(updateWatchedProgram, 2, 2);

        //onclick for button updating account
        updateWatchedProgram.setOnAction(event -> {
            stage.setScene(UpdateWatchedProgram.display(stage, read, loggedPerson));
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
        mainScene.setCenter(cRUDGridPane);

        //Set background color
        Color backgroundColorUnder = Color.web("rgb(77, 73, 73)");
        mainScene.backgroundProperty().set(new Background(new BackgroundFill(backgroundColorUnder, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(mainScene, screenSize.getWidth(), screenSize.getHeight()*0.978);
        return scene;
    }
}
