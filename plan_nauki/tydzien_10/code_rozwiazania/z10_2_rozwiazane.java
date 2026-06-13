package plan_nauki.tydzien_10.code_rozwiazania;

public class z10_2_rozwiazane {
    public static void main(String[] args) {
        GraczT10 g = new GraczT10("Bohater");

        g.ruch();  // Biega szybko
        g.skok();  // Skacze wysoko
        g.cios();  // Pelny cios! -> zmiana na Ranny

        g.ruch();  // Kuleje
        g.skok();  // Nie moze skoczyc
        g.cios();  // Slaby cios -> zmiana na Aktywny

        g.cios();  // Pelny cios! -> zmiana na Ranny (znowu)
        // zasniecie - tutaj Ranny nie zasypia, to tylko przyklad zmiany stanu
        g.setStatus(new SpiacyT10());
        g.ruch();  // spi 1/2
        g.skok();  // spi
        g.ruch();  // spi 2/2 -> budzi sie -> Aktywny
        g.ruch();  // Biega szybko
    }
}

interface StatusGraczaT10 {
    void ruch(GraczT10 g);
    void skok(GraczT10 g);
    void cios(GraczT10 g);
}

class AktywnyT10 implements StatusGraczaT10 {
    public void ruch(GraczT10 g) { System.out.println("Biega szybko"); }
    public void skok(GraczT10 g) { System.out.println("Skacze wysoko"); }
    public void cios(GraczT10 g) {
        System.out.println("Pelny cios!");
        g.setStatus(new RannyT10());
    }
}

class RannyT10 implements StatusGraczaT10 {
    public void ruch(GraczT10 g) { System.out.println("Kuleje"); }
    public void skok(GraczT10 g) { System.out.println("Nie moze skoczyc"); }
    public void cios(GraczT10 g) {
        System.out.println("Slaby cios");
        g.setStatus(new AktywnyT10());
    }
}

class SpiacyT10 implements StatusGraczaT10 {
    private int liczbaRuchow = 0;

    public void ruch(GraczT10 g) {
        liczbaRuchow++;
        System.out.println("Gracz spi... (" + liczbaRuchow + "/2)");
        if (liczbaRuchow >= 2) {
            System.out.println("Budzi sie!");
            g.setStatus(new AktywnyT10());
        }
    }
    public void skok(GraczT10 g) { System.out.println("Gracz spi"); }
    public void cios(GraczT10 g) { System.out.println("Gracz spi"); }
}

class GraczT10 {
    private final String imie;
    private StatusGraczaT10 status;

    public GraczT10(String imie) {
        this.imie = imie;
        this.status = new AktywnyT10();
    }

    public void ruch() { status.ruch(this); }
    public void skok() { status.skok(this); }
    public void cios() { status.cios(this); }

    public void setStatus(StatusGraczaT10 s) { this.status = s; }
    public String getImie() { return imie; }
}
