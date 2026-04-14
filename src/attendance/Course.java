package attendance;

import java.util.ArrayList;
import java.util.Date;

public class Course {
    private String courseId;
    private String courseName;
    private int credit;
    private Instructor instructor;
    private ArrayList<Student> studentList;
    private ArrayList<Attendance> attendanceList;

    public Course(){}
    public Course(String courseId,String courseName,int credit){
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
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

    public void setIntructor(Instructor i){
        instructor = i;
    }

    public void markAttendance(Date d,Student s,boolean present){
        Attendance a = new Attendance(s,this,d,present);
        attendanceList.add(a);
    }

    public void getAttendancePercentage(){

    }

    public ArrayList<Attendance> getAttendanceList(){

    }

    public void getAttendanceReport(){

    }
}
