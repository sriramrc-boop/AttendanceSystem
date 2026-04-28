package attendanceManagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file you created in Scene Builder
            // This assumes MainMenu.fxml is in the same folder as Driver.java
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Student Attendance System");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false); // Optional: keeps your UI layout from stretching
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Error: Could not load MainMenu.fxml. Ensure the filename matches exactly.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}