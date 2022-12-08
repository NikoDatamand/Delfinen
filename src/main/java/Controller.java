import java.util.ArrayList;
import java.io.*;

public class Controller {

    Database medlemsDatabase = new Database();
    Ungdomshold ungdomshold = new Ungdomshold();
    Seniorhold seniorhold = new Seniorhold();
    Klubresultater klubresultater = new Klubresultater();
    StævneDatabase stævneDatabase = new StævneDatabase();
    FileHandler fileHandler = new FileHandler();

    //Constructor
    public Controller() {
        try {
            fileHandler.attemptCreateFile();
            fileHandler.readFromMedlemmer(medlemsDatabase.getMedlemsDatabase());
            fileHandler.readFromKlubresultater(klubresultater.getKlubresultater());
            fileHandler.readFromStævneDatabase(stævneDatabase.getStævneDatabase());
            syncronizeHold(medlemsDatabase.getMedlemsDatabase());
        } catch (Exception e){
        }
    }

    public void addMedlemToDatabase(Medlem medlem){
       medlemsDatabase.addMedlemToDatabase(medlem);
       addMedlemToHold(medlem);
       saveMedlemmer();
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
        saveMedlemmer();
    }

    public void deleteMedlem (String medlemToBeDelted) {
        medlemsDatabase.deleteMedlem(medlemToBeDelted);
        saveMedlemmer();
    }

    public int showExpectedIncomeAggregated(){
        return medlemsDatabase.calculateKontingentAggregated();
    }

    public void syncronizeHold(ArrayList<Medlem> medlemsDatabase){
        for (Medlem medlem : medlemsDatabase) {
            if (medlem.getAktivitetsniveauMedlemskab().equalsIgnoreCase("konkurrencesvømmer")) {
                if (medlem.getAlder() < 18) {
                    ungdomshold.addMedlemToHold(medlem);
                } else {
                    seniorhold.addMedlemToHold(medlem);
                }
            }
        }
    }
    public void addMedlemToHold(Medlem medlem){
        if (medlem.getAktivitetsniveauMedlemskab().equalsIgnoreCase("konkurrencesvømmer")) {
            if (medlem.getAlder() < 18) {
                ungdomshold.addMedlemToHold(medlem);
            } else {
                seniorhold.addMedlemToHold(medlem);
            }
        }
    }
    public void showHoldMedlemmer(int choice){
        if (choice == 1) {
            ungdomshold.showHold();
        } else if (choice == 2){
            seniorhold.showHold();
        }
    }

    public void createKlubResultat(Medlem medlem, String disciplin, String tid){
        klubresultater.createResultat(medlem, disciplin, tid);
        saveKlubresultater();
    }

    public void showKlubresultaterFromDisciplin(String disciplin) {
        klubresultater.showKlubresultaterFromDisciplin(disciplin);
    }

    public void createStævne(String stævneNavn, String stævnePlacering){
        stævneDatabase.createStævne(stævneNavn, stævnePlacering);
        saveStævneDatabase();
    }

    public void createStævneResultat(Stævne stævne, Medlem medlem, String disciplin, String tid){
        stævneDatabase.createStævneResultat(stævne, medlem, disciplin, tid);
        saveStævneDatabase();
    }

    public void showAllStævner(){
        stævneDatabase.showAllStævner();
    }

    public Stævne searchForStævne(String stævneNavn){
        return stævneDatabase.searchForStævne(stævneNavn);
    }

    public void showStævneResults(String stævneNavn) {
        stævneDatabase.showStævneResults(stævneNavn);
    }

    // save metoder
    
    public void saveMedlemmer(){
        try {
            fileHandler.writeToMedlemmer(medlemsDatabase.getMedlemsDatabase());
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void saveKlubresultater(){
        try {
            fileHandler.writeToKlubresultater(klubresultater.getKlubresultater());
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void saveStævneDatabase(){
        try {
            fileHandler.writeToStævneDatabase(stævneDatabase.getStævneDatabase());
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
