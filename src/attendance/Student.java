package attendance;

import java.util.ArrayList;

public class Student extends User{
    // private String name;
    // private String rollNo;
    // private ArrayList<Course> courses;

    public Student(){}
    public Student(String rollNo,String name){
        super(rollNo,name);
        // courses = new ArrayList<>();
    }

    public String getRollNo(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void enrollCourse(String courseId){
        Course found = null;
        ArrayList<Course> cs = FileManager.getCourseList();
        if(cs == null){
            System.out.println("Course not found");
        }
        else{
            for(Course c:cs){
                if(c.getCourseId().equals(courseId)){
                    found = c;
                    break;
                }
            }
            if(found == null){
                System.out.println("Course not found");
            }
            else{
                // courses.add(found);
                found.enrollStudent(this);
                FileManager.saveAttendance(cs);
                System.out.println("Student Enrolled!");
        }
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
