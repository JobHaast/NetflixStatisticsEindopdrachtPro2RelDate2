package database;

import java.sql.*;


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
    public String updateAccount(String accountName, String email, String phoneNumber, String password) {
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("UPDATE Account \n" +
                    "SET Email = '" + email + "', PhoneNumber = '" + phoneNumber + "', Password = '" + password + "' WHERE AccountName = '" + accountName + "';");
//            This query updates an account in the table called Account. Email is replaced by the variable email and Phonenumber is replaced by the variable Phonenumber where the Account name corresponds with the variable accountName.

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
        return "Account updated";
    }

    //Method for updating an address (currently not being used)
    public String updateAddress(String city, String streetName, int number, String addition, Read read) {
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            if (read.getAddresses().size() == 0) {
                // Execute the query
                statement.executeUpdate("");
            } else {
                throw new Exception("Error");
            }

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
        return "Address updated";
    }

    //Method for updating a profile
    public String updateProfile(String accountName, String profileName, String profileLanguage, String birthDay) {
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("UPDATE Profile \n" +
                    "SET ProfileLanguage = '" + profileLanguage + "', Birthday = '" + birthDay + "'\n" +
                    "WHERE AccountName = '" + accountName + "' AND ProfileName = '" + profileName + "';");
//            This query updates a profile in the table called Profile. ProfileLanguage is replaced by the variable profileLanguage and BirthDay is replaced by the variable birthDay
//            where the Account name corresponds with the variable accountName and ProfileName corresponds with the variable profileName.


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
        return "Profile updated";
    }

    //Method for updating a watched program
    public String updateWatchedProgram(String accountName, String profileName, int programId, int percentageWatched) {
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("UPDATE Profile_Program \n" +
                    "SET PercentageWatched = '" + percentageWatched + "'\n" +
                    "WHERE AccountName = '" + accountName + "' AND ProfileName = '" + profileName + "' AND ProgramId = " + programId + ";");
//            This query updates a watched program in the table called Profile_WatchedProgram. PercentageWatched is replaced by the variable percentageWatched where the Accountname corresponds with the variable accountName,
//            the ProfileName corresponds with the variable profileName and Programid corresponds with the variable programId.


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
        return "Watched program updated";
    }

    //Method for updating an administrator
    public String updateAdministrator(String accountName, String passWord) {
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("UPDATE Account\n" +
                    "SET Password = '" + passWord + "'\n" +
                    "WHERE AccountName = '" + accountName + "';");
//            This query updates an account in the table called Account. Password is replaced by the variable passWord where the Account name corresponds with the variable accountName.


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
        return "Administrator updated";
    }
}
