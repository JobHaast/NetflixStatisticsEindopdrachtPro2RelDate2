package database;

import javafx.beans.property.SimpleStringProperty;
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

    //Method for getting one value from the database
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

    //Method for retrieving addressinfo (Currently not being used)
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

    //Method for retrieving filmInfo
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

    //Method for retrieving seriesInfo
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

    //Method for retrieving all addresses
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

    //method for retrieving all account names
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

    //Method for retrieving all profile names
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

    //method for retrieving an account
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

    //Method for retrieving all watched films for a specific account
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

    //Method for retrieving the longest movie for people under 16
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

    //method for retrieving all titles of programs
    public ArrayList<String> getTitlePrograms() {
        ArrayList<String> titles = new ArrayList<>();
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT Title FROM Program");

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

    //Method for retrieving a programId
    public int getProgramId(String programTitle) {
        int id = 0;
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            if (programTitle.contains("\'")) {
                programTitle = programTitle.replace("\'", "\'\'");
            }

            resultSet = statement.executeQuery("(SELECT ProgramId FROM Program WHERE Title = '"+programTitle+"') UNION (SELECT ProgramId FROM Episode WHERE Name = '"+programTitle+"');");

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

    //Method for retrieving all watched programs for a certain profile
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

    //Method that checks if an address already exists
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

    //method that retrieves the highest addressId
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

    //Method for retrieving a profile
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

    //Method for retrieving a watched program
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

    //Method for check if an account exists
    public ArrayList<String> getAccountCheck(String accountName){
        ArrayList<String> accountNameCheck = new ArrayList<>();
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT * FROM Account WHERE AccountName = '"+accountName+"';");

            while (resultSet.next()) {
                accountNameCheck.add(resultSet.getString("AccountName"));
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
        return accountNameCheck;
    }

    //method for retrieving amount of profiles
    public int amountOfProfiles(String accountName){
        int i = 0;
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT COUNT(ProfileName) AS 'ProfileAmount' FROM Profile WHERE AccountName = '"+accountName+"';");

            while (resultSet.next()) {
                i = resultSet.getInt("ProfileAmount");
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
        return i;
    }

    //Method for retrieving addressId (currently not being used)
    public int getAddressId(String accountName){
        int i = 0;
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT AddressId FROM Account WHERE AccountName = '"+accountName+"';");

            while (resultSet.next()) {
                i = resultSet.getInt("AddressId");
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
        return i;
    }

    //Method for retrieving accounts with same address (currently not being used)
    public ArrayList<String> getAccountWithAddressId(int addressId){
        ArrayList<String> accounts = new ArrayList<>();
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT AccountName WHERE AddressId = '"+addressId+"';");

            while (resultSet.next()) {
                accounts.add(resultSet.getString("AccountName"));
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
        return accounts;
    }

    //Method for retrieving permission
    public int checkAdminPermission(String accountName){
        int i = 0;
        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT IsAdmin FROM Administrator WHERE AccountName = '"+accountName+"';");

            while (resultSet.next()) {
                i = resultSet.getInt("IsAdmin");

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
        return i;
    }

    //Method for retrieving accounts with one profile
    public ArrayList<StringForTableView> getAccountsWithOneProfile(){
        ArrayList<StringForTableView> accounts = new ArrayList<>();

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT AccountName, COUNT(ProfileName) as 'Amount' FROM Profile GROUP BY AccountName HAVING COUNT(ProfileName) = 1;");

            while (resultSet.next()) {
                accounts.add(new StringForTableView(resultSet.getString("AccountName")));
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
        return accounts;
    }

    //Method for retrieving serieNames
    public ArrayList<String> getSerieNames(){
        ArrayList<String> series = new ArrayList<>();

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT Name FROM Series;");

            while (resultSet.next()) {
                series.add(resultSet.getString("Name"));
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
        return series;
    }

    //Method for retrieving the avg watched episodes from a selected account
    public ArrayList<EpisodeAvgWatchedSelAcc> getEpisodeAvgWatchedSelAcc(String accountName, String serieName){
        ArrayList<EpisodeAvgWatchedSelAcc> series = new ArrayList<>();

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT Episode.EpisodeNumber, Episode.SeasonNumber, Program.Title, AVG(Profile_Program.PercentageWatched) AS AveragePercentage\n" +
                    "FROM Profile\n" +
                    "JOIN Profile_Program ON Profile.ProfileName = Profile_Program.ProfileName\n" +
                    "JOIN Program ON Profile_Program.ProgramId = Program.ProgramId\n" +
                    "JOIN Episode ON Episode.ProgramId = Program.ProgramId\n" +
                    "WHERE Profile.AccountName = '"+accountName+"' AND Episode.Name = '"+serieName+"'\n" +
                    "GROUP BY Episode.EpisodeNumber, Episode.SeasonNumber, Program.Title\n" +
                    "ORDER BY SeasonNumber");

            while (resultSet.next()) {
                series.add(new EpisodeAvgWatchedSelAcc(resultSet.getInt("EpisodeNumber"), resultSet.getInt("SeasonNumber"), resultSet.getString("Title"), resultSet.getInt("AveragePercentage")));
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
        return series;
    }

    //Method for retrieving all the episodes from one serie
//    public ArrayList<> getEpisodeAvgWatched

    //Method for retrieving films
    public ArrayList<String> getFilms(){
        ArrayList<String> films = new ArrayList<>();

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            resultSet = statement.executeQuery("SELECT Title\n" +
                    "FROM Program\n" +
                    "JOIN Film ON Film.ProgramId = Program.ProgramId ");

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

    //Method for retrieving watched movies
    public int getAmountWatchedMovie(String filmTitle){
        int amount = 0;

        try {
            // Import the downloaded driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Make a connection with the database
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            // Execute the query
            if (filmTitle.contains("\'")) {
                filmTitle = filmTitle.replace("\'", "\'\'");
            }

            resultSet = statement.executeQuery("SELECT COUNT(*) as 'Amount'\n" +
                    "FROM Program\n" +
                    "JOIN Profile_Program ON Profile_Program.ProgramId = Program.ProgramId\n" +
                    "WHERE Title = '"+filmTitle+"' AND PercentageWatched = 100;");

            while (resultSet.next()) {
                amount = resultSet.getInt("Amount");
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
        return amount;
    }
}
