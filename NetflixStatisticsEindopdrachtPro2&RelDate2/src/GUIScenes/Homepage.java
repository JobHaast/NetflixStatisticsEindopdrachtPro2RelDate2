package GUIScenes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Homepage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Logged in");
        Scene homepage = new Scene(label);
    }
}
