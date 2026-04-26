package attendance;

import java.util.ArrayList;
import java.util.Date;

public class Course{

    private String courseId;
    private String courseName;
    private int credit;
    private Instructor instructor;
    private ArrayList<Attendence> attendenceList = new ArrayList<>();
    private ArrayList<Student> studentList = new ArrayList<>();

    public course(){}

    public course(String courseId, String courseName, int credit){

    this.courseId = courseId;
    this.courseName = courseName;
    this.credit = credit;
        
    }

public String getCourseId(){

return CourseId;
        
    }

public String getCourseName(){

        return courseName;
    }
public void enrollStudent(Student s){

    studentList.add(s);
    
}
public void markAttendence(Date d,Student s,boolean present){

Attendence a = new Attendence(s,this,d,present);
    attendenceList.add(a);
    
}

 public void setInstructor(Instructor i){

this.instructor = i;
     
 } 
    public void getAttendancePercentage(Student s) {

    int totalClasses = 0;
    int classesPresent = 0;

    for (Attendance a : attendanceList) {

        if (a.getStudent().equals(s)) {
            totalClasses++;

            if (a.getPresentStatus()) {
                classesPresent++;
            }
        }
    }

    if (totalClasses > 0) {
        double percentage = ((double) classesPresent / totalClasses) * 100;

        System.out.println("Attendance for "
                + s.getName() + " : "
                + percentage + "%");
    } else {
        System.out.println("No attendance records found.");
    }
}
    public ArrayList<Attendance> getAttendanceList() {
    return attendanceList;
}

  public void getAttendencePercentage(Student s){

int totalClasses=0;
int classepresent=0;

for(Attendence r:attendenceList){

if(r.getStudent().equals(s)){

totalClasses++;

    if (r.getPresentStatus()){
        classesPresent++;       
    }
    
}
    
}  
      if (totalClasses > 0) {
            double percentage = ((double) classesPresent / totalClasses) * 100;
            System.out.println("Attendance for " + s.getName() + ": " + percentage + "%");
        } else {
            System.out.println("No records found.");
      }  
  }  

    public ArrayList<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void getAttendanceReport() {
        for (Attendance a : attendanceList) {
            System.out.println("Student: " + a.getStudent().getName() + 
                               " | Status: " + (a.getPresentStatus() ? "Present" : "Absent"));
        }
    
 
}


}

