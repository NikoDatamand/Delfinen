import java.time.LocalTime;

public class Stævne {
    String stævneNavn;
    String stævnePlacering;
    int placering;
    double tid;

    public Stævne (String stævneNavn, String stævnePlacering, int placering, double tid) {
        this.stævneNavn = stævneNavn;
        this.stævnePlacering = stævnePlacering;
        this.placering = placering;
        this.tid = tid;
    }
}