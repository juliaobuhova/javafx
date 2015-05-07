package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import object.Client;

public class Main extends Application {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static String getDB_DRIVER() {
        return DB_DRIVER;
    }

    public static String getDB_CONNECTION() {
        return DB_CONNECTION;
    }

    public static String getDB_USER() {
        return DB_USER;
    }

    public static String getDB_PASSWORD() {
        return DB_PASSWORD;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/windows/form1.fxml"));
        primaryStage.setTitle("Work with database");
        primaryStage.setMinHeight(525);
        primaryStage.setMinWidth(500);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.getIcons().add(new Image("/style/icon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
