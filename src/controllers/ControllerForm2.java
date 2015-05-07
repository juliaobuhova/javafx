package controllers;

import database.ModifyCollectionClients;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import object.Client;

/**
 * Created by Юлия on 07.05.2015.
 */
public class ControllerForm2 {
   private ModifyCollectionClients clientsCollection = new ModifyCollectionClients();

    @FXML
    private Button closeButton;
    @FXML
    private TextField idNumber;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
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
    public void Exit() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void OK() {
        Client client = new Client(Integer.parseInt(idNumber.getText()), name.getText(), surname.getText());
        ModifyCollectionClients clients = new ModifyCollectionClients();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        if (stage.getTitle() == "Add") {
            clients.insert(client);
        }
        else {
            clients.update(client);
        }
        stage.close();
        ControllerForm1 control = new ControllerForm1();
        control.refresh();
      //  table = control.getTable();
     //   idNumberColumn = control.getIdNumberColumn();
     //   firstNameColumn = control.getFirstNameColumn();
      //  lastNameColumn = control.getLastNameColumn();
//        idNumberColumn.setCellValueFactory(new PropertyValueFactory<Client, Integer>("idNumber"));
  //      firstNameColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("firstName"));
   //     lastNameColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("lastName"));
      //  clients.FillCollection();
 //       table.setItems(getClientsCollection().getClients());
    }

}
