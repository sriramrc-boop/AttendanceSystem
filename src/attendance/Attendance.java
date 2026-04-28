package attendance;

import java.util.Date;

public class Attendance {
    private Student student;
    private Course course;
    private Date todaysDate;
    private boolean status;

    public Attendance(){}
    public Attendance(Student student,Course course,Date todaysDate,boolean status){
        this.student = student;
        this.course = course;
        this.todaysDate = todaysDate;
        this.status = status;
    }

    public Student getStudent(){
        return student;
    }

    public boolean getPresentStatus(){
        return status;
    }

    @Override
    public String toString(){
        return "Name:"+ student.getName()+" | CourseID: "+course.getCourseId()+" | Course Name: "+ course.getCourseName()+" | Date: "+todaysDate+" | Present Status: "+status;
    }
}
