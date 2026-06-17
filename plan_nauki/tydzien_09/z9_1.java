package plan_nauki.tydzien_09;

// Z9.1 - Prosty wyjatek
// NiedodatniaDlugoscWyjatek extends RuntimeException
// Prostokat rzuca go gdy szerokosc lub wysokosc <= 0

public class z9_1 {
    public static void main(String[] args) {
        // poprawny prostokat - dziala normalnie
        ProstokatZ9 ok = new ProstokatZ9(5, 3);
        System.out.println("Pole: " + ok.pole());

        // zly wymiar - rzuci wyjatek, lapiemy go w catch
        try {
            ProstokatZ9 zly = new ProstokatZ9(-5, 10);
            System.out.println("Pole: " + zly.pole());   // tu NIE dojdzie
        } catch (NiedodatniaDlugoscWyjatek e) {
            System.out.println("Zlapano blad: " + e.getMessage());
        }
    }
}

class NiedodatniaDlugoscWyjatek extends RuntimeException {
    public NiedodatniaDlugoscWyjatek(String komunikat) {
        super(komunikat);   // przekazuje komunikat dalej (getMessage() go zwroci)
    }
}

class ProstokatZ9 {
    private final double szerokosc;
    private final double wysokosc;

    public ProstokatZ9(double szerokosc, double wysokosc) {
        if (szerokosc <= 0 || wysokosc <= 0) {
            throw new NiedodatniaDlugoscWyjatek("Wymiary musza byc dodatnie, podano: "
                + szerokosc + " x " + wysokosc);
        }
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    public double pole()   { return szerokosc * wysokosc; }
    public double obwod()  { return 2 * (szerokosc + wysokosc); }
}
