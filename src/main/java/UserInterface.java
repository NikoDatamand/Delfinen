import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    // Controller controller = new Controller; // controller her, ikk'?

    public void loadUserInterface() {

        boolean isRunning = true;

        Intro();
        visMenu();

        while (isRunning) {
            switch () {
            case 1:
                //valg 1//
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
                //valg 9//
                break;

            }
        }

        private void Intro() {
            System.out.println("Velkommen til svømmeklubben Delfinen");
        }

        public void visMenu() {
            System.out.println("""
                    1.
                    2.
                    3.
                    4.
                    5.
                    9.
                    """);
        }
    }
}
