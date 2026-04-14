package attendance;

import java.util.ArrayList;
import java.util.Date;

public class Instructor {
    private String instructorId;
    private String instructorName;
    private ArrayList<Course> courses;

    public Instructor(){}
    public Instructor(String instructorId,String instructorName){
        this.instructorId = instructorId;
        this.instructorName = instructorName;
    }

    public String getInstructorId(){
        return instructorId;
    }

    public void addCourse(Course c){
        courses.add(c);
        c.setIntructor(this);
    }

    public void markAttendance(Course c,Date d,boolean present){

    }

    public void viewAttendanceReport(Course c){
        c.getAttendanceReport();
    }
}
