package GUIScenes;

import javafx.scene.Scene;
import javafx.scene.control.Label;


public class Homepage{

    public static Scene display(){
        Label label = new Label("Logged in");
        Scene homepage = new Scene(label);
        return homepage;
    }
}
