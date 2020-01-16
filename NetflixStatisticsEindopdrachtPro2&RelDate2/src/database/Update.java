package database;

import logic.Account;
import logic.Address;

import java.sql.*;
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

    //Method for updating an account
    public String updateAccount(String accountName, String email, String phoneNumber, String password){
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("UPDATE Account \n" +
                    "SET Email = '"+email+"', PhoneNumber = '"+phoneNumber+"', Password = '"+password+"' WHERE AccountName = '"+accountName+"';");

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
        return "Account updated";
    }

    //Method for updating an address
    public String updateAddress(String city, String streetName, int number, String addition, Read read){
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            if(read.getAddresses().size() == 0){
                // Execute the query
                statement.executeUpdate("UPDATE Account \n" +
                        "SET Email = 'emai.hotmail.com', PhoneNumber = '0690675432', Password = 'noah', AddressId = '1'\n" +
                        "WHERE AccountName = 'Noah';");
            }else{
                throw new Exception("Error");
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
        return "Address updated";
    }

    //Method for updating a profile
    public String updateProfile(String accountName, String profileName, String profileLanguage, String birthDay){
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
                // Execute the query
            statement.executeUpdate("UPDATE Profile \n" +
                        "SET ProfileLanguage = '"+profileLanguage+"', Birthday = '"+birthDay+"'\n" +
                        "WHERE AccountName = '"+accountName+"' AND ProfileName = '"+profileName+"';");

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
        return "Profile updated";
    }

    //Method for updating a watched program
    public String updateWatchedProgram(String accountName, String profileName, int programId, int percentageWatched){
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("UPDATE Profile_Program \n" +
                    "SET PercentageWatched = '"+percentageWatched+"'\n" +
                    "WHERE AccountName = '"+accountName+"' AND ProfileName = '"+profileName+"' AND ProgramId = "+programId+";");

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
        return "Watched program updated";
    }

    //Method for updating an administrator
    public String updateAdministrator(String accountName, String passWord){
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("UPDATE Administrator(Password)" +
                    "VALUES('"+passWord+"')" +
                    "WHERE AccountName = '"+accountName+"';");

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
        return "Administrator updated";
    }
}
