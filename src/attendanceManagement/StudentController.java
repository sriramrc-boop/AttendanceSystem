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
        // Redirect System.out.println from Student.java and FileManager.java to the TextArea
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) {
                Platform.runLater(() -> outputArea.appendText(String.valueOf((char) b)));
            }
        };
        System.setOut(new PrintStream(out, true));
    }

    // Called by MainMenuController to pass the logged-in student object
    public void setStudent(Student student) {
        this.currentStudent = student;
        System.out.println("Welcome, " + student.getName() + " [" + student.getRollNo() + "]");
    }

    @FXML
    void addCourseBtn(ActionEvent event) {
        try {
            String id = addCourseId.getText();

            // Calls the backend Student.java logic
            currentStudent.enrollCourse(id);
            
            // Clear fields after adding
            addCourseId.clear();
        } catch (NumberFormatException e) {
            System.out.println("Error: Credits must be a number.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void viewAttendance(ActionEvent event) {
        // 1. Clear the output area so the new report is easy to read
        outputArea.clear(); 
        
        // 2. Get the Course ID from the text field
        String courseId = viewCourseAtdn.getText();
        
        // 3. Validation: Make sure the field isn't empty
        if (courseId == null || courseId.trim().isEmpty()) {
            System.out.println("Please enter a Course ID to view attendance.");
            return;
        }

        // 4. Use the student's own method
        // This will now execute the System.out.println statements inside Student.java
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