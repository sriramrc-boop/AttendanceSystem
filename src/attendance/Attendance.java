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
    public void toString(){
        System.out.printf("Name: %s | CourseID:%s | Course Name: %s | Date: %s | Present Status: %s%n%n",student.getName(),course.getCourseId(),course.getCourseName(),date,status);
    }
}
