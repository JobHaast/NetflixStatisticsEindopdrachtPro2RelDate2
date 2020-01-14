package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Update {
    //String needed to make a connection to your database.
    private String connectionUrl;
    //Connection controls information about the connection with the database.
    private Connection con;
    //Statement that allows to execute a query.
    private Statement statement;
    //Result of a query is store in here.
    private ResultSet resultSet;

    public Update(String connectionUrl) {
        this.connectionUrl = connectionUrl;
        this.con = null;
        this.statement = null;
        this.resultSet = null;
    }

    public String updateAccount(String accountName, String email, String phoneNumber, String password, String addressId){
        ArrayList<String> films = new ArrayList<>();

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("UPDATE Account \n" +
                    "SET Email = '', PhoneNumber = '0690675432', Password = 'noah', AddressId = '1'\n" +
                    "WHERE AccountName = 'Noah';");

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
        return "Updated account";
    }

    public String updateAddress(String city, String streetName, int number, String addition){
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("");


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
        return "Address updated";
    }

    public String updateProfile(){
        return "";
    }

    public String updateWatchedProgram(){
        return "";
    }
}
