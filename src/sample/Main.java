package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/windows/form1.fxml"));
        primaryStage.setTitle("Work with database");
        primaryStage.setMinHeight(525);
        primaryStage.setMinWidth(500);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.getIcons().add(new Image("/sample/style/icon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
