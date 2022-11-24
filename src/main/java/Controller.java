import java.util.ArrayList;

public class Controller {

    Database medlemsDatabase = new Database();


    //Constructor
    public Controller() {
    }


    public void addMedlemToDatabase(Medlem medlem){
        medlemsDatabase.addMedlemToDatabase(medlem);
    }

    /*public ArrayList<Medlem> addMedlemToDatabase(){
        return medlemsDatabase.getMedlemsDatabase();
    } */
}
