package attendance;

import java.util.ArrayList;
import java.util.Date;

public class Instructor extends User{
    // private String instructorId;
    // private String instructorName;
    // private ArrayList<Course> courses;

    public Instructor(){super();}
    public Instructor(String instructorId,String instructorName){
        super(instructorId,instructorName);
        // courses = new ArrayList<>();
    }

    public String getInstructorId(){
        return id;
    }

    public String getInstructorName(){
        return name;
    }

    public void addCourse(String courseName,String courseId,int credit){
            Course found = null;
            ArrayList<Course> courseList = FileManager.getCourseList();
            if(courseList == null){
                courseList = new ArrayList<>();
                System.out.println("New file created");
            }
            else{
                for(Course c:courseList){
                    if(c.getCourseId().equals(courseId)){
                        found = c;
                        break;
                    }
                }
            }

            if(found == null){
                Course course = new Course(courseId,courseName,credit);
                courseList.add(course);
                // courses.add(course);
                // course.setInstructor(this);
                FileManager.saveAttendance(courseList);
            }
            else{
                // courses.add(found);
                // found.setInstructor(this);
                FileManager.saveAttendance(courseList);
                System.out.println("Course already exits");
            }
        }

    public void markAttendance(String studentId,Date d,boolean present,String courseId){
        Course found = null;
        ArrayList<Course> cs = FileManager.getCourseList();
        for(Course c:cs){
            if(c.getCourseId().equals(courseId)){
                found = c;
                break;
            }
        }
        if(found != null){
            found.markAttendance(studentId,d,present);
            FileManager.saveAttendance(cs);
        }
        else{
            System.out.println("Course not found.");
        }
    }

    public void viewAttendanceReport(String courseId){
        Course c = FileManager.retrieveData(courseId);
        if(c != null){
            c.getAttendanceReport();
        }
        else{
            System.out.println("Course not found");
        }
    }
}
