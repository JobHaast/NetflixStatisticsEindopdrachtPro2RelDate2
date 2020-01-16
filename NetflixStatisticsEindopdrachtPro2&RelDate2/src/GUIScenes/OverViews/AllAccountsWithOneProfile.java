package GUIScenes.OverViews;

import database.Read;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.StringForTableView;

import java.util.ArrayList;

public class AllAccountsWithOneProfile {
    public static Scene display(Stage stage, Read read) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // Scene Tableview
        final Label label = new Label("Accounts with one profile:");
        label.setFont(new Font("Arial", 20));
        gridPane.add(label, 0, 0);

        TableView<StringForTableView> table = new TableView<>();
        table.setMaxWidth(500);

        TableColumn movieTitle = new TableColumn("Account name");
        movieTitle.setMinWidth(500);

        movieTitle.setCellValueFactory(new PropertyValueFactory<>("string"));
        table.getColumns().add(movieTitle);
        table.setEditable(false);
        gridPane.add(table, 0, 1, 8, 1);

        ArrayList<StringForTableView> films = read.getAccountsWithOneProfile();
        ObservableList<StringForTableView> data = FXCollections.observableArrayList(films);
        table.setItems(data);

        Scene scene = new Scene(gridPane);
        return scene;
    }
}
