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

    // public void addCourse(String courseName,String courseId,int credit){
    //     for(Course c1:courses){
    //         if(c1.getCourseId().equals(courseId)){
    //             Course found = null;
    //             ArrayList<Course> cs = FileManager.getCourseList();
    //             if(cs == null){
    //                 cs = new ArrayList<>();
    //                 System.out.println("New file created");
    //             }
    //             else{
    //                 for(Course c:cs){
    //                     if(c.getCourseId().equals(courseId)){
    //                         found = c;
    //                         break;
    //                     }
    //                 }
    //             }

    //             if(found == null){
    //                 Course course = new Course(courseId,courseName,credit);
    //                 cs.add(course);
    //                 courses.add(course);
    //                 course.setInstructor(this);
    //                 FileManager.saveAttendance(cs);
    //             }
    //             else{
    //                 courses.add(found);
    //                 found.setInstructor(this);
    //                 FileManager.saveAttendance(cs);
    //             }
    //         }
    //         else{
    //             System.out.println("Course already exists in course list");
    //         }
    //     }
    // }

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
            System.out.println("Attendance updated");
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
