package attendanceManagement;

import attendance.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.OutputStream;
import java.io.PrintStream;

public class StudentController {

    @FXML private TextField addCourseId;
    @FXML private TextArea outputArea;
    @FXML private TextField viewCourseAtdn;

    private Student currentStudent;

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

    
    public void setStudent(Student student) {
        this.currentStudent = student;
    }

    @FXML
    void addCourseBtn(ActionEvent event) {
        try {
            String id = addCourseId.getText();

            
            currentStudent.enrollCourse(id);
            
            
            addCourseId.clear();
        } catch (NumberFormatException e) {
            System.out.println("Error: Credits must be a number.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void viewAttendance(ActionEvent event) {
        
        outputArea.clear(); 
        
        
        String courseId = viewCourseAtdn.getText();
        
        
        if (courseId == null || courseId.trim().isEmpty()) {
            System.out.println("Please enter a Course ID to view attendance.");
            return;
        }

        
        if (currentStudent != null) {
            currentStudent.viewAttendance(courseId);
        } else {
            System.out.println("Error: No student session found. Please log in again.");
        }
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