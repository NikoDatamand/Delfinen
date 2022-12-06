import java.lang.reflect.Array;
import java.util.ArrayList;

public class Database {

    private ArrayList<Medlem> medlemsDatabase = new ArrayList<>();

    //Create
    public void addMedlemToDatabase(Medlem medlem){
        medlem.setRestance(false);
        medlemsDatabase.add(medlem);
    }

    //Read
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
                System.out.println(" ");
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

        if(newMedlemInfo.getAlder() != 9999) {
            medlemToBeEdited.setAlder(newMedlemInfo.getFødselsdag());
        }
        
        String køn = String.valueOf(newMedlemInfo.getKøn());
        if(!køn.isEmpty()){
            char kønChar = køn.charAt(0);
            medlemToBeEdited.setKøn(kønChar);
        }

        if(newMedlemInfo.getIndmeldelsesÅr() != 9999){
            medlemToBeEdited.setIndmeldelsesÅr(newMedlemInfo.getIndmeldelsesÅr());
        }

        if(newMedlemInfo.getIndmeldelsesMåned() != 9999){
            medlemToBeEdited.setIndmeldelsesMåned(newMedlemInfo.getIndmeldelsesMåned());
        }

        if(newMedlemInfo.getIndmeldelsesDag() != 9999){
            medlemToBeEdited.setIndmeldelsesDag(newMedlemInfo.getIndmeldelsesDag());
        }

        if(!newMedlemInfo.getTlfNummer().isEmpty()){
            medlemToBeEdited.setTlfNummer(newMedlemInfo.getTlfNummer());
        }

        if(!newMedlemInfo.getEmail().isEmpty()){
            medlemToBeEdited.setEmail(newMedlemInfo.getEmail());
        }

        if(!newMedlemInfo.getAdresse().isEmpty()){
            medlemToBeEdited.setAdresse(newMedlemInfo.getAdresse());
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

    //Kontingentberegning
    public int calculateKontingentAggregated (){
        int expectedIncome = 0;
        for (Medlem medlem : medlemsDatabase) {
            expectedIncome += medlem.getKontingentsats();
        }
        return expectedIncome;
    }

    //GET
    public ArrayList<Medlem> getMedlemsDatabase() {
        return medlemsDatabase;
    }
}