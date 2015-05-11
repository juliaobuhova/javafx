package controllers;

import database.ModifyCollectionClients;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import object.Client;

/**
 * Created by Юлия on 07.05.2015.
 */
public class ControllerForm2 {
    private ModifyCollectionClients clients = new ModifyCollectionClients();
    private ControllerForm1 parent;

    @FXML
    private Button closeButton;
    @FXML
    private TextField idNumber;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;

    @FXML
    public void Exit() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void OK() {
        clients.fillCollection();
        Client client = new Client(Integer.parseInt(idNumber.getText()), name.getText(), surname.getText());
        Stage stage = (Stage) closeButton.getScene().getWindow();
        if (stage.getTitle() == "Add") {
            clients.setController(parent);
            clients.insert(client);
        }
        else {
            clients.setController(parent);
            clients.update(client);
        }
        stage.close();
    }

    public void setParent (ControllerForm1 controller) {
        parent = controller;
    }
}
