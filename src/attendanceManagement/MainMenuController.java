package attendanceManagement;

import java.io.IOException;

import attendance.Instructor;
import attendance.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private TextField instructorID;

    @FXML
    private TextField instructorName;

    @FXML
    private TextField studentName;

    @FXML
    private TextField studentRollno;

    @FXML
    void instructorClick(ActionEvent event) throws IOException {
        // Extracting info from the text fields
        String id = instructorID.getText();
        String name = instructorName.getText();

        if (id.isEmpty() || name.isEmpty()) {
            System.out.println("Validation Error: Please fill all Instructor fields.");
            return;
        }

        // Creating the object using your constructor
        Instructor currentInstructor = new Instructor(id, name);

        // Loading the next scene and passing the object
        FXMLLoader loader = new FXMLLoader(getClass().getResource("instructorMenu.fxml"));
        Parent root = loader.load();

        InstructorController controller = loader.getController();
        controller.setInstructor(currentInstructor); // Handing over the object

        switchTheScene(event, root);
    }

    @FXML
    void studentClick(ActionEvent event) throws IOException {
        String roll = studentRollno.getText();
        String name = studentName.getText();

        if (roll.isEmpty() || name.isEmpty()) {
            System.out.println("Validation Error: Please fill all Student fields.");
            return;
        }

        // Creating the object
        Student currentStudent = new Student(roll, name);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("studentMenu.fxml"));
        Parent root = loader.load();

        StudentController controller = loader.getController();
        controller.setStudent(currentStudent); // Handing over the object

        switchTheScene(event, root);
    }

    private void switchTheScene(ActionEvent event, Parent root) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
