package GUIScenes.OverViews;

import database.Read;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LongestMovieUnder16 {
    public static Scene display(Stage stage, Read read) {
        String movie = read.getLongestMovieUnder16();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label label0 = new Label("Longest movie for people under 16: "+movie+"");
        gridPane.add(label0, 0, 0);

        Scene scene = new Scene(gridPane);
        return scene;
    }
}
