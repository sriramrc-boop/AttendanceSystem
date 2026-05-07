package attendanceManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import attendance.*;

public class Main {
    public static void main(String[] args){
        try{
            FileInputStream file = new FileInputStream("attendance.dat");
            ObjectInputStream obj = new ObjectInputStream(file);

            ArrayList<Course> courses = (ArrayList<Course>) obj.readObject();

            for(Course c:courses){
                c.getCourseId();
            }
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("Error:"+e.getMessage());
        }
    }    
}
