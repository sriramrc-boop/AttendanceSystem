package attendance;

import java.util.ArrayList;

public class Student extends User{
     private ArrayList<Course> courses;

    public Student(){}
    public Student(String rollNo,String name){
        super(rollNo,name);
        courses = new ArrayList<>();
    }

    public void enrollCourse(String courseId){
        Course found = null;
        ArrayList<Course> cs = FileManager.getCourseList();

        for(Course c:courses){
            if(c.getCourseId().equals(courseId)){
                System.out.println("Student already enrolled");
                return;
            }
        }

        if(cs == null){
            System.out.println("Course not found.");
        }
        else{
            for(Course c:cs){
                if(c.getCourseId().equals(courseId)){
                    found = c;
                    break;
                }
            }
            if(found == null){
                System.out.println("Course not found.");
            }

            else{
                found.enrollStudent(this);  
                this.courses.add(found);
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
    }
}
