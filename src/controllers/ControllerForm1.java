package controllers;

import database.ModifyCollectionClients;
import javafx.scene.control.Label;
import object.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private ControllerForm2 childrenForm2;
    private ControllerForm3 childrenForm3;

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
        getIdNumberColumn().setCellValueFactory(new PropertyValueFactory<>("idNumber"));
        getFirstNameColumn().setCellValueFactory(new PropertyValueFactory<>("firstName"));
        getLastNameColumn().setCellValueFactory(new PropertyValueFactory<>("lastName"));
        clients.fillCollection();
        getTable().setItems(clients.getClients());
        getAmountOfRecords().setText("Количество записей: " + getTable().getItems().size());
    }

    public void refresh() {
        getTable().getItems().clear();
        clients.fillCollection();
        getTable().setItems(clients.getClients());
        getAmountOfRecords().setText("Количество записей: " + getTable().getItems().size());
    }

    public void SearchData(ActionEvent actionEvent) {
        getIdNumberColumn().setCellValueFactory(new PropertyValueFactory<Client, Integer>("idNumber"));
        getFirstNameColumn().setCellValueFactory(new PropertyValueFactory<Client, String>("firstName"));
        getLastNameColumn().setCellValueFactory(new PropertyValueFactory<Client, String>("lastName"));
     //   Main main = new Main();
     /*   try {
           // new SelectFromDB().selectRecordsFromDbClientsTable(main.getDB_DRIVER(), main.getDB_CONNECTION(), main.getDB_USER(),
            //        main.getDB_PASSWORD(), main.getClients(), search.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    public void ShowForm2Add(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            ControllerForm2 controller = new ControllerForm2();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/windows/form2.fxml"));
            loader.setController(controller);
            Parent form2 = loader.load();
            childrenForm2 = loader.getController();
            childrenForm2.setParent(this);
            stage.setTitle("Add");
            stage.setMinHeight(212);
            stage.setMinWidth(400);
            stage.setResizable(false);
            stage.getIcons().add(new Image("/style/icon.png"));
            stage.setScene(new Scene(form2));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowForm2Update(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            ControllerForm2 controller = new ControllerForm2();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/windows/form2.fxml"));
            loader.setController(controller);
            Parent form2 = loader.load();
            childrenForm2 = loader.getController();
            childrenForm2.setParent(this);
            stage.setTitle("Update");
            stage.setMinHeight(212);
            stage.setMinWidth(400);
            stage.setResizable(false);
            stage.getIcons().add(new Image("/style/icon.png"));
            stage.setScene(new Scene(form2));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowForm3(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            ControllerForm3 controller = new ControllerForm3();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/windows/form3.fxml"));
            loader.setController(controller);
            Parent form3 = loader.load();
            childrenForm3 = loader.getController();
            childrenForm3.setParent(this);
            stage.setTitle("Remove");
            stage.setMinHeight(212);
            stage.setMinWidth(400);
            stage.setResizable(false);
            stage.getIcons().add(new Image("/style/icon.png"));
            stage.setScene(new Scene(form3));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TableView<Client> getTable() {
        return table;
    }

    public Label getAmountOfRecords() {
        return amountOfRecords;
    }

    public TableColumn<Client, Integer> getIdNumberColumn() {
        return idNumberColumn;
    }

    public TableColumn<Client, String> getFirstNameColumn() {
        return firstNameColumn;
    }

    public TableColumn<Client, String> getLastNameColumn() {
        return lastNameColumn;
    }
}
