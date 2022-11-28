import java.util.ArrayList;
import java.io.*;

public class Controller {

    Database medlemsDatabase = new Database();
    FileHandler fileHandler = new FileHandler();

    //Constructor
    public Controller() {
        try {
            fileHandler.attemptCreateFile();
            fileHandler.readFromFile(medlemsDatabase.getMedlemsDatabase());
        } catch (Exception e){
            System.out.println("Error");
        }
    }

    public void addMedlemToDatabase(Medlem medlem){
        try{
            medlemsDatabase.addMedlemToDatabase(medlem);
            fileHandler.writeToFile(medlemsDatabase.getMedlemsDatabase());
        } catch (Exception e){
            System.out.println("Error");
        }
    }

    public void showMedlemmer() {
        medlemsDatabase.showMedlemmer();
    }

    public ArrayList<Medlem> searchMedlemByName(String medlemName){
        ArrayList<Medlem> foundMedlemmer = new ArrayList<>();
        foundMedlemmer = medlemsDatabase.searchMedlem(medlemName);
        return foundMedlemmer;
    }

    public void editMedlem (Medlem medlemToBeEdited, Medlem newMedlemInfo) {
        medlemsDatabase.editMedlem(medlemToBeEdited, newMedlemInfo);
    }

}
