package attendance;

import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class FileManager {
    public void saveAttendance(Course c){
        try{
            FileOutputStream file = new FileOutputStream("attendance.dat");
            BufferedOutputStream buffop = new BufferedOutputStream(file);
            ObjectOutputStream objectop = new ObjectOutputStream(buffop);
            for(Attendance a: c.getAttendanceList()){
                objectop.writeObject(a);
            }
            objectop.close();
            System.out.println("Attendance updated");
        }
        catch(IOException e){
            System.out.println("Error occured: "+e.getMessage());
        }
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

    public void getReport() {
        try {
            FileInputStream file = new FileInputStream("attendance.dat");
            BufferedInputStream buffinp = new BufferedInputStream(file);
            ObjectInputStream objectinp = new ObjectInputStream(buffinp);

            while (true) {
                try {
                    Attendance a = (Attendance) objectinp.readObject();
                    System.out.println(a);
                } catch (EOFException e) {
                    break; 
                }
            }
            objectinp.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while fetching report: " + e.getMessage());
        }
    }
}
