package attendance;

import java.util.ArrayList;
import java.util.Date;

public class Instructor extends User{

    public Instructor(){super();}
    public Instructor(String instructorId,String instructorName){
        super(instructorId,instructorName);
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
                FileManager.saveAttendance(courseList);
                System.out.println("Course added");
            }
            else{
                FileManager.saveAttendance(courseList);
                System.out.println("Course already exits");
            }
        }

    public void markAttendance(String studentId,Date d,boolean present,String courseId){
        Course found = null;
        ArrayList<Course> cs = FileManager.getCourseList();

        if (cs == null) {
            System.out.println("No courses found in database.");
            return;
        }
        
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
    }
}
