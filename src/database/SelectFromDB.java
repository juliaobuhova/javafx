package database;

import object.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import static java.lang.System.out;

public class SelectFromDB {
    public static void selectRecordsFromDbClientsTable(String DB_DRIVER, String DB_CONNECTION, String DB_USER,
                                                String DB_PASSWORD, Collection<Client> clients) throws SQLException, ClassNotFoundException {
        Connection dbConnection = null;
        Statement statement = null;
        String selectTableSQL = "SELECT * from clients";
        try {
            dbConnection = DBConnection.getDBConnection(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD);
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                clients.add(new Client(rs.getInt("id_number"), rs.getString("first_name"), rs.getString("last_name")));
            }
        }
        catch (SQLException e) {
            out.println(e.getMessage());
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void select(String DB_DRIVER, String DB_CONNECTION, String DB_USER, String DB_PASSWORD, String search,
                       Collection<Client> clients) throws SQLException, ClassNotFoundException {
        Connection dbConnection = null;
        Statement statement = null;
        String selectTableSQL = "SELECT * from clients WHERE id_number LIKE '%" + search + "%' OR first_name LIKE '%" +
                search + "%' OR last_name LIKE '%" + search + "%'";
        try {
            dbConnection = DBConnection.getDBConnection(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD);
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                clients.add(new Client(rs.getInt("id_number"), rs.getString("first_name"), rs.getString("last_name")));
            }
        }
        catch (SQLException e) {
            out.println(e.getMessage());
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
}
