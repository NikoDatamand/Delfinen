import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Medlem implements Serializable {

    private String navn;
    private int alder;
    private char køn;

    private int indmeldelsesÅr;
    private int indmeldelsesMåned;
    private int indmeldelsesDag;

    private String typeMedlemskab;
    private String alderMedlemskab;
    private String aktivitetsniveauMedlemskab;

    //Constructor
    public Medlem (String navn, int alder, char køn, int indmeldelsesÅr, int indmeldelsesMåned, int indmeldelsesDag, String typeMedlemskab, String aktivitetsniveauMedlemskab) {
        this.navn = navn;
        this.alder = alder;
        this.køn = køn;

        this.indmeldelsesÅr = indmeldelsesÅr;
        this.indmeldelsesMåned = indmeldelsesMåned;
        this.indmeldelsesDag = indmeldelsesDag;

        this.typeMedlemskab = typeMedlemskab;
        setAlderMedlemskab();
        this.aktivitetsniveauMedlemskab = aktivitetsniveauMedlemskab;
    }

    //Setters

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public void setKøn(char køn) {
        this.køn = køn;
    }

    public void setIndmeldelsesÅr(int indmeldelsesÅr) {
        this.indmeldelsesÅr = indmeldelsesÅr;
    }

    public void setIndmeldelsesMåned(int indmeldelsesMåned) {
        this.indmeldelsesMåned = indmeldelsesMåned;
    }

    public void setIndmeldelsesDag(int indmeldelsesDag) {
        this.indmeldelsesDag = indmeldelsesDag;
    }

    public void setTypeMedlemskab(String typeMedlemskab) {
        this.typeMedlemskab = typeMedlemskab;
    }

    private void setAlderMedlemskab() {
        if (alder < 18){
            alderMedlemskab = "juniorsvømmer";
        } else {
            alderMedlemskab = "seniorsvømmer";
        }
    }

    public void setAktivitetsniveauMedlemskab(String aktivitetsniveauMedlemskab) {
        this.aktivitetsniveauMedlemskab = aktivitetsniveauMedlemskab;
    }

    //Getters

    public String getNavn() {
        return navn;
    }

    public int getAlder() {
        return alder;
    }

    public char getKøn() {
        return køn;
    }

    public int getIndmeldelsesÅr() {
        return indmeldelsesÅr;
    }

    public int getIndmeldelsesMåned() {
        return indmeldelsesMåned;
    }

    public int getIndmeldelsesDag() {
        return indmeldelsesDag;
    }

    public String getIndmeldelsesDato() {
        LocalDateTime myDateObj = LocalDateTime.parse(indmeldelsesÅr + "-" + indmeldelsesmånedFormattingHelper() + "-" + indmeldelsesdagFormattingHelper() + "T00:00:00");
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return myDateObj.format(myFormatObj);
    }

    public String getTypeMedlemskab() {
        return typeMedlemskab;
    }

    public String getAlderMedlemskab() {
        return alderMedlemskab;
    }

    public String getAktivitetsniveauMedlemskab() {
        return aktivitetsniveauMedlemskab;
    }

    //Helper methods
    private String indmeldelsesmånedFormattingHelper(){
        String returnvalue;
        if (indmeldelsesMåned < 10){
            return "0" + indmeldelsesMåned;
        }
        return String.valueOf(indmeldelsesMåned);
    }

    private String indmeldelsesdagFormattingHelper(){
        String returnvalue;
        if (indmeldelsesDag < 10){
            return "0" + indmeldelsesDag;
        }
        return String.valueOf(indmeldelsesDag);
    }

    private String kønFormattingHelper(){
        String formattedKøn;
        if (køn == 'm'){
            formattedKøn = "mand";
        } else if (køn == 'f'){
            formattedKøn = "kvinde";
        } else {
            formattedKøn = "andet";
        }
        return formattedKøn;
    }

    //To String

    @Override
    public String toString() {
        return "Medlemmet: " + navn + ", " + alder + " år, " + kønFormattingHelper() + '\n' +
               "Indmeldt den: " + getIndmeldelsesDato() + '\n' +
                "Type medlemskab: " + typeMedlemskab + ", " + alderMedlemskab + ", " + aktivitetsniveauMedlemskab;
    }
}
