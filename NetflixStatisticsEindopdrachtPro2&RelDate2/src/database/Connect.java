package database;

import java.sql.*;

public class Connect {
    //String needed to make a connection to your database
    private String connectionUrl;
    //Connection controls information about the connection with the database
    private Connection con;
    //Statement that allows to execute a query
    private Statement statement;
    //Result of a query is store in here
    private ResultSet resultSet;

    public Connect() throws Exception {
        this.connectionUrl = "jdbc:sqlserver://localhost;databaseName=Bibliotheek;integratedSecurity=true;";
        this.con = null;
        this.statement = null;
        this.resultSet = null;
    }

    public void executeQuery(String query) {
        try {
            // Import the downloaded driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery(query);

            System.out.print(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
            while (resultSet.next()) {
                // Vraag per row de kolommen in die row op.
                int ISBN = resultSet.getInt("ISBN");
                String title = resultSet.getString("Titel");
                String author = resultSet.getString("Auteur");

                // Print de kolomwaarden.
                // System.out.println(ISBN + " " + title + " " + author);

                // Met 'format' kun je de string die je print het juiste formaat geven, als je dat wilt.
                // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters breed.
                System.out.format("| %7d | %-32s | %-24s | \n", ISBN, title, author);
            }
            System.out.println(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) try {
                resultSet.close();
            } catch (Exception e) {
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
            }
        }
    }
}
//
//
//
//        // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien deze voor jou anders is.
//        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Bibliotheek;integratedSecurity=true;";
//
//        // Connection beheert informatie over de connectie met de database.
//        Connection con = null;
//
//        // Statement zorgt dat we een SQL query kunnen uitvoeren.
//        Statement statement = null;
//
//        // ResultSet is de tabel die we van de database terugkrijgen.
//        // We kunnen door de rows heen stappen en iedere kolom lezen.
//        ResultSet resultSet = null;
//
//        try {
//            // 'Importeer' de driver die je gedownload hebt.
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            // Maak de verbinding met de database.
//            con = DriverManager.getConnection(connectionUrl);
//
//            // Stel een SQL query samen.
//            String SQL = "SELECT TOP 10 * FROM Boek";
//            statement = con.createStatement();
//            // Voer de query uit op de database.
//            resultSet = statement.executeQuery(SQL);
//
//            System.out.print(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));
//
//            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
//            while (resultSet.next()) {
//                // Vraag per row de kolommen in die row op.
//                int ISBN = resultSet.getInt("ISBN");
//                String title = resultSet.getString("Titel");
//                String author = resultSet.getString("Auteur");
//
//                // Print de kolomwaarden.
//                // System.out.println(ISBN + " " + title + " " + author);
//
//                // Met 'format' kun je de string die je print het juiste formaat geven, als je dat wilt.
//                // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters breed.
//                System.out.format("| %7d | %-32s | %-24s | \n", ISBN, title, author);
//            }
//            System.out.println(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));
//
//        }
//
//        // Handle any errors that may have occurred.
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
//            if (statement != null) try { statement.close(); } catch(Exception e) {}
//            if (con != null) try { con.close(); } catch(Exception e) {}
//        }
//    }

