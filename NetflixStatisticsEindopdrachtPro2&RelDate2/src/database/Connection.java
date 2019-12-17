package database;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {

    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Bibliotheek;integratedSecurity=true;";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            String SQL = "SELECT TOP 10 * FROM Boek";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            System.out.print(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

            while(rs.next()) {
                int ISBN = rs.getInt("ISBN");
                String title = rs.getString("Titel");
                String author = rs.getString("Auteur");
                System.out.format("| %7d | %-32s | %-24s | \n", ISBN, title, author);
            }

            System.out.println(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));
        } catch (Exception var25) {
            var25.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception var24) {
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception var23) {
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (Exception var22) {
                }
            }

        }

    }
}
