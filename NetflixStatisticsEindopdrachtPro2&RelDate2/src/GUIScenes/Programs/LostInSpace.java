package GUIScenes.Programs;

import javafx.scene.Scene;
import javafx.scene.control.Label;

public class LostInSpace {
    public static Scene display(){
        //Scene for the program lost in space
        Label topLabel = new Label("LostInSpace");
        Scene lostInSpace = new Scene(topLabel);

        return lostInSpace;
    }
}
