package controllers;

import com.sun.javafx.scene.control.skin.TableViewSkinBase;
import database.ModifyCollectionClients;
import javafx.scene.control.Label;
import object.Client;
import start.Main;
//import database.SelectFromDB;
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
  //  private ModifyCollectionClients clients = new ModifyCollectionClients();

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
        ModifyCollectionClients clients = new ModifyCollectionClients();
        getIdNumberColumn().setCellValueFactory(new PropertyValueFactory<Client, Integer>("idNumber"));
        getFirstNameColumn().setCellValueFactory(new PropertyValueFactory<Client, String>("firstName"));
        getLastNameColumn().setCellValueFactory(new PropertyValueFactory<Client, String>("lastName"));
        clients.FillCollection();
        getTable().setItems(clients.getClients());
    }

    public void refresh() {
        ModifyCollectionClients clients = new ModifyCollectionClients();
        clients.FillCollection();
        getTable().getProperties().put(TableViewSkinBase.REFRESH, Boolean.TRUE);
      //  getTable().getColumns().clear();
      //  getTable().getColumns().addAll;
      //  getTable().setItems(clients.getClients());
    }

    public void SearchData(ActionEvent actionEvent) {
        getIdNumberColumn().setCellValueFactory(new PropertyValueFactory<Client, Integer>("idNumber"));
        getFirstNameColumn().setCellValueFactory(new PropertyValueFactory<Client, String>("firstName"));
        getLastNameColumn().setCellValueFactory(new PropertyValueFactory<Client, String>("lastName"));
        Main main = new Main();
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
            Parent form2 = FXMLLoader.load(getClass().getResource("/windows/form2.fxml"));
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
            Parent form2 = FXMLLoader.load(getClass().getResource("/windows/form2.fxml"));
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
            Parent form3 = FXMLLoader.load(getClass().getResource("/windows/form3.fxml"));
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
