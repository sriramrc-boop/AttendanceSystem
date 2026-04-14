package attendance;

import java.util.ArrayList;

public class Student {
    private String name;
    private String rollNo;
    private ArrayList<Course> courses;

    public Student(){}
    public Student(String name,String rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getRollNo(){
        return rollNo;
    }

    public String getName(){
        return name;
    }

    public void addCourse(Course c){
        courses.add(c);
    }

    public void viewAttendance(){
        System.out.println("Attendance:");
    }
}
