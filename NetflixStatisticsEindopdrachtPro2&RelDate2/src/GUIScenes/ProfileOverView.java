package GUIScenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ProfileOverView {

    public static Scene display(){
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

//        userTextFieldGridPaneProfileOverView.setText(userTextField.getText());
//        emailTextFieldProfileOverView.setText(connect.executeQueryOneValue("SELECT Email FROM Users WHERE Username = '"+userTextField.getText()+"';", "Email"));
//        phoneNumberFieldProfileOverView.setText(connect.executeQueryOneValue("SELECT Phonenumber FROM Users WHERE Username = '"+userTextField.getText()+"';", "Phonenumber"));

        //Set grindPaneProfileOverView center
        borderPaneProfileOverView.setCenter(gridPaneProfileOverView);
        Scene profileOverView = new Scene(borderPaneProfileOverView);

        return profileOverView;
    }
}
