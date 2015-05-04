package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerForm1 {
    public void ShowForm2(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent form2 = FXMLLoader.load(getClass().getResource("/sample/windows/form2.fxml"));
            stage.setTitle("Add");
            stage.setMinHeight(212);
            stage.setMinWidth(400);
            stage.setResizable(false);
            stage.getIcons().add(new Image("/sample/style/icon.png"));
            stage.setScene(new Scene(form2));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
