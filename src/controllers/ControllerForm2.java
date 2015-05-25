package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import object.Client;

/**
 * Created by Юлия on 07.05.2015.
 */
public class ControllerForm2 {
    private Client client;
    private Stage stage;

    @FXML
    private TextField idNumber;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;

    public void Exit() {
        idNumber.setText("");
        name.setText("");
        surname.setText("");
        stage.close();
    }

    public void OK() {
        if (idNumber.getLength() != 0 && name.getLength() != 0 && surname.getLength() != 0) {
            client = new Client(getIdNumber(), getName(), getSurname());
        }
        Exit();
    }

    public int getIdNumber() {
        return Integer.parseInt(idNumber.getText());
    }

    public void setIdNumber(int idNumber) {
        this.idNumber.setText(Integer.toString(idNumber));
    }

    public String getName() {
        return name.getText();
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public String getSurname() {
        return surname.getText();
    }

    public void setSurname(String surname) {
        this.surname.setText(surname);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
