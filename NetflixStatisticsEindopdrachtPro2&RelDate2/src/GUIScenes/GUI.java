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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Scene userChange
        BorderPane all1 = new BorderPane();
        HBox HBox1all1 = new HBox(new Label("Netflix Statistics"));
        HBox1all1.setAlignment(Pos.CENTER);
        all1.setTop(HBox1all1);

        HBox HBox2all1 = new HBox();
        VBox vBox1All1 = new VBox();
        VBox vBox2All1 = new VBox();
        VBox vBox3All1 = new VBox();

        Button toevoegen = new Button("Toevoegen");
        Button wijzigen = new Button("Wijzigen");
        toevoegen.setOnAction(event -> {
            System.out.println("Toegevoegd");
        });
        wijzigen.setOnAction(event -> {
            System.out.println("Gewijzigd");
        });

        vBox1All1.getChildren().add(toevoegen);
        vBox2All1.getChildren().add(new Label(" "));
        vBox3All1.getChildren().add(wijzigen);
        vBox1All1.setPadding(new Insets(10));
        vBox2All1.setPadding(new Insets(10));
        vBox3All1.setPadding(new Insets(10));

        HBox2all1.getChildren().addAll(vBox1All1, vBox2All1, vBox3All1);
        all1.setCenter(HBox2all1);
        Scene sceneuserChange = new Scene(all1);

        // Scene login
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        Scene loginScene = new Scene(grid, 300, 275);


        //Homepage scene
        Label label = new Label("Logged in");
        Scene homepage = new Scene(label);

        //Set first page
        stage.setScene(loginScene);
        stage.setTitle("Netflix Statistics");
        stage.show();

        //Onclick event for submit button in login scene
        btn.setOnAction(event -> {
            Connect connect = new Connect("jdbc:sqlserver://localhost;databaseName=Login;integratedSecurity=true;");
            String password = connect.executeQueryPassword("SELECT Password FROM Users WHERE Username = '"+userTextField.getText()+"';");
            if(pwBox.getText().equals(password)){
                stage.setScene(sceneuserChange);
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Wrong password");
            }
        });
    }
}
