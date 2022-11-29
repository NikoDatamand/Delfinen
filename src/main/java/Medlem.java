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
    
    private String tlfNummer;
    private String email;
    private String adresse;

    private String typeMedlemskab;
    private String alderMedlemskab;
    private String aktivitetsniveauMedlemskab;

    private int kontingentsats;
    private int restance;

    //Constructor
    public Medlem (String navn, int alder, char køn, int indmeldelsesÅr, int indmeldelsesMåned, int indmeldelsesDag, String tlfNummer, String email, String adresse, String typeMedlemskab, String aktivitetsniveauMedlemskab) {
        this.navn = navn;
        this.alder = alder;
        this.køn = køn;

        this.indmeldelsesÅr = indmeldelsesÅr;
        this.indmeldelsesMåned = indmeldelsesMåned;
        this.indmeldelsesDag = indmeldelsesDag;

        this.tlfNummer = tlfNummer;
        this.email = email;
        this.adresse = adresse;

        this.typeMedlemskab = typeMedlemskab;
        setAlderMedlemskab();
        this.aktivitetsniveauMedlemskab = aktivitetsniveauMedlemskab;
        calculateSats();
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

    public void setTlfNummer(String tlfNummer) {
        this.tlfNummer = tlfNummer;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTypeMedlemskab(String typeMedlemskab) {
        this.typeMedlemskab = typeMedlemskab;
    }

    private void setAlderMedlemskab() {
        if (alder < 18){
            alderMedlemskab = "juniorsvømmer";
        } else if(alder > 60){
            alderMedlemskab = "super seniorsvømmer";
        } else{
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

    public String getTlfNummer() {
        return tlfNummer;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
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
        
        if (indmeldelsesMåned < 10){
            return "0" + indmeldelsesMåned;
        }
        return String.valueOf(indmeldelsesMåned);
    }

    private String indmeldelsesdagFormattingHelper(){
        
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
    // Beregn kontingentsats
    public void calculateSats(){
        int kontingent = 0;
        if(typeMedlemskab.contains("aktivt")){
            if(alderMedlemskab.equals("juniorsvømmer")){
                kontingent = 1000;
            }else if(alderMedlemskab.equals("seniorsvømmer")){
                kontingent = 1600;
            }else{
                double kontingentDouble = 1600.00 * 0.75;
                kontingent = (int)kontingentDouble;
            }
        }else{
            kontingent = 500;
        }
        kontingentsats = kontingent;
    }
    
    //To String

    @Override
    public String toString() {
        return "Medlemmet: " + navn + ", " + alder + " år, " + kønFormattingHelper() + '\n' +
               "Indmeldt den: " + getIndmeldelsesDato() + '\n' +
                "Kontaktoplysninger: " + tlfNummer + ", " + email + ", " + adresse + '\n' +
                "Type medlemskab: " + typeMedlemskab + ", " + alderMedlemskab + ", " + aktivitetsniveauMedlemskab;
    }
}