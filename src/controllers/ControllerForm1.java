package controllers;

import database.ModifyCollectionClients;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import object.Client;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerForm1 {
    private ModifyCollectionClients clients = new ModifyCollectionClients();
    private Parent form2;
    private FXMLLoader loader = new FXMLLoader();
    private ControllerForm2 controllerForm2;
    private Stage stage = new Stage();
    private ArrayList<Client> filteredData = new ArrayList<>(clients.getClients());

    @FXML
    private TableView<Client> table;
    @FXML
    private TableColumn<Client, Integer> idNumberColumn;
    @FXML
    private TableColumn<Client, String> firstNameColumn;
    @FXML
    private TableColumn<Client, String> lastNameColumn;
    @FXML
    private Label amountOfRecords;
    @FXML
    private TextField search;

    @FXML
    private void initialize() {
        idNumberColumn.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        initController();
        initListeners();
        clients.fillCollection();
        table.setItems(clients.getClients());
        updateAmountOfRecords();
    }

    public void updateAmountOfRecords() {
        amountOfRecords.setText("Количество записей: " + table.getItems().size());
    }

    private void initController() {
        try {
            loader.setLocation(getClass().getResource("/windows/form2.fxml"));
            form2 = loader.load();
            controllerForm2 = loader.getController();
            stage.setTitle("Add or update");
            stage.setMinHeight(212);
            stage.setMinWidth(400);
            stage.setResizable(false);
            stage.getIcons().add(new Image("/style/icon.png"));
            stage.setScene(new Scene(form2));
            stage.initModality(Modality.APPLICATION_MODAL);
            controllerForm2.setStage(stage);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initListeners() {
        clients.getClients().addListener(new ListChangeListener<Client>() {
            @Override
            public void onChanged(Change<? extends Client> c) {
                updateAmountOfRecords();
            }
        });
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                controllerForm2.setClient(table.getSelectionModel().getSelectedItem());
            }
        });
    }

    public void searchData() {
        clients.getClients().clear();
        //Поиск в базе данных
/*
        try {
            SelectFromDB.select(clients.getDB_DRIVER(), clients.getDB_CONNECTION(), clients.getDB_USER(),
                    clients.getDB_PASSWORD(), search.getText(), clients.getClients());
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
*/
        //Поиск в коллекции

        clients.fillCollection();
        filteredData.clear();
        for (Client i: clients.getClients()) {
            if (compareFilterAndData(i)) {
                filteredData.add(i);
            }
        }
        clients.getClients().clear();
        clients.getClients().addAll(filteredData);
        updateAmountOfRecords();

    }

    private boolean compareFilterAndData(Client client) {
        if (search.getText() == null || search.getText().isEmpty()) {
            return true;
        }
        if (client.getFirstName().toLowerCase().contains(search.getText().toLowerCase())) {
            return true;
        }
        else if (client.getLastName().toLowerCase().contains(search.getText().toLowerCase())) {
            return true;
        }
        return false;
    }

    public void removeClient() {
        if (controllerForm2.getClient() != null) {
            clients.getClients().clear();
            clients.remove(controllerForm2.getClient());
            controllerForm2.setClient(null);
        }
    }

    public void updateClient() {
        if (controllerForm2.getClient() != null) {
            clients.getClients().clear();
            controllerForm2.setIdNumber(controllerForm2.getClient().getIdNumber());
            controllerForm2.setName(controllerForm2.getClient().getFirstName());
            controllerForm2.setSurname(controllerForm2.getClient().getLastName());
        }
        stage.showAndWait();
        if (controllerForm2.getClient() != null) {
            clients.update(controllerForm2.getClient());
            controllerForm2.setClient(null);
        }
    }

    public void addClient() {
        stage.showAndWait();
        if (controllerForm2.getClient() != null) {
            clients.getClients().clear();
            clients.insert(controllerForm2.getClient());
            controllerForm2.setClient(null);
        }
    }

}