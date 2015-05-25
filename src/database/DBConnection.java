package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.out;

public class DBConnection {
    public static Connection getDBConnection(String DB_DRIVER, String DB_CONNECTION, String DB_USER, String DB_PASSWORD)
            throws ClassNotFoundException, SQLException {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        }
        catch (SQLException | ClassNotFoundException e) {
            out.println(e.getMessage());
        }
        return dbConnection;
    }
}
