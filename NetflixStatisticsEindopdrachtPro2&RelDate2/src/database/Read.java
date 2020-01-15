package database;

import logic.*;

import java.lang.reflect.Array;
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

    public String getLongestMovieUnder16() {
        String movie = "";
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT TOP 1 Program.Title, Program.Length\n" +
                    "FROM Film,Program\n" +
                    "WHERE Program.ProgramId = Film.ProgramId\n" +
                    "AND Film.AgeGroup < 16\n" +
                    "ORDER BY Film.AgeGroup Desc");

            while (resultSet.next()) {
                movie = resultSet.getString("Title");
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

        return movie;
    }

    public ArrayList<String> getTitlePrograms() {
        ArrayList<String> titles = new ArrayList<>();
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("(SELECT Title\n" +
                    "FROM Program\n" +
                    "JOIN Film ON Film.ProgramId = Program.ProgramId\n" +
                    ")\n" +
                    "UNION\n" +
                    "(\n" +
                    "SELECT Name\n" +
                    "FROM Episode\n" +
                    ")");

            while (resultSet.next()) {
                titles.add(resultSet.getString("Title"));
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
        return titles;
    }

    public int getProgramId(String programTitle) {
        int id = 0;
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT ProgramId FROM Program WHERE Title = '"+programTitle+"'");

            while (resultSet.next()) {
                id = resultSet.getInt("ProgramId");
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
        return id;
    }

    public ArrayList<String> getWatchedPrograms(String accountName, String profileName){
        ArrayList<String> films = new ArrayList<>();

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
                    "JOIN Profile_Program ON Profile.ProfileName = Profile_Program.ProfileName AND Profile.AccountName = Profile_Program.AccountName\n" +
                    "JOIN Program ON Profile_Program.ProgramId = Program.ProgramId\n" +
                    "WHERE Account.AccountName = '"+accountName+"' AND Profile.ProfileName = '"+profileName+"';");

            while (resultSet.next()) {
                films.add(resultSet.getString("Title"));
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

    public int checkIfAddressExists(String streetName, int number, String addition, String city){
        int addressId = 0;

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT AddressId FROM Address WHERE StreetName = '"+streetName+"' AND Number = "+number+" AND Addition = '"+addition+"' AND City = '"+city+"' ");

            while (resultSet.next()) {
                addressId = resultSet.getInt("AddressId");
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
        return addressId;
    }

    public int getHighestAddressId(){
        int addressId = 0;

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT MAX(AddressId) as 'AddressId' FROM Address;");

            while (resultSet.next()) {
                addressId = resultSet.getInt("AddressId");
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
        return addressId;
    }

    public ArrayList<String> getProfile(String accountName, String profileName){
        ArrayList<String> profile = new ArrayList<>();

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT ProfileName FROM Profile WHERE ProfileName = '"+profileName+"' AND AccountName = '"+accountName+"';");

            while (resultSet.next()) {
                profile.add(resultSet.getString("ProfileName"));
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
        return profile;
    }

    public ArrayList<String> getwatchedProgram(String accountName, String profileName, String programTitle){
        ArrayList<String> watchedProgram = new ArrayList<>();
        Read read = new Read("jdbc:sqlserver://localhost;databaseName=NetflixStatistix;integratedSecurity=true;");

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT ProfileName FROM Profile_Program WHERE ProfileName = '"+profileName+"' AND AccountName = '"+accountName+"' AND ProgramId = "+read.getProgramId(programTitle)+";");

            while (resultSet.next()) {
                watchedProgram.add(resultSet.getString("ProfileName"));
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
        return watchedProgram;
    }
}
