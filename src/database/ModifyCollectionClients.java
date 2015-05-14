package database;

import abstraction.Intrfc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import object.Client;

import java.sql.SQLException;

/**
 * Created by Юлия on 07.05.2015.
 */
public class ModifyCollectionClients implements Intrfc {
    private ObservableList<Client> clients = FXCollections.observableArrayList();

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static String getDB_DRIVER() { return DB_DRIVER; }

    public static String getDB_CONNECTION() {
        return DB_CONNECTION;
    }

    public static String getDB_USER() {
        return DB_USER;
    }

    public static String getDB_PASSWORD() {
        return DB_PASSWORD;
    }

    public ObservableList<Client> getClients() {
        return clients;
    }

    @Override
    public void insert(Client client) {
        clients.add(client);
        try {
            new ModifyTableClients().insert(getDB_DRIVER(), getDB_CONNECTION(), getDB_USER(), getDB_PASSWORD(), client);
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client client) {
        for (Client i: clients) {
            if (i.getIdNumber() == client.getIdNumber()) {
                i.setFirstName(client.getFirstName());
                i.setLastName(client.getLastName());
            }
        }
        try {
            new ModifyTableClients().update(getDB_DRIVER(), getDB_CONNECTION(), getDB_USER(), getDB_PASSWORD(), client);
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Client client) {
        try {
            new ModifyTableClients().remove(getDB_DRIVER(), getDB_CONNECTION(), getDB_USER(), getDB_PASSWORD(), client.getIdNumber());
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        clients.remove(client);
    }

    public void fillCollection () {
        try {
            new SelectFromDB().selectRecordsFromDbClientsTable(getDB_DRIVER(), getDB_CONNECTION(), getDB_USER(),
                    getDB_PASSWORD(), clients);
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
