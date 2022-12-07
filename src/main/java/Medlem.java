import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.time.*;

public class Medlem implements Serializable {

    private String navn;
    
    private LocalDate fødselsdag;
    private int alder;
    private char køn;

    private LocalDate indmeldelsesDato;
    private String tlfNummer;
    private String email;
    private String adresse;

    private String typeMedlemskab;
    private String alderMedlemskab;
    private String aktivitetsniveauMedlemskab;

    private int kontingentsats;
    private boolean restance;

    //Constructor
    public Medlem (String navn, LocalDate fødselsdag, char køn, LocalDate indmeldelsesDato, String tlfNummer, String email, String adresse, String typeMedlemskab, String aktivitetsniveauMedlemskab) {
        this.navn = navn;
        this.fødselsdag = fødselsdag;
        LocalDate currentDate = LocalDate.now();
        if(fødselsdag != null){
            alder = Period.between(fødselsdag, currentDate).getYears();
        }
        this.køn = køn;
        
        this.indmeldelsesDato = indmeldelsesDato;
        
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

    public void setFødselsdag(LocalDate fødselsdag){
        this.fødselsdag = fødselsdag;
    }
    
    public void setAlder(LocalDate fødselsdag) {
        LocalDate currentDate = LocalDate.now();
        if(fødselsdag != null){
            this.alder = Period.between(fødselsdag, currentDate).getYears();
        }
    }

    public void setKøn(char køn) {
        this.køn = køn;
    }

    public void setIndmeldelsesDato(LocalDate indmeldelsesDato) {
        this.indmeldelsesDato = indmeldelsesDato;
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

    public void setRestance(boolean restanceStatus) {
        this.restance = restanceStatus;
    }

    //Getters

    public String getNavn() {
        return navn;
    }

    public LocalDate getFødselsdag(){
        return fødselsdag;
    }
    
    public int getAlder() {
        return alder;
    }

    public char getKøn() {
        return køn;
    }

    public LocalDate getIndmeldelsesDato(){
        return indmeldelsesDato;
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

    public int getKontingentsats() {
        return kontingentsats;
    }

    public boolean getRestance(){
        return restance;
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

    //Helper methods
    public String showFødselsdag(){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fødselsdag.format(myFormatObj);
    }
    
    public String showIndmeldelsesDato() { 
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return indmeldelsesDato.format(myFormatObj);
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

    private String restanceFormattingHelper(){
        String returnvalue;
        if (restance) {
            returnvalue = "ja";
        } else {
            returnvalue = "nej";
        }
        return returnvalue;
    }

    //To String

    @Override
    public String toString() {
        return "Medlemmet: " + navn + ", " + alder + " år, " + "fødselsdag: " + showFødselsdag() + ", " + kønFormattingHelper() + '\n' +
               "Indmeldt den: " + showIndmeldelsesDato() + '\n' +
                "Kontaktoplysninger: " + tlfNummer + ", " + email + ", " + adresse + '\n' +
                "Type medlemskab: " + typeMedlemskab + ", " + alderMedlemskab + ", " + aktivitetsniveauMedlemskab + '\n' +
                "Kontingentsats: " + getKontingentsats() + '\n' +
                "Restance: " + restanceFormattingHelper();
    }
}