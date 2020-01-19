package database;

import java.sql.*;


public class Create {
    //String needed to make a connection to your database.
    private String connectionUrl;
    //Connection controls information about the connection with the database.
    private Connection con;
    //Statement that allows to execute a query.
    private Statement statement;
    //Result of a query is stored in here.
    private ResultSet resultSet;

    public Create(String connectionUrl) {
        this.connectionUrl = connectionUrl;
        this.con = null;
        this.statement = null;
        this.resultSet = null;
    }

    //Method for creating address
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
            //This query inserts an address in the table called Address. The variables streetname, number, addition and city are inserted.

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
        return "Address created";
    }

    //Method for creating account
    public String createAccount(String accountName, String email, String phonenumber, String password, int addressId) {
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("INSERT INTO Account (Accountname, Email, phonenumber, password, addressId)" +
                    "VALUES ('" + accountName + "', '" + email + "', '" + phonenumber + "', '" + password + "', " + addressId + ");");
            //This query inserts an account in the table called Account. The variables accountName, email, phonenumber, password and addressId are inserted.


//          Handle any errors that may have occurred.
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

    //Method for creating watched program
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
                    "VALUES ('" + accountName + "', '" + profileName + "', " + programId + ", " + percentageWatched + ");");
//This query inserts a watched program in the table called Profile_Program. The variables accountName, profileName, programId and percentageWatched are inserted.

//Handle any errors that may have occurred.
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

    //Method for creating profile
    public String createProfile(String accountName, String profileName, String profileLanguage, String birthDay) {
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            statement.executeUpdate("INSERT INTO Profile (AccountName, ProfileName, ProfileLanguage, Birthday)" +
                    "VALUES ('" + accountName + "', '" + profileName + "', '" + profileLanguage + "', '" + birthDay + "');");
//This query inserts a profile in the table called Profile. The variables accountName, profileName, profileLanguage and brithDay are inserted.

//Handle any errors that may have occurred.
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
        return "Profile created";
    }
}

