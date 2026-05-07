package attendance;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class Course implements Serializable{

    private String courseId;
    private String courseName;
    private int credit;
    // private Instructor instructor;
    private ArrayList<Attendance> attendanceList;
    private ArrayList<Student> studentList;

    public Course(){}

    public Course(String courseId, String courseName, int credit){
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        attendanceList = new ArrayList<>();
        studentList = new ArrayList<>();
    }

    public String getCourseId(){
        return courseId;
    }

    public String getCourseName(){
            return courseName;
    }

    public void enrollStudent(Student s){
        studentList.add(s);
    }

    public void markAttendance(String studentId,Date d,boolean present){
        Student found = null;
        for(Student s:studentList){
            if (s.getRollNo().equals(studentId)){
                found = s;
                break;
            }
        }
        if(found!=null){
            Attendance a = new Attendance(found,this,d,present);
            attendanceList.add(a);
            System.out.println("Attendance updated");
        }
        else{
            System.out.println("Student not found in student list for course");
        }
    }

    // public void setInstructor(Instructor i){
    //     this.instructor = i;
    // } 

    public void getAttendencePercentage(String rollno){
        int totalClasses=0;
        int classesPresent=0;

        for(Attendance a:attendanceList){
            if(a.getStudent().getRollNo().equals(rollno)){
                totalClasses++;
                if (a.getPresentStatus()){
                    classesPresent++;       
                }
            }
        }  

        if (totalClasses > 0) {
                double percentage = ((double) classesPresent / totalClasses) * 100;
                System.out.println("Attendance for " + rollno + "for the course "+ courseName + "(CourseID: "+ courseId + ")" +": " + percentage + "%");
            } 
        else {
            System.out.println("No records found.");
        }  
    }  

    public ArrayList<Attendance> getAttendanceList() {
        return attendanceList;
    }

    // public String getInstructor(){
    //     return instructor.getInstructorId();
    // }

    public ArrayList<Student> getStudentList(){
        return studentList;
    }

    public void getAttendanceReport() {
        for (Attendance a : attendanceList) {
            // System.out.println("Student: " + a.getStudent().getName() + 
            //                    " | Status: " + (a.getPresentStatus() ? "Present" : "Absent"));
            System.out.println(a.toString());
        }
    }
}