package GUIScenes;

import database.Connect;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.Account;
import logic.Address;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Connect connect = new Connect("jdbc:sqlserver://localhost;databaseName=Login;integratedSecurity=true;");

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
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        gridPaneLogin.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        gridPaneLogin.add(actiontarget, 1, 6);

        Scene loginScene = new Scene(gridPaneLogin);

        // Scene profileOverView
        BorderPane borderPaneProfileOverView = new BorderPane();
        Label profileOverViewLabel = new Label("Account");
        profileOverViewLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        HBox gridPaneProfileOverViewTopHBox = new HBox();
        gridPaneProfileOverViewTopHBox.getChildren().add(profileOverViewLabel);
        gridPaneProfileOverViewTopHBox.setAlignment(Pos.CENTER);
        gridPaneProfileOverViewTopHBox.setPadding(new Insets(10, 10, 10 ,10));
        borderPaneProfileOverView.setTop(gridPaneProfileOverViewTopHBox);

        GridPane gridPaneProfileOverView = new GridPane();
        gridPaneProfileOverView.setAlignment(Pos.CENTER);
        gridPaneProfileOverView.setHgap(10);
        gridPaneProfileOverView.setVgap(10);
        gridPaneProfileOverView.setPadding(new Insets(25, 25, 25, 25));

        Label userNameGridPaneProfileOverView = new Label("User Name:");
        gridPaneProfileOverView.add(userNameGridPaneProfileOverView, 0, 1);

        TextField userTextFieldGridPaneProfileOverView = new TextField();
        userTextFieldGridPaneProfileOverView.setDisable(true);
        gridPaneProfileOverView.add(userTextFieldGridPaneProfileOverView, 1, 1);

        Label emailGridPaneProfileOverView = new Label("Email:");
        gridPaneProfileOverView.add(emailGridPaneProfileOverView, 0, 2);

        TextField emailTextFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(emailTextFieldProfileOverView, 1, 2);

        Label phoneNumberGridPaneProfileOverView = new Label("Phonenumber:");
        gridPaneProfileOverView.add(phoneNumberGridPaneProfileOverView, 0, 3);

        TextField phoneNumberFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(phoneNumberFieldProfileOverView, 1, 3);

        Label cityGridPaneProfileOverView = new Label("City:");
        gridPaneProfileOverView.add(cityGridPaneProfileOverView, 0, 4);

        TextField cityNumberFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(cityNumberFieldProfileOverView, 1, 4);

        Label streetNameGridPaneProfileOverView = new Label("Street:");
        gridPaneProfileOverView.add(streetNameGridPaneProfileOverView, 0, 5);

        TextField streetNameNumberFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(streetNameNumberFieldProfileOverView, 1, 5);

        Label numberNameGridPaneProfileOverView = new Label("Number:");
        gridPaneProfileOverView.add(numberNameGridPaneProfileOverView, 0, 6);

        TextField numberNameNumberFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(numberNameNumberFieldProfileOverView, 1, 6);

        Label additionNameGridPaneProfileOverView = new Label("Addition:");
        gridPaneProfileOverView.add(additionNameGridPaneProfileOverView, 0, 7);

        TextField additionNameNumberFieldProfileOverView = new TextField();
        gridPaneProfileOverView.add(additionNameNumberFieldProfileOverView, 1, 7);

        //Set grindPaneProfileOverView center
        borderPaneProfileOverView.setCenter(gridPaneProfileOverView);
        Scene profileOverView = new Scene(borderPaneProfileOverView);

        //program scene Lost in space
        Label lostInSpace = new Label("Lost in space");
        Scene lostInSpaceScene = new Scene(lostInSpace);

        //Scene programs
        GridPane programsGridPane = new GridPane();
        programsGridPane.setAlignment(Pos.CENTER);
        programsGridPane.setHgap(10);
        programsGridPane.setVgap(10);
        programsGridPane.setPadding(new Insets(25, 25, 25, 25));

        Image imgLostInSpace = new Image(new FileInputStream("C:\\Users\\Job\\Documents\\GitTest\\NetflixStatisticsEindopdrachtPro2RelDate2\\NetflixStatisticsEindopdrachtPro2&RelDate2\\Photo's\\LostInSpace.jpg"));
        ImageView imageViewLostInSpace = new ImageView(imgLostInSpace);
        imageViewLostInSpace.setFitHeight(100);
        imageViewLostInSpace.setFitWidth(200);
        imageViewLostInSpace.setPickOnBounds(true);
        programsGridPane.add(imageViewLostInSpace, 0, 0);

        Image imgRickAndMorty = new Image(new FileInputStream("C:\\Users\\Job\\Documents\\GitTest\\NetflixStatisticsEindopdrachtPro2RelDate2\\NetflixStatisticsEindopdrachtPro2&RelDate2\\Photo's\\RickAndMorty.jpg"));
        ImageView imageRickAndMorty = new ImageView(imgRickAndMorty);
        imageRickAndMorty.setFitHeight(100);
        imageRickAndMorty.setFitWidth(200);
        imageRickAndMorty.setPickOnBounds(true);
        programsGridPane.add(imageRickAndMorty, 1, 0);

        Image imgTheFlash = new Image(new FileInputStream("C:\\Users\\Job\\Documents\\GitTest\\NetflixStatisticsEindopdrachtPro2RelDate2\\NetflixStatisticsEindopdrachtPro2&RelDate2\\Photo's\\TheFlash.jpg"));
        ImageView imageTheFlash = new ImageView(imgTheFlash);
        imageTheFlash.setFitHeight(100);
        imageTheFlash.setFitWidth(200);
        imageTheFlash.setPickOnBounds(true);
        programsGridPane.add(imageTheFlash, 2, 0);

        Image imgInsidious = new Image(new FileInputStream("C:\\Users\\Job\\Documents\\GitTest\\NetflixStatisticsEindopdrachtPro2RelDate2\\NetflixStatisticsEindopdrachtPro2&RelDate2\\Photo's\\Insidious.jpg"));
        ImageView imageInsidious = new ImageView(imgInsidious);
        imageInsidious.setFitHeight(100);
        imageInsidious.setFitWidth(200);
        imageInsidious.setPickOnBounds(true);
        programsGridPane.add(imageInsidious, 0, 1);

        Image imgJumanji = new Image(new FileInputStream("C:\\Users\\Job\\Documents\\GitTest\\NetflixStatisticsEindopdrachtPro2RelDate2\\NetflixStatisticsEindopdrachtPro2&RelDate2\\Photo's\\Jumanji.jpg"));
        ImageView imageJumanji = new ImageView(imgJumanji);
        imageJumanji.setFitHeight(100);
        imageJumanji.setFitWidth(200);
        imageJumanji.setPickOnBounds(true);
        programsGridPane.add(imageJumanji, 0, 2);

        Image imgTheDictator = new Image(new FileInputStream("C:\\Users\\Job\\Documents\\GitTest\\NetflixStatisticsEindopdrachtPro2RelDate2\\NetflixStatisticsEindopdrachtPro2&RelDate2\\Photo's\\TheDictator.jpg"));
        ImageView imageTheDictator = new ImageView(imgTheDictator);
        imageTheDictator.setFitHeight(100);
        imageTheDictator.setFitWidth(200);
        imageTheDictator.setPickOnBounds(true);
        programsGridPane.add(imageTheDictator, 1, 1);

        Image imgHowIMetYourMother = new Image(new FileInputStream("C:\\Users\\Job\\Documents\\GitTest\\NetflixStatisticsEindopdrachtPro2RelDate2\\NetflixStatisticsEindopdrachtPro2&RelDate2\\Photo's\\HowIMetYourMother.jpg"));
        ImageView imageHowIMetYourMother = new ImageView(imgHowIMetYourMother);
        imageHowIMetYourMother.setFitHeight(100);
        imageHowIMetYourMother.setFitWidth(200);
        imageHowIMetYourMother.setPickOnBounds(true);
        programsGridPane.add(imageHowIMetYourMother, 1, 2);

        Image imgTheWitcher = new Image(new FileInputStream("C:\\Users\\Job\\Documents\\GitTest\\NetflixStatisticsEindopdrachtPro2RelDate2\\NetflixStatisticsEindopdrachtPro2&RelDate2\\Photo's\\TheWitcher.jpg"));
        ImageView imageTheWitcher = new ImageView(imgTheWitcher);
        imageTheWitcher.setFitHeight(100);
        imageTheWitcher.setFitWidth(200);
        imageTheWitcher.setPickOnBounds(true);
        programsGridPane.add(imageTheWitcher, 2, 1);

        Image imgBrooklynNineNine = new Image(new FileInputStream("C:\\Users\\Job\\Documents\\GitTest\\NetflixStatisticsEindopdrachtPro2RelDate2\\NetflixStatisticsEindopdrachtPro2&RelDate2\\Photo's\\BrooklynNineNine.jpg"));
        ImageView imageBrooklynNineNine = new ImageView(imgBrooklynNineNine);
        imageBrooklynNineNine.setFitHeight(100);
        imageBrooklynNineNine.setFitWidth(200);
        imageBrooklynNineNine.setPickOnBounds(true);
        programsGridPane.add(imageBrooklynNineNine, 2, 2);

        Scene programs = new Scene(programsGridPane);

        //Set first page
        stage.setMaximized(true);
        stage.setScene(loginScene);
        stage.setTitle("Netflix Statistics");
        stage.show();

        //Onclick event for submit button in login scene
        btn.setOnAction(event -> {
            String password = connect.executeQueryOneValue("SELECT Password FROM Users WHERE Username = '"+userTextField.getText()+"';", "Password");
            if(pwBox.getText().equals(password)) {
                stage.setScene(programs);

//                userTextFieldGridPaneProfileOverView.setText(userTextField.getText());
//                emailTextFieldProfileOverView.setText(connect.executeQueryOneValue("SELECT Email FROM Users WHERE Username = '"+userTextField.getText()+"';", "Email"));
//                phoneNumberFieldProfileOverView.setText(connect.executeQueryOneValue("SELECT Phonenumber FROM Users WHERE Username = '"+userTextField.getText()+"';", "Phonenumber"));
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Combination is incorrect");
            }
        });

        //Onclick event for photo of the serie Lost in space
        imageViewLostInSpace.setOnMouseClicked(mouseEvent -> {
                    stage.setScene(lostInSpaceScene);
                }
        );

        //Onclick event for photo of the serie Rick and Morty
        imageRickAndMorty.setOnMouseClicked(mouseEvent -> {
                    stage.setScene(lostInSpaceScene);
                }
        );

        //Onclick event for photo of the serie The flash
        imageTheFlash.setOnMouseClicked(mouseEvent -> {
                    stage.setScene(lostInSpaceScene);
                }
        );

        //Onclick event for photo of the film Insidious
        imageInsidious.setOnMouseClicked(mouseEvent -> {
                    stage.setScene(lostInSpaceScene);
                }
        );

        //Onclick event for photo of the film Jumanji
        imageJumanji.setOnMouseClicked(mouseEvent -> {
                    stage.setScene(lostInSpaceScene);
                }
        );

        //Onclick event for photo of the film The dictator
        imageTheDictator.setOnMouseClicked(mouseEvent -> {
                    stage.setScene(lostInSpaceScene);
                }
        );

        //Onclick event for photo of the serie how i met your mother
        imageTheWitcher.setOnMouseClicked(mouseEvent -> {
                    stage.setScene(lostInSpaceScene);
                }
        );

        //Onclick event for photo of the serie the witcher
        imageHowIMetYourMother.setOnMouseClicked(mouseEvent -> {
                    stage.setScene(lostInSpaceScene);
                }
        );

        //Onclick event for photo of the serie Brooklyn nine-nine
        imageBrooklynNineNine.setOnMouseClicked(mouseEvent -> {
                    stage.setScene(lostInSpaceScene);
                }
        );
    }
}
