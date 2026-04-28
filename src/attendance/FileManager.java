package attendance;

import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileManager {

    public void saveAttendance(Course c){

    }

    public ArrayList<Attendance> retrieveData(String courseId){
        ArrayList<Attendance> readAttendances = new ArrayList<>();
        try{
            FileInputStream file = new FileInputStream("attendance.dat");
            BufferedInputStream buffinp = new BufferedInputStream(file);
            ObjectInputStream objectinp = new ObjectInputStream(buffinp);

            while(true){
                try{
                    Attendance a = (Attendance) objectinp.readObject();
                    readAttendances.add(a);
                }
                catch(EOFException e){
                    break;
                }
            }

            objectinp.close();
            buffinp.close();
            file.close();
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("Error file not found");
        }
        return readAttendances;
    }

    public void getReport(){

    }

}
