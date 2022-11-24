import java.util.ArrayList;
import java.io.*;

public class Controller {

    Database medlemsDatabase = new Database();
    FileHandler fileHandler = new FileHandler(medlemsDatabase.getMedlemsDatabase());

    //Constructor
    public Controller() {
    }


    public void addMedlemToDatabase(Medlem medlem){
        try{
           fileHandler.attemptCreateFile();
        }
        catch (IOException e){
            System.out.println("Error");
        }
        
        medlemsDatabase.addMedlemToDatabase(medlem);
    }

    /*public ArrayList<Medlem> addMedlemToDatabase(){
        return medlemsDatabase.getMedlemsDatabase();
    } */
}
