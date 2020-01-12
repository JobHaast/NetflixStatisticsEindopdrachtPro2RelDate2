package database;

import logic.*;

import java.sql.*;
import java.util.ArrayList;

public class Read {
    //String needed to make a connection to your database.
    private String connectionUrl;
    //Connection controls information about the connection with the database.
    private Connection con;
    //Statement that allows to execute a query.
    private Statement statement;
    //Result of a query is store in here.
    private ResultSet resultSet;

    public Read(String connectionUrl){
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

    public Address addressInfo(int addressID){
        String streetName = "";
        int number = 0;
        String addition = "";
        String city = "";

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT StreetName, Number, Addition, City FROM Address WHERE AddressID = '"+addressID+"';");

            while (resultSet.next()) {
                streetName = resultSet.getString("StreetName");
                number = resultSet.getInt("Number");
                addition = resultSet.getString("Addition");
                city = resultSet.getString("City");
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

        Address address = new Address(streetName, number, addition, city);
        return address;
    }

    public Film filmInfo(String title){
        String filmTitle = "";
        int length = 0;
        String language = "";
        String genre = "";
        String ageGroup = "";

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT Title, Length, Language, Genre, AgeGroup FROM Film WHERE Title = '"+title+"';");

            while (resultSet.next()) {
                filmTitle = resultSet.getString("Title");
                length = resultSet.getInt("Length");
                language = resultSet.getString("Language");
                genre = resultSet.getString("Genre");
                ageGroup = resultSet.getString("AgeGroup");
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

        Film film = new Film(filmTitle, length, language, genre, ageGroup);
        return film;
    }

    public Serie seriesInfo(String title){
        String seriesTitle = "";
        String language = "";
        String genre = "";
        String recommendation = "";

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT Title, Language, Genre, recommendation FROM Series WHERE Title = '"+title+"';");

            while (resultSet.next()) {
                seriesTitle = resultSet.getString("Title");
                language = resultSet.getString("Language");
                genre = resultSet.getString("Genre");
                recommendation = resultSet.getString("Recommendation");
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

        Serie serie = new Serie(seriesTitle, language, genre, recommendation);
        return serie;
    }

    public ArrayList<Address> getAddresses(){
        ArrayList<Address> addresses = new ArrayList<>();
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT * FROM Address;");

            while (resultSet.next()) {
                String streetName = resultSet.getString("StreetName");
                int number = resultSet.getInt("Number");
                String addition = resultSet.getString("Addition");
                String city = resultSet.getString("City");
                if(addition == null){
                    addition = "";
                }
                addresses.add(new Address(streetName, number, addition, city));
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

        return addresses;
    }

    public ArrayList<String> getAccountsNames(){
        ArrayList<String> namesAccounts = new ArrayList<>();
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT AccountName FROM Account;");

            while (resultSet.next()) {
                namesAccounts.add(resultSet.getString("AccountName"));
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

        return namesAccounts;
    }

    public ArrayList<String> getProfileNames(String accountName){
        ArrayList<String> namesProfiles = new ArrayList<>();

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT ProfileName FROM Profile WHERE AccountName = '"+accountName+"';");

            while (resultSet.next()) {
                namesProfiles.add(resultSet.getString("ProfileName"));
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

        return namesProfiles;
    }

    public Account getAccount(String accountName){
        Account loggedPerson = new Account("n", "@", "0", "x", 1);

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT * FROM Account WHERE AccountName = '"+accountName+"';");

            while (resultSet.next()) {
                loggedPerson = new Account(accountName, resultSet.getString("Email"), resultSet.getString("Phonenumber"), resultSet.getString("Password"), resultSet.getInt("AddressId"));
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

        return loggedPerson;
    }

    public ArrayList<StringForTableView> getWatchedFilms(String accountName){
        ArrayList<StringForTableView> films = new ArrayList<>();

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT Title\n" +
                    "FROM Account\n" +
                    "JOIN Profile ON Account.AccountName = Profile.AccountName\n" +
                    "JOIN Profile_Program ON Profile.ProfileName = Profile_Program.ProfileName\n" +
                    "Join Program ON Profile_Program.ProgramId = Program.ProgramId\n" +
                    "Join Film ON Program.ProgramId = Film.ProgramId\n" +
                    "WHERE Profile_Program.PercentageWatched = 100\n" +
                    "AND Account.AccountName = '"+accountName+"'");

            while (resultSet.next()) {
                films.add(new StringForTableView(resultSet.getString("Title")));
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

        return films;
    }
}
