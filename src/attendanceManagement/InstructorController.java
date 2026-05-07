package attendanceManagement;

import attendance.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

public class InstructorController {

    @FXML private TextField addCourseId;
    @FXML private TextField addCourseName;
    @FXML private TextField addCredits;
    @FXML private TextField markCourseId;
    @FXML private CheckBox markPresent;
    @FXML private TextField markStudentId;
    @FXML private TextArea outputArea;
    @FXML private TextField reportCourseId;

    private Instructor currentInstructor;

    @FXML
    public void initialize() {
        
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) {
                Platform.runLater(() -> outputArea.appendText(String.valueOf((char) b)));
            }
        };
        System.setOut(new PrintStream(out, true));
    }

    public void setInstructor(Instructor instructor) {
        this.currentInstructor = instructor;
    }

    @FXML
    void addCourseBtn(ActionEvent event) {
        try {
            
            currentInstructor.addCourse(
                addCourseName.getText(), 
                addCourseId.getText(), 
                Integer.parseInt(addCredits.getText())
            );
        } catch (NumberFormatException e) {
            System.out.println("Error: Credits must be a number.");
        }
    }

    @FXML
    void markAttendanceBtn(ActionEvent event) {
        
        currentInstructor.markAttendance(
            markStudentId.getText(), 
            new Date(), 
            markPresent.isSelected(), 
            markCourseId.getText()
        );
    }

    @FXML
    void reportBtn(ActionEvent event) {
        outputArea.clear();
        
        currentInstructor.viewAttendanceReport(reportCourseId.getText());
    }

    @FXML
    void goBackBtn(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("mainMenu.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("Navigation Error: " + e.getMessage());
        }
    }
}