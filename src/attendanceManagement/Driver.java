package attendanceManagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the main menu first
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        primaryStage.setTitle("Attendance System");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}