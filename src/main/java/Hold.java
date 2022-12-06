import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

abstract class Hold {

    protected ArrayList<Medlem> holdMedlemmer = new ArrayList<>();

    public void addMedlemToHold(Medlem medlem){
        holdMedlemmer.add(medlem);
    }

    public void showHold () {
        int index = 1;
        for (Medlem medlem : holdMedlemmer) {
            System.out.println(index + ".\n" + medlem);
            System.out.println(" ");
            index++;
        }
    }

    public ArrayList<Medlem> searchHoldMedlem (String søgMedlemNavn) {
        ArrayList<Medlem> foundMedlemmer = new ArrayList<>();
        boolean fundet = false;
        int index = 1;
        for (Medlem medlem : holdMedlemmer) {
            if (medlem.getNavn().toLowerCase().contains(søgMedlemNavn.toLowerCase())) {
                System.out.println(" ");
                System.out.println(index + ".\n" + medlem + ".\n");
                foundMedlemmer.add(medlem);
                fundet = true;
                index++;
            }
        } if (!fundet) {
            System.out.println("Et medlem med det navn kunne ikke findes på dette hold.");
        }
        return foundMedlemmer;
    }

    public void deleteMedlemFromHold (String medlemToBeDelted) {
        for (int i = 0; i < holdMedlemmer.size(); i++) {
            if (holdMedlemmer.get(i).getNavn().contains(medlemToBeDelted)) {
                holdMedlemmer.remove(holdMedlemmer.get(i));
            }
        }
    }

    public ArrayList<Medlem> getHoldMedlemmer() {
        return holdMedlemmer;
    }
}
