import GUIScenes.GUI;
import database.Connect;

import static javafx.application.Application.launch;

public class Main{
    public static void main(String[] args) {
        launch(GUI.class);


//        Connect connect = new Connect("jdbc:sqlserver://localhost;databaseName=Login;integratedSecurity=true;");
//        System.out.println(connect.executeQueryPassword("SELECT Password FROM Users WHERE Username = 'Job';"));

    }
}
