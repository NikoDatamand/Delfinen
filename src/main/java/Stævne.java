import java.time.LocalTime;

public class Stævne {
    private String medlemsNavn;
    private String stævneNavn;
    private String stævnePlacering;
    private int placering;
    private double tid;
    private String disciplin;

    // Konstruktør
    public Stævne (String medlemsNavn, String stævneNavn, String stævnePlacering, int placering, double tid, String disciplin) {
        this.medlemsNavn = medlemsNavn;
        this.stævneNavn = stævneNavn;
        this.stævnePlacering = stævnePlacering;
        this.placering = placering;
        this.tid = tid;
        this.disciplin = disciplin;
    }
    // Setters
    public void setMedlemsNavn (String medlemsNavn) {
    }

    public void setStævneNavn(String stævneNavn) {
        this.stævneNavn = stævneNavn;
    }

    public void setStævnePlacering(String stævnePlacering) {
        this.stævnePlacering = stævnePlacering;
    }

    public void setPlacering(int placering) {
        this.placering = placering;
    }

    public void setTid(double tid) {
        this.tid = tid;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;

    }

    // Getters
    public String getMedlemsNavn() {
        return medlemsNavn;
    }

    public String getStævneNavn () {
        return stævneNavn;
    }

    public String getStævnePlacering() {
        return stævnePlacering;
    }

    public int getPlacering() {
        return placering;
    }

    public double getTid() {
        return tid;
    }

    public String getDisciplin() {
        return disciplin;
    }

}