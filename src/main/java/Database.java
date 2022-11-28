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

    //Update
   
      public void editMedlem (Medlem medlemToBeEdited, Medlem newMedlemInfo) {
        String name = newMedlemInfo.getNavn();
        if(!name.isEmpty()){
            medlemToBeEdited.setNavn(name);
        }
        
        String alder = String.valueOf(newMedlemInfo.getAlder());
        if(!alder.isEmpty()){
            Integer alderInt = Integer.parseInt(alder);
            medlemToBeEdited.setAlder(alderInt);
        }
        
        String køn = String.valueOf(newMedlemInfo.getKøn());
        if(!køn.isEmpty()){
            char kønChar = køn.charAt(0);
            medlemToBeEdited.setKøn(kønChar);
        }

        String indmeldelsesÅr = String.valueOf(newMedlemInfo.getIndmeldelsesÅr());
        if(!indmeldelsesÅr.isEmpty()){
            Integer indmeldelseÅrInt = Integer.parseInt(indmeldelsesÅr);
            medlemToBeEdited.setIndmeldelsesÅr(indmeldelseÅrInt);
        }

        String indmeldelsesMåned = String.valueOf(newMedlemInfo.getIndmeldelsesMåned());
        if(!indmeldelsesMåned.isEmpty()){
            Integer indmeldelseMånedInt = Integer.parseInt(indmeldelsesMåned);
            medlemToBeEdited.setIndmeldelsesMåned(indmeldelseMånedInt);
        }

        String indmeldelsesDag = String.valueOf(newMedlemInfo.getIndmeldelsesDag());
        if(!indmeldelsesDag.isEmpty()){
            Integer indmeldelsesDagInt = Integer.parseInt(indmeldelsesDag);
            medlemToBeEdited.setIndmeldelsesDag(indmeldelsesDagInt);
        }
        
        if(!newMedlemInfo.getTypeMedlemskab().isEmpty()){
            medlemToBeEdited.setTypeMedlemskab(newMedlemInfo.getTypeMedlemskab());
        }
        
        if(!newMedlemInfo.getAktivitetsniveauMedlemskab().isEmpty()){
            medlemToBeEdited.setAktivitetsniveauMedlemskab(newMedlemInfo.getAktivitetsniveauMedlemskab());
        }

    }
    

    //Delete
    public void deleteMedlem (String medlemToBeDelted) {
        for (int i = 0; i < medlemsDatabase.size(); i++) {
            if (medlemsDatabase.get(i).getNavn().contains(medlemToBeDelted)) {
                medlemsDatabase.remove(medlemsDatabase.get(i));
            }
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