package plan_nauki.tydzien_04.code_rozwiazania;

public class z4_1_rozwiazane {
    public static void main(String[] args) {
        ProstokatT4 p = new ProstokatT4(5, 3);
        System.out.println(p);
        System.out.println("Pole: " + p.pole());
        System.out.println("Obwod: " + p.obwod());

        try {
            new ProstokatT4(-1, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Blad: " + e.getMessage());
        }
    }
}

class ProstokatT4 {
    private final double szerokosc;
    private final double wysokosc;

    public ProstokatT4(double szerokosc, double wysokosc) {
        if (szerokosc <= 0 || wysokosc <= 0) {
            throw new IllegalArgumentException("Wymiary musza byc dodatnie");
        }
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    public double getSzerokosc() { return szerokosc; }
    public double getWysokosc()  { return wysokosc; }
    public double pole()         { return szerokosc * wysokosc; }
    public double obwod()        { return 2 * (szerokosc + wysokosc); }

    @Override
    public String toString() {
        return "Prostokat(" + szerokosc + "x" + wysokosc + ")";
    }
}
