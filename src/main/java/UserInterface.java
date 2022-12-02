import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    Controller controller = new Controller();
    private int currentYear = LocalDateTime.now().getYear();

    public void loadUserInterface() {
        System.out.println("Velkommen til svømmeklubben 'Delfinen'");
        boolean isRunning = true;

        while (isRunning) {
            HvemErDu();
        }
    }

    private void HvemErDu() {
        System.out.println("""
                Hvilken funktion har du i svømmeklubben?
                1: Formand
                2: Kasserer
                3: Træner
                9: Afslut program            
                """);

        switch (sc.nextInt()) {
            case 1:
                Formand();
                break;
            case 2:
                Kasserer();
                break;
            case 3:
                Træner();
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("Der opstod en fejl. Vælg venligt relevant input");
                break;
        }
    }

    private void Formand() {
        System.out.println("""
                                           
                Hovedmenu:
                                
                1. Opret medlem
                2. Vis alle medlemmer
                3. Søg efter medlem
                4. Opdatér medlemsoplysninger
                5. Slet medlem
                9. Afslut
                """);

        switch (sc.nextInt()) {
            case 1:
                createMedlem();
                break;
            case 2:
                controller.showMedlemmer();
                break;
            case 3:
                System.out.println("Tast navnet på det medlem du vil søge efter: " + '\n');
                controller.searchMedlemByName(sc.next());
                break;
            case 4:
                editMedlem();
                break;
            case 5:
                deleteMedlem();
                break;
            case 9:
                System.exit(0);
                break;
        }
    }

    private void Kasserer() {
        System.out.println("""
                1. Se forventet kontingentindkomst
                2. Opdatér medlemmers restance status
                9: Afslut
                """);

        switch (sc.nextInt()) {
            case 1:
                System.out.println("Forventet indkomst for " + LocalDateTime.now().getYear() + " : " + controller.showExpectedIncomeAggregated() + " DKK");
                break;
            case 2:
                updateMedlemRestanceStatus();
                break;
            case 9:
                System.exit(0);
                break;
        }
    }

    private void Træner () {
        System.out.println("""
                1: Se træningstider
                9: Afslut program
                """);

        switch (sc.nextInt()) {
            case 1:
                System.out.println("Her skal man kunne se medlemmets træningstider");
                break;
            case 9:
                System.exit (0);
                break;
        }
    }

    private void createMedlem() {
        sc.nextLine();
        System.out.println("Hvad er det fulde navn på medlemmet der skal oprettes?");
        String navn = sc.nextLine();
        System.out.println("Hvilket år er medlemmet født i?");
        int fødselsår = readInteger(1);
        sc.nextLine();
        System.out.println("Hvad er medlemmets køn (mand/kvinde/andet)?");
        char køn = kønToChar(sc.nextLine());
        System.out.println("Hvilket år meldte medlemmet sig ind?");
        int indmeldelsesÅr = readInteger(2);
        sc.nextLine();
        System.out.println("Hvilken måned meldte medlemmet sig ind (1-12)?");
        int indmeldelsesMåned = readInteger(3);
        sc.nextLine();
        System.out.println("Hvilken dag meldte medlemmet sig ind (1-31)?");
        int indmeldelsesDag = readInteger(4);
        sc.nextLine();
        System.out.println("Hvad er medlemmets telefonnummer?");
        String tlfNummer = sc.nextLine();
        System.out.println("Hvad er medlemmets email?");
        String email = sc.nextLine();
        System.out.println("Hvad er medlemmets adresse?");
        String adresse = sc.nextLine();
        System.out.println("Er der tale om et aktivt eller passivt medlemskab?");
        String medlemskabsType = sc.nextLine();
        System.out.println("Er der tale om en motionist eller konkurrencesvømmer?");
        String aktivitetsNiveau = sc.nextLine();

        Medlem nytMedlem = new Medlem(navn, fødselsår, køn, indmeldelsesÅr, indmeldelsesMåned, indmeldelsesDag, tlfNummer, email, adresse, medlemskabsType, aktivitetsNiveau);
        controller.addMedlemToDatabase(nytMedlem);

        System.out.println("Medlemmet er nu oprettet i databasen");
    }

    private void editMedlem() {
        sc.nextLine();
        System.out.println("Hvad er navnet på medlemmet der skal opdateres");
        ArrayList<Medlem> foundMedlemmer = controller.searchMedlemByName(sc.nextLine());

        if (!foundMedlemmer.isEmpty()) {
            System.out.println("Tast nummeret på medlemmet du vil redigere: ");
            int searchNumber = sc.nextInt();
            sc.nextLine();
            Medlem medlemToBeEdited = foundMedlemmer.get(searchNumber - 1);

            System.out.println("Indtast nye oplysninger, ellers tast 'enter': " + '\n');

            System.out.println("Hvad er det fulde navn på medlemmet?");
            String navn = sc.nextLine();
            System.out.println("Hvilket år er medlemmet født i?");
            int fødselsår = readEmptyInteger(1);
            sc.nextLine();
            System.out.println("Hvad er medlemmets køn (mand/kvinde/andet)?");
            char køn = kønToChar(sc.nextLine());
            System.out.println("Hvilket år meldte medlemmet sig ind?");
            int indmeldelsesÅr = readEmptyInteger(2);
            sc.nextLine();
            System.out.println("Hvilken måned meldte medlemmet sig ind (1-12)?");
            int indmeldelsesMåned = readEmptyInteger(3);
            sc.nextLine();
            System.out.println("Hvilken dag meldte medlemmet sig ind (1-31)?");
            int indmeldelsesDag = readEmptyInteger(4);
            sc.nextLine();
            System.out.println("Hvad er medlemmets telefonnummer?");
            String tlfNummer = sc.nextLine();
            System.out.println("Hvad er medlemmets email?");
            String email = sc.nextLine();
            System.out.println("Hvad er medlemmets adresse?");
            String adresse = sc.nextLine();
            System.out.println("Er der tale om et aktivt eller passivt medlemskab?");
            String medlemskabsType = sc.nextLine();
            System.out.println("Er der tale om en motionist eller konkurrencesvømmer?");
            String aktivitetsNiveau = sc.nextLine();

            Medlem newMedlemInfo = new Medlem(navn, fødselsår, køn, indmeldelsesÅr, indmeldelsesMåned, indmeldelsesDag, tlfNummer, email, adresse, medlemskabsType, aktivitetsNiveau);
            controller.editMedlem(medlemToBeEdited, newMedlemInfo);

            System.out.println("Medlemmet er nu opdateret i databasen");
        } else {
            System.out.println("Der findes ingen medlemmer under det navn" + ".\n");
        }
    }

    private void deleteMedlem() {
        sc.nextLine();
        System.out.println("Hvad er navnet på medlemmet der skal slettes");
        ArrayList<Medlem> foundMedlemmer = controller.searchMedlemByName(sc.nextLine());

        if (!foundMedlemmer.isEmpty()) {
            System.out.println("Tast nummeret på medlemmet du vil redigere: ");
            int searchNumber = sc.nextInt();
            sc.nextLine();
            Medlem medlemToBeDeleted = foundMedlemmer.get(searchNumber - 1);
            controller.deleteMedlem(medlemToBeDeleted.getNavn());
            System.out.println("Medlemmet er nu slettet." + ".\n");
        } else {
            System.out.println("Et medlem med det navn kunne ikke findes.");
        }
    }

    private void updateMedlemRestanceStatus() {
        sc.nextLine();
        System.out.println("Hvad er navnet på medlemmet hvis restance status skal opdateres?");
        ArrayList<Medlem> foundMedlemmer = controller.searchMedlemByName(sc.nextLine());

        if (!foundMedlemmer.isEmpty()) {
            System.out.println("Tast nummeret på medlemmet du vil opdatere: ");
            int searchNumber = sc.nextInt();
            Medlem medlemToBeUpdated= foundMedlemmer.get(searchNumber - 1);
            sc.nextLine();
            System.out.println("Er medlemmet i restance? (ja/nej)");
            String status = sc.nextLine();
            if (status.equalsIgnoreCase("ja")) {
                medlemToBeUpdated.setRestance(true);
            } else if (status.equalsIgnoreCase("nej")) {
                medlemToBeUpdated.setRestance(false);
            }
            System.out.println("Medlemmets restance status er nu opdateret." + ".\n");
        } else {
            System.out.println("Et medlem med det navn kunne ikke findes.");
        }
    }


    //Helping methods
    private char kønToChar(String køn) {
        char kønChar;
        if (køn.equalsIgnoreCase("mand")) {
            kønChar = 'm';
        } else if (køn.equalsIgnoreCase("kvinde")) {
            kønChar = 'f';
        } else {
            kønChar = 'n';
        }
        return kønChar;
    }

    public int readInteger(int dataType) {
        String text;
        while (!sc.hasNextInt()) {
            text = sc.nextLine();
            System.out.println("Du skal skrive et heltal!");
        }
        int data = sc.nextInt();
        switch (dataType) {
            case 1 -> {
                boolean isCorrectBirthYear = false;
                while (!isCorrectBirthYear) {
                    if (data >= 1900 && data <= (LocalDateTime.now().getYear())) {
                        return data;
                    } else {
                        System.out.println("Ugyldigt fødselsår");
                        data = sc.nextInt();
                    }
                }
            }
            case 2 -> {
                boolean isCorrectYear = false;
                while (!isCorrectYear) {
                    if (data >= 1900 && data <= currentYear) {
                        return data;
                    } else {
                        System.out.println("Ugyldigt årstal");
                        data = sc.nextInt();

                    }
                }
            }
            case 3 -> {
                boolean isCorrectMonth = false;
                while (!isCorrectMonth) {
                    if (data >= 1 && data <= 12) {
                        return data;
                    } else {
                        System.out.println("Ugyldig måned");
                        data = sc.nextInt();
                    }
                }
            }
            case 4 -> {
                boolean isCorrectDay = false;
                while (!isCorrectDay) {
                    if (data >= 1 && data <= 31) {
                        return data;
                    } else {
                        System.out.println("Ugyldig dag");
                        data = sc.nextInt();
                    }
                }
            }
        }
        return data;
    }

    private int readEmptyInteger(int dataType) {
        String text = sc.nextLine();
        if (text.isEmpty()) {
            return 9999;
        } else {
            readInteger(dataType);
        }
        return 9999;
    }
}
