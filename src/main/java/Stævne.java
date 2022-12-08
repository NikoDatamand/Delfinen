import java.util.ArrayList;
import java.io.Serializable;

public class Stævne implements Serializable{

    private String navn;
    private String placering;
    private ArrayList<Resultat> stævneResultater = new ArrayList<>();

    public Stævne (String navn, String placering) {
        this.navn = navn;
        this.placering = placering;
    }

    public void createResultat(Medlem medlem, String disciplin, String tid){
        Resultat stævneResultat = new Resultat(medlem, disciplin, tid);
        stævneResultater.add(stævneResultat);
    }

    public void showStævneResultater(){
        int index = 1;
        for (Resultat resultat : stævneResultater) {
             System.out.println(index + ".\n" + "Medlemmet: " + resultat.getMedlem().getNavn() + ".\n" +  "Fra: " + holdHelperMethod(resultat.getMedlem()) + ".\n" + "Disciplin: " + resultat.getDisciplin() + ".\n" + "Tid: " + resultat.getTid());
             System.out.println(" ");
             index++;
        }
    }

    public int showAmountOfHoldParticipants(){
        return stævneResultater.size();
    }

    public String getNavn() {
        return navn;
    }

    public String getPlacering() {
        return placering;
    }

    private String holdHelperMethod(Medlem medlem){
        String hold;
        if (medlem.getAlder() < 18) {
            hold = "ungdomsholdet";
        } else {
            hold = "seniorholdet";
        }
        return hold;
    }
}