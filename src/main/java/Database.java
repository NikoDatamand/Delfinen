import java.util.ArrayList;

public class Database {

    private ArrayList<Medlem> medlemsDatabase = new ArrayList<>();

    //GET
    public ArrayList<Medlem> getMedlemsDatabase() {
        return medlemsDatabase;
    }

    public void addMedlemToDatabase(Medlem medlem){
        medlemsDatabase.add(medlem);
    }
}