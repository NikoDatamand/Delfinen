import java.lang.reflect.Array;
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

    public ArrayList<Medlem> searchMedlem (String søgMedlemNavn) {
        ArrayList<Medlem> foundMedlemmer = new ArrayList<>();
        boolean fundet = false;
        int index = 1;
        for (Medlem medlem : medlemsDatabase) {
            if (medlem.getNavn().toLowerCase().contains(søgMedlemNavn.toLowerCase())) {
                System.out.println(index + ".\n" + medlem + ".\n");
                foundMedlemmer.add(medlem);
                fundet = true;
                index++;
            }
        } if (!fundet) {
            System.out.println("Et medlem med det navn kunne ikke findes i databasen.");
        }
        return foundMedlemmer;
    }

    //Edit
    public void editMedlem (Medlem medlemToBeEdited, Medlem newMedlemInfo) {
      medlemToBeEdited.setNavn(newMedlemInfo.getNavn());
      medlemToBeEdited.setAlder(newMedlemInfo.getAlder());
      medlemToBeEdited.setKøn(newMedlemInfo.getKøn());
      medlemToBeEdited.setIndmeldelsesÅr(newMedlemInfo.getIndmeldelsesÅr());
      medlemToBeEdited.setIndmeldelsesMåned(newMedlemInfo.getIndmeldelsesMåned());
      medlemToBeEdited.setIndmeldelsesDag(newMedlemInfo.getIndmeldelsesDag());
      medlemToBeEdited.setTypeMedlemskab(newMedlemInfo.getTypeMedlemskab());
      medlemToBeEdited.setAktivitetsniveauMedlemskab(newMedlemInfo.getAktivitetsniveauMedlemskab());

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