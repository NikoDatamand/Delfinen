import java.util.ArrayList;
import java.io.*;

public class Controller {

    Database medlemsDatabase = new Database();
    FileHandler fileHandler = new FileHandler();

    //Constructor
    public Controller() {
        try {
            fileHandler.readFromFile(medlemsDatabase.getMedlemsDatabase());
        } catch (Exception e){
            System.out.println("Error");
        }
    }

    public void addMedlemToDatabase(Medlem medlem){
        try{
            fileHandler.attemptCreateFile();
            medlemsDatabase.addMedlemToDatabase(medlem);
            fileHandler.writeToFile(medlemsDatabase.getMedlemsDatabase());
        } catch (Exception e){
            System.out.println("Error");
        }
    }

    public void showMedlemmer() {
        medlemsDatabase.showMedlemmer();
    }

}
