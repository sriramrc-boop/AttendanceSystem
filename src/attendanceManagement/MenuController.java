package attendanceManagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;

public class MenuController {

    @FXML
    void btnClickedInstructor(ActionEvent event) throws IOException {
        switchScene(event, "student_login.fxml");
    }

    @FXML
    void btnClickedStudent(ActionEvent event) throws IOException {
        switchScene(event, "instructor_login.fxml");
    }

    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}