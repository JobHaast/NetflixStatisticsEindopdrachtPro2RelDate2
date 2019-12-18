package GUIScenes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Login extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane main = new BorderPane();
        Label topText = new Label("Login");

        main.setTop(topText);
        Scene loginScene = new Scene(main);
    }
}
