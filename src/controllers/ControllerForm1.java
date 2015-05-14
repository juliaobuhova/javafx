package controllers;

import database.ModifyCollectionClients;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import object.Client;
import javafx.event.ActionEvent;
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

import java.io.IOException;

public class ControllerForm1 {
    private ModifyCollectionClients clients = new ModifyCollectionClients();
    private Parent form2;
    private FXMLLoader loader = new FXMLLoader();
    private ControllerForm2 controllerForm2;
    private Stage stage = new Stage();

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
            stage.initModality(Modality.WINDOW_MODAL);
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
                if (event.getClickCount() == 1) {
                    controllerForm2.setClient((Client) table.getSelectionModel().getSelectedItem());
                }
            }
        });
    }

    public void SearchData(ActionEvent actionEvent) {
    }

    public void removeClient() {
        clients.remove(controllerForm2.getClient());
    }

    public void updateClient() {
        controllerForm2.setIdNumber(controllerForm2.getClient().getIdNumber());
        controllerForm2.setName(controllerForm2.getClient().getFirstName());
        controllerForm2.setSurname(controllerForm2.getClient().getLastName());
        stage.showAndWait();
        if (controllerForm2.getClient() != null) {
            clients.update(controllerForm2.getClient());
            controllerForm2.setClient(new Client());
        }
        table.getColumns().clear();
        table.getColumns().addAll(idNumberColumn, firstNameColumn, lastNameColumn);
    }

    public void addClient() {
        controllerForm2.getFieldIdNumber().setText("");
        controllerForm2.getFieldName().setText("");
        controllerForm2.getFieldSurname().setText("");
        stage.showAndWait();
        if (controllerForm2.getClient() != null) {
            clients.insert(controllerForm2.getClient());
            controllerForm2.setClient(new Client());
        }
    }

}