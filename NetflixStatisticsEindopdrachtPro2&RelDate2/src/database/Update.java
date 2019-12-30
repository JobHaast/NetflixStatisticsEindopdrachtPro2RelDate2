package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
        return "";
    }

    public String updateAddress(String city, String streetName, int number, String addition){
        return "";
    }

    public String updateProfile(){
        return "";
    }

    public String updateWatchedProgram(){
        return "";
    }
}
