package plan_nauki.tydzien_09;

// Z9.1 - Prosty wyjatek
// NiedodatniaDlugoscWyjatek extends RuntimeException
// Prostokat rzuca go gdy szerokosc lub wysokosc <= 0

public class z9_1 {
    public static void main(String[] args) {
        // TODO: sprobuj stworzyc Prostokat z ujemnym wymiarem i wychwyc wyjatek
    }
}

class NiedodatniaDlugoscWyjatek extends RuntimeException {
    // TODO: konstruktor z komunikatem
}

class ProstokatZ9 {
    private final double szerokosc;
    private final double wysokosc;

    public ProstokatZ9(double szerokosc, double wysokosc) {
        // TODO: sprawdz warunki, rzuc wyjatek jesli <= 0
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    public double pole()   { return szerokosc * wysokosc; }
    public double obwod()  { return 2 * (szerokosc + wysokosc); }
}
