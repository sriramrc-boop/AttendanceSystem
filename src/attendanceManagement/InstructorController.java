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
        // Redirect System.out.println from Instructor.java to the TextArea
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
        System.out.println("Instructor Session Active: " + instructor.getInstructorName());
    }

    @FXML
    void addCourseBtn(ActionEvent event) {
        try {
            // Matches: addCourse(String courseName, String courseId, int credit)
            currentInstructor.addCourse(
                addCourseName.getText(), 
                addCourseId.getText(), 
                Integer.parseInt(addCredits.getText())
            );
            System.out.println("Process completed for Course ID: " + addCourseId.getText());
        } catch (NumberFormatException e) {
            System.out.println("Error: Credits must be a number.");
        }
    }

    @FXML
    void markAttendanceBtn(ActionEvent event) {
        // Matches: markAttendance(String studentId, Date d, boolean present, String courseId)
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
        // Matches: viewAttendanceReport(String courseId)
        // This will trigger c.getAttendanceReport() which prints to System.out
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