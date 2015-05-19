package database;

import object.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.System.out;

public class ModifyTableClients {
    public static void insert(String DB_DRIVER, String DB_CONNECTION, String DB_USER, String DB_PASSWORD,
                              Client client) throws SQLException, ClassNotFoundException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String request = "INSERT INTO clients (id_number, first_name, last_name) VALUES (?, ?, ?)";
        try {
            dbConnection = DBConnection.getDBConnection(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD);
            statement = dbConnection.prepareStatement(request);
            statement.setInt(1, client.getIdNumber());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.execute();
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

    public static void remove(String DB_DRIVER, String DB_CONNECTION, String DB_USER, String DB_PASSWORD,
                             int idNumber) throws SQLException, ClassNotFoundException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String request = "DELETE FROM clients WHERE id_number=?";
        try {
            dbConnection = DBConnection.getDBConnection(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD);
            statement = dbConnection.prepareStatement(request);
            statement.setInt(1, idNumber);
            statement.execute();
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

    public static void update(String DB_DRIVER, String DB_CONNECTION, String DB_USER, String DB_PASSWORD,
                             Client client) throws SQLException, ClassNotFoundException {
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String request = "UPDATE clients SET first_name=?, last_name=? WHERE id_number=?";
        try {
            dbConnection = DBConnection.getDBConnection(DB_DRIVER, DB_CONNECTION, DB_USER, DB_PASSWORD);
            statement = dbConnection.prepareStatement(request);
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setInt(3, client.getIdNumber());
            statement.execute();
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
