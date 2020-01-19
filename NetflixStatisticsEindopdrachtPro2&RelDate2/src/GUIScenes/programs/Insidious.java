package GUIScenes.programs;

import GUIScenes.ProgramOverView;
import database.Read;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import logic.Account;
import logic.Film;

public class Insidious {
    public static Scene display(Stage stage, Read read, Account loggedPerson){
        //Scene for the program lost in space
        Film insidious = read.filmInfo("Insidious");

        BorderPane borderPane = new BorderPane();
        Label lostInSpaceLabel = new Label("Insidious");
        lostInSpaceLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        HBox hBox = new HBox();
        hBox.getChildren().add(lostInSpaceLabel);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10, 10, 10 ,10));
        borderPane.setTop(hBox);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label userNameGridPaneProfileOverView = new Label("Title:");
        gridPane.add(userNameGridPaneProfileOverView, 0, 1);

        Label userTextFieldGridPaneProfileOverView = new Label(insidious.getTitle());
        gridPane.add(userTextFieldGridPaneProfileOverView, 1, 1);

        Label lengthLabel = new Label("Length:");
        gridPane.add(lengthLabel, 0, 2);

        Label lengthLabelAnswer = new Label(Integer.toString(insidious.getLength()));
        gridPane.add(lengthLabelAnswer, 1, 2);

        Label languageLabel = new Label("Language:");
        gridPane.add(languageLabel, 0, 3);

        Label languageLabelAnswer = new Label(insidious.getLanguage());
        gridPane.add(languageLabelAnswer, 1, 3);

        Label genreLabel = new Label("Genre:");
        gridPane.add(genreLabel, 0, 4);

        Label genreLabelAsnwer = new Label(insidious.getGenre());
        gridPane.add(genreLabelAsnwer, 1, 4);

        Label ageGroupLabel = new Label("Age group:");
        gridPane.add(ageGroupLabel, 0, 5);

        Label ageGroupLabelAsnwer = new Label(insidious.getAgeGroup());
        gridPane.add(ageGroupLabelAsnwer, 1, 5);
        borderPane.setCenter(gridPane);

        Button backButton = new Button("Back");
        gridPane.add(backButton, 0, 8);
        backButton.setOnAction(event -> {
            try {
                stage.setScene(ProgramOverView.display(stage, read, loggedPerson));
            } catch (Exception e) {
                e.getMessage();
            }

        });

        Scene insidiousScene = new Scene(borderPane);
        return insidiousScene;
    }
}

