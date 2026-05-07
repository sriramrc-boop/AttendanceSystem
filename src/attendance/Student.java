package attendance;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends User{
    // private String name;
    // private String rollNo;
    private ArrayList<Course> courses;

    public Student(){}
    public Student(String rollNo,String name){
        super(rollNo,name);
        courses = new ArrayList<>();
    }

    public String getRollNo(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void enrollCourse(String courseName,String courseId,int credit){
        Course found = null;
        ArrayList<Course> cs = FileManager.getCourseList();
        if(cs == null){
            cs = new ArrayList<>();
        }
        else{
            for(Course c:cs){
                if(c.getCourseId().equals(courseId)){
                    found = c;
                    break;
                }
            }
        }
        
        if(found == null){
            Course course = new Course(courseId,courseName,credit);
            cs.add(course);
            courses.add(course);
            course.enrollStudent(this);
            FileManager.saveAttendance(cs);
        }
        else{
            courses.add(found);
            found.enrollStudent(this);
            FileManager.saveAttendance(cs);
        }
    }

    public void viewAttendance(String courseId){
        Course c = FileManager.retrieveData(courseId);
        if(c != null){
            c.getAttendencePercentage(id);
        }
        else{
            System.out.println("Course not found");
        }
    }
}
