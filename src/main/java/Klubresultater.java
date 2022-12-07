import java.util.ArrayList;

public class Klubresultater {
    private ArrayList<Resultat> klubresultater = new ArrayList<>();

    public Klubresultater(){
    }

    public void createResultat(Medlem medlem, String disciplin, String tid){
        Resultat klubresultat = new Resultat(medlem, disciplin, tid);
        klubresultater.add(klubresultat);
    }

    public void showKlubresultaterFromDisciplin(String disciplin){
        int index = 1;
        for (Resultat resultat : klubresultater) {
            if (resultat.getDisciplin().equalsIgnoreCase(disciplin)) {
                System.out.println(index + ".\n" + "Medlemmet: " + resultat.getMedlem().getNavn() + ".\n" + "Fra: " + holdHelperMethod(resultat.getMedlem()) + ".\n" + "Disciplin: " + resultat.getDisciplin() + ".\n" + "Tid: " + resultat.getTid());
                System.out.println(" ");
                index++;
            }
        }
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
