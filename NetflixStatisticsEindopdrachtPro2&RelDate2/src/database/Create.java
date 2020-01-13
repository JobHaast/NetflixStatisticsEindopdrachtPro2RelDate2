package database;

import logic.Account;
import logic.Address;
import logic.Film;
import logic.Serie;

import java.sql.*;
import java.util.ArrayList;

public class Create {
    //String needed to make a connection to your database.
    private String connectionUrl;
    //Connection controls information about the connection with the database.
    private Connection con;
    //Statement that allows to execute a query.
    private Statement statement;
    //Result of a query is store in here.
    private ResultSet resultSet;

    public Create(String connectionUrl){
        this.connectionUrl = connectionUrl;
        this.con = null;
        this.statement = null;
        this.resultSet = null;
    }

    public String createAddress(String streetName, int number, String addition, String city) {
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("INSERT INTO Address (StreetName, Number, Addition, City)" +
                    "VALUES ('" + streetName + "', " + number + ", '" + addition + "', '" + city + "');");

//            Handle any errors that may have occurred.
        } catch (Exception e) {
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
        return "Address created";
    }

    public String createAccount(String accountName, String email, String phonenumber, String password, int addressId) {
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("INSERT INTO Account (Accountname, Email, phonenumber, password, addressId)" +
                        "VALUES ('"+accountName+"', '"+email+"', '"+phonenumber+"', '"+password+"', "+addressId+");");



//            Handle any errors that may have occurred.
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
        return "Account created";
    }

    public String createWatchedProgram(String accountName, String profileName, String programtitle, int percentageWatched, Read read) {
        int programId = read.getProgramId(programtitle);
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("INSERT INTO Profile_Program (AccountName, ProfileName, ProgramId, PercentageWatched)" +
                    "VALUES ('"+accountName+"', '"+profileName+"', "+programId+", "+percentageWatched+");");

//            Handle any errors that may have occurred.
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
        return "Watched program created";
    }
}

