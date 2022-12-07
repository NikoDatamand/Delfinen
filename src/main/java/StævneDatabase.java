import java.util.ArrayList;

public class StævneDatabase {

  private ArrayList<Stævne> stævner = new ArrayList<>();

  public StævneDatabase(){
  }

  public void createStævne(String stævneNavn, String stævnePlacering){
    Stævne stævne = new Stævne(stævneNavn, stævnePlacering);
    stævner.add(stævne);
  }

  public void createStævneResultat(Stævne stævne, Medlem medlem, String disciplin, String tid){
      stævne.createResultat(medlem, disciplin, tid);
  }

  public void showAllStævner(){
    int index = 1;
    for (Stævne stævne : stævner) {
       System.out.println(index + ".\n" + "Stævnet: " + stævne.getNavn()+ ".\n" + "Holdt i: " + stævne.getPlacering() + ".\n" + "Antal deltagende fra klubben: " + stævne.showAmountOfHoldParticipants());
       System.out.println(" ");
       index++;
    }
  }

  public void showStævneResults(String stævneNavn){
      for (Stævne stævne : stævner) {
          if (stævne.getNavn().equalsIgnoreCase(stævneNavn)) {
              System.out.println("Stævnet: " + stævne.getNavn()+ ".\n" + "Holdt i: " + stævne.getPlacering() + ".\n" + "Antal deltagende fra klubben: " + stævne.showAmountOfHoldParticipants());
              System.out.println(" ");
              stævne.showStævneResultater();
          }
      }
  }

  public Stævne searchForStævne(String stævneNavn){
      Stævne stævneToReturn = null;
      for (Stævne stævne : stævner) {
          if (stævne.getNavn().equalsIgnoreCase(stævneNavn)) {
              stævneToReturn = stævne;
          }
      }
      return stævneToReturn;
  }

}
