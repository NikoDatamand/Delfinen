import java.time.LocalDateTime;
import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    Controller controller = new Controller();
    private int currentYear = LocalDateTime.now().getYear();

    public void loadUserInterface() {

        boolean isRunning = true;

        while (isRunning) {

            Intro();
            Menu();

        }
    }

    private void Intro() {
        System.out.println("""
                                
                Velkommen til svømmeklubben 'Delfinen'
                                
                1. Opret medlem
                2. Vis alle medlemmer
                9. Afslut
                """);
    }

    private void Menu() {
        switch (sc.nextInt()) {
            case 1:
                createMedlem();
                break;
            case 2:
                controller.showMedlemmer();
                break;
            case 3:
                //valg 3//
                break;
            case 4:
                //valg 4//
                break;
            case 5:
                //valg 5//
                break;
            case 9:
                System.exit(0);
                break;
        }
    }

    private void createMedlem() {
        sc.nextLine();
        System.out.println("Hvad er det fulde navn på medlemmet der skal oprettes?");
        String navn = sc.nextLine();
        System.out.println("Hvad er medlemmets alder?");
        int alder = readInteger(1);
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
        System.out.println("Er der tale om et aktivt eller passivt medlemskab?");
        String medlemskabsType = sc.nextLine();
        System.out.println("Er der tale om en motionist eller konkurrencesvømmer?");
        String aktivitetsNiveau = sc.nextLine();

        Medlem nytMedlem = new Medlem(navn, alder, køn, indmeldelsesÅr, indmeldelsesMåned, indmeldelsesDag, medlemskabsType, aktivitetsNiveau);
        controller.addMedlemToDatabase(nytMedlem);

        System.out.println("Medlemmet er nu oprettet i databasen");
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
        while (!sc.hasNextInt()) {
            String text = sc.nextLine();
            System.out.println("Du skal skrive et heltal!");
        }
        int data = sc.nextInt();
        switch (dataType) {
            case 1 -> {
                boolean isCorrectAge = false;
                while (!isCorrectAge) {
                    if (data >= 0 && data <= 150) {
                        return data;
                    } else {
                        System.out.println("Ugyldig alder");
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
}
