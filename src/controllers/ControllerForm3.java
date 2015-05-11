package controllers;

import database.ModifyCollectionClients;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import object.Client;

/**
 * Created by Юлия on 07.05.2015.
 */
public class ControllerForm3 {
    private ModifyCollectionClients clients = new ModifyCollectionClients();
    private ControllerForm1 parent;

    @FXML
    private Button closeButton;
    @FXML
    private TextField idNumber;

    @FXML
    public void Exit() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void OK() {
        Client client = new Client(Integer.parseInt(idNumber.getText()), null, null);
        clients.setController(parent);
        clients.remove(client);
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void setParent (ControllerForm1 controller) {
        parent = controller;
    }
}
