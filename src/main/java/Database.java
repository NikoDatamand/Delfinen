import java.util.ArrayList;

public class Database {

    private ArrayList<Medlem> medlemsDatabase = new ArrayList<>();

    //Search method
    public void showMedlemmer () {
        int index = 1;
        for (Medlem medlem : medlemsDatabase) {
            System.out.println(index + ".\n" + medlem);
            System.out.println(" ");
            index++;
        }
    }

    //GET
    public ArrayList<Medlem> getMedlemsDatabase() {
        return medlemsDatabase;
    }
    //ADD
    public void addMedlemToDatabase(Medlem medlem){
        medlemsDatabase.add(medlem);
    }
}