package attendance;

// import java.io.BufferedInputStream;
// import java.io.BufferedOutputStream;
// import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {
    public static void saveAttendance(ArrayList<Course> courses){
        try{
            FileOutputStream file = new FileOutputStream("attendance.dat");
            ObjectOutputStream objectop = new ObjectOutputStream(file);
            
            objectop.writeObject(courses);

            objectop.close();
            file.close();
        }
        catch(IOException e){
            System.out.println("Error occured: "+e.getMessage());
        }
    }

    public static ArrayList<Course> getCourseList(){
        try{
            FileInputStream file = new FileInputStream("attendance.dat");
            ObjectInputStream objectinp = new ObjectInputStream(file);

            ArrayList<Course> courses = (ArrayList<Course>) objectinp.readObject();

            objectinp.close();
            file.close();

            return courses;
        }
        catch(IOException | ClassNotFoundException e){
            return null;
        }
    }

    public static Course retrieveData(String courseId){
        ArrayList<Course> courses = getCourseList();
        for(Course c:courses){
            if(courseId.equals(c.getCourseId())){
                return c;
            }
        }
        System.out.println("Error file not found");
        return null;
    }

    

    // public void getReport() {
    //     try {
    //         FileInputStream file = new FileInputStream("attendance.dat");
    //         BufferedInputStream buffinp = new BufferedInputStream(file);
    //         ObjectInputStream objectinp = new ObjectInputStream(buffinp);

    //         while (true) {
    //             try {
    //                 Attendance a = (Attendance) objectinp.readObject();
    //                 System.out.println(a);
    //             } catch (EOFException e) {
    //                 break; 
    //             }
    //         }
    //         objectinp.close();
    //     } catch (IOException | ClassNotFoundException e) {
    //         System.out.println("Error while fetching report: " + e.getMessage());
    //     }
    // }
}
