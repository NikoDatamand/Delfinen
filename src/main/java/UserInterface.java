import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    Controller controller = new Controller();

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
                9. Afslut
                """);
    }

    private void Menu() {
        switch (sc.nextInt()) {
            case 1:
                createMedlem();
                break;
            case 2:
                //valg 2//
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
        int alder = sc.nextInt();
        sc.nextLine();
        System.out.println("Hvad er medlemmets køn (mand/kvinde/andet)?");
        char køn = kønToChar(sc.nextLine());
        System.out.println("Hvilket år meldte medlemmet sig ind?");
        int indmeldelsesÅr = sc.nextInt();
        sc.nextLine();
        System.out.println("Hvilken måned meldte medlemmet sig ind (1-12)?");
        int indmeldelsesMåned = sc.nextInt();
        sc.nextLine();
        System.out.println("Hvilken dag meldte medlemmet sig ind (1-31)?");
        int indmeldelsesDag = sc.nextInt();
        sc.nextLine();
        System.out.println("Er der tale om et aktivt eller passivt medlemskab?");
        String medlemskabsType = sc.nextLine();
        System.out.println("Er der tale om en motionist eller konkurrencesvømmer?");
        String aktivitetsNiveau = sc.nextLine();

        Medlem nytMedlem = new Medlem(navn, alder, køn, indmeldelsesÅr, indmeldelsesMåned, indmeldelsesDag, medlemskabsType, aktivitetsNiveau);

        controller.addMedlemToDatabase(nytMedlem);
    }

    private char kønToChar(String køn){
        char kønChar;
        if (køn.equalsIgnoreCase("mand")){
            kønChar = 'm';
        } else if (køn.equalsIgnoreCase("kvinde")){
            kønChar = 'f';
        } else {
            kønChar = 'n';
        }
        return kønChar;
    }
}
