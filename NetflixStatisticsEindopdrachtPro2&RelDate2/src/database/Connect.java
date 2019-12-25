package database;

import java.sql.*;
import java.util.ArrayList;

public class Connect {
    //String needed to make a connection to your database.
    private String connectionUrl;
    //Connection controls information about the connection with the database.
    private Connection con;
    //Statement that allows to execute a query.
    private Statement statement;
    //Result of a query is store in here.
    private ResultSet resultSet;

    public Connect(String connectionUrl){
        this.connectionUrl = connectionUrl;
        this.con = null;
        this.statement = null;
        this.resultSet = null;
    }

    public void executeQuery(String query) {
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery(query);

            System.out.print(String.format("| %-32s | %-5s | %-10s | %-20s | %-24s | %-20s | %-20s |\n", " ", " ", " ", " ", " ", " ", " ").replace(" ", "-"));

            // If the resultSet variable contains values, we're going to print it here.
            while (resultSet.next()) {
                // Ask per row the columns.
                String filmtitel = resultSet.getString("Filmtitel");
                String _3d = resultSet.getString("3d");
                int premiereJaar = resultSet.getInt("PremiereJaar");
                String filmProductieLand = resultSet.getString("FilmProductieLand");
                String regisseur = resultSet.getString("Regisseur");
                Date geboortedatumRegisseur = resultSet.getDate("GeboortedatumRegisseur");
                String geboortelandRegisseur = resultSet.getString("GeboortelandRegisseur");

                // Print the columns

                // With 'format' you're able to change the look of the string
                // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters wide.
                System.out.format("| %-32s | %-5s | %-10s | %-20s | %-24s | %-20s | %-20s | \n", filmtitel, _3d, premiereJaar, filmProductieLand, regisseur, geboortedatumRegisseur, geboortelandRegisseur);
            }
            System.out.println(String.format("| %-32s | %-5s | %-10s | %-20s | %-24s | %-20s | %-20s |\n", " ", " ", " ", " ", " ", " ", " ").replace(" ", "-"));

        }

//            Handle any errors that may have occurred.
         catch (Exception e) {
            e.printStackTrace();
        }
        finally {
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

    public String executeQueryOneValue(String query, String columnName){
        String returnValue = null;
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                returnValue = resultSet.getString(columnName);
            }

//            Handle any errors that may have occurred.
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
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
        return returnValue;
    }

    public ArrayList<String> personInfo(String username){
        ArrayList<String> personInfo = new ArrayList<>();
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT Username, Email, Phonenumber, AddressID FROM Users WHERE Username = '"+username+"';");

            while(resultSet.next()){
                personInfo.add(resultSet.getString("Username"));
                personInfo.add(resultSet.getString("Email"));
                personInfo.add(resultSet.getString("Phonenumber"));
                personInfo.add(resultSet.getString("AddresID"));
            }

//            Handle any errors that may have occurred.
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
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
        return personInfo;
    }

    public ArrayList<String> addressInfo(String addressID){
        ArrayList<String> addressInfo = new ArrayList<>();
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT StreetName, Number, Addition, City FROM Addresses WHERE AddressID = '"+addressID+"';");

            while(resultSet.next()){
                addressInfo.add(resultSet.getString("StreetName"));
                addressInfo.add(resultSet.getString("Number"));
                addressInfo.add(resultSet.getString("Addition"));
                addressInfo.add(resultSet.getString("City"));
            }

//            Handle any errors that may have occurred.
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
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
        return addressInfo;
    }
}
