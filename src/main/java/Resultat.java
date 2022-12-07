public class Resultat {

    private Medlem medlem;
    private String disciplin;
    private String tid;

    public Resultat(Medlem medlem, String disciplin, String tid) {
        this.medlem = medlem;
        this.disciplin = disciplin;
        this.tid = tid;
    }

    public Medlem getMedlem() {
        return medlem;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public String getTid() {
        return tid;
    }
}
