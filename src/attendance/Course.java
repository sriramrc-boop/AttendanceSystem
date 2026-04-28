package attendance;

import java.util.ArrayList;
import java.util.Date;

public class Course{

    private String courseId;
    private String courseName;
    private int credit;
    private Instructor instructor;
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

    public void markAttendence(Date d,Student s,boolean present){
        Attendance a = new Attendance(s,this,d,present);
            attendanceList.add(a);
    }

    public void setInstructor(Instructor i){
        this.instructor = i;
    } 

    public void getAttendencePercentage(Student s){
        int totalClasses=0;
        int classesPresent=0;

        for(Attendance r:attendanceList){
            if(r.getStudent().equals(s)){
                totalClasses++;
                if (r.getPresentStatus()){
                    classesPresent++;       
                }
            }
        }  

        if (totalClasses > 0) {
                double percentage = ((double) classesPresent / totalClasses) * 100;
                System.out.println("Attendance for " + s.getName() + ": " + percentage + "%");
            } 
        else {
            System.out.println("No records found.");
        }  
    }  

    public ArrayList<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void getAttendanceReport() {
        for (Attendance a : attendanceList) {
            System.out.println("Student: " + a.getStudent().getName() + 
                               " | Status: " + (a.getPresentStatus() ? "Present" : "Absent"));
        }
    }
}