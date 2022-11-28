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

    public void searchMedlem (String søgMedlemNavn) {
        boolean fundet = false;
        int index = 1;
        for (Medlem medlem : medlemsDatabase) {
            if (medlem.getNavn().toLowerCase().contains(søgMedlemNavn.toLowerCase())) {
                System.out.println(index + ".\n" + medlem);
                fundet = true;
                index++;
            }
        } if (!fundet) {
            System.out.println("Et medlem med det navn kunne ikke findes i databasen.");
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