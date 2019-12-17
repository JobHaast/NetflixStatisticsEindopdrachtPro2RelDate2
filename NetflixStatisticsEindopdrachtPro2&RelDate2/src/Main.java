import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
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

        //Ik heb shit veranderd
        //ik ook, ;)

        Scene scene1 = new Scene(all1);
        stage.setScene(scene1);
        stage.setTitle("Netflix Statistics");
        stage.show();
    }
}
